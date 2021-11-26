package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.mopub.common.AdFormat;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.LocationService;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.ViewabilityVendor;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.AdData;
import com.mopub.mobileads.AdLifecycleListener;
import com.mopub.network.AdLoader;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.SingleImpression;
import com.mopub.network.TrackingRequest;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.WeakHashMap;

public class AdViewController implements AdLifecycleListener.LoadListener, AdLifecycleListener.InteractionListener {
    private static final FrameLayout.LayoutParams WRAP_AND_CENTER_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-2, -2, 17);
    private static final WeakHashMap<View, Boolean> sViewShouldHonorServerDimensions = new WeakHashMap<>();
    private Request mActiveRequest;
    private AdAdapter mAdAdapter;
    private final AdLoader.Listener mAdListener;
    AdLoader mAdLoader;
    private AdResponse mAdResponse;
    private String mAdUnitId;
    private boolean mAdWasLoaded;
    @VisibleForTesting
    int mBackoffPower = 1;
    private String mBaseAdClassName;
    private final long mBroadcastIdentifier;
    private Context mContext;
    private boolean mCurrentAutoRefreshStatus = true;
    private Handler mHandler;
    private boolean mHasOverlay;
    private boolean mIsDestroyed;
    private boolean mIsTesting;
    private String mKeywords;
    private String mLastTrackedRequestId;
    private Map<String, Object> mLocalExtras = new HashMap();
    private MoPubAd mMoPubAd;
    private long mOnPauseViewedTimeMillis;
    private final Runnable mRefreshRunnable;
    private Integer mRefreshTimeMillis;
    private Point mRequestedAdSize;
    private boolean mShouldAllowAutoRefresh = true;
    private long mShowStartedTimestampMillis;
    private WebViewAdUrlGenerator mUrlGenerator;
    private String mUserDataKeywords;
    private WindowInsets mWindowInsets;

    public void setLocation(Location location) {
    }

    public static void setShouldHonorServerDimensions(View view) {
        sViewShouldHonorServerDimensions.put(view, Boolean.TRUE);
    }

    private static boolean getShouldHonorServerDimensions(View view) {
        return sViewShouldHonorServerDimensions.get(view) != null;
    }

    public AdViewController(Context context, MoPubAd moPubAd) {
        this.mContext = context;
        this.mMoPubAd = moPubAd;
        this.mBroadcastIdentifier = Utils.generateUniqueId();
        this.mUrlGenerator = new WebViewAdUrlGenerator(this.mContext.getApplicationContext());
        this.mAdListener = new AdLoader.Listener() {
            public void onSuccess(AdResponse adResponse) {
                AdViewController.this.onAdLoadSuccess(adResponse);
            }

            public void onErrorResponse(VolleyError volleyError) {
                AdViewController.this.onAdLoadError(volleyError);
            }
        };
        this.mRefreshRunnable = new Runnable() {
            public void run() {
                MoPubAd moPubAd = AdViewController.this.getMoPubAd();
                if (moPubAd != null) {
                    AdViewController.this.setRequestedAdSize(moPubAd.resolveAdSize());
                }
                AdViewController.this.internalLoadAd();
            }
        };
        this.mOnPauseViewedTimeMillis = 0;
        this.mRefreshTimeMillis = 60000;
        this.mHandler = new Handler();
        this.mLastTrackedRequestId = "";
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void onAdLoadSuccess(AdResponse adResponse) {
        this.mBackoffPower = 1;
        this.mAdResponse = adResponse;
        this.mBaseAdClassName = adResponse.getBaseAdClassName();
        this.mRefreshTimeMillis = this.mAdResponse.getRefreshTimeMillis();
        this.mActiveRequest = null;
        loadBaseAd();
        scheduleRefreshTimerIfEnabled();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void onAdLoadError(VolleyError volleyError) {
        if (volleyError instanceof MoPubNetworkError) {
            MoPubNetworkError moPubNetworkError = (MoPubNetworkError) volleyError;
            if (moPubNetworkError.getRefreshTimeMillis() != null) {
                this.mRefreshTimeMillis = moPubNetworkError.getRefreshTimeMillis();
            }
        }
        MoPubErrorCode errorCodeFromVolleyError = getErrorCodeFromVolleyError(volleyError, this.mContext);
        if (errorCodeFromVolleyError == MoPubErrorCode.SERVER_ERROR) {
            this.mBackoffPower++;
        }
        adDidFail(errorCodeFromVolleyError);
    }

    @VisibleForTesting
    static MoPubErrorCode getErrorCodeFromVolleyError(VolleyError volleyError, Context context) {
        NetworkResponse networkResponse = volleyError.networkResponse;
        if (volleyError instanceof MoPubNetworkError) {
            int i = C25194.$SwitchMap$com$mopub$network$MoPubNetworkError$Reason[((MoPubNetworkError) volleyError).getReason().ordinal()];
            if (i == 1) {
                return MoPubErrorCode.WARMUP;
            }
            if (i == 2) {
                return MoPubErrorCode.NO_FILL;
            }
            if (i != 3) {
                return MoPubErrorCode.UNSPECIFIED;
            }
            return MoPubErrorCode.TOO_MANY_REQUESTS;
        } else if (networkResponse == null) {
            if (!DeviceUtils.isNetworkAvailable(context)) {
                return MoPubErrorCode.NO_CONNECTION;
            }
            return MoPubErrorCode.UNSPECIFIED;
        } else if (networkResponse.statusCode >= 400) {
            return MoPubErrorCode.SERVER_ERROR;
        } else {
            return MoPubErrorCode.UNSPECIFIED;
        }
    }

    /* renamed from: com.mopub.mobileads.AdViewController$4 */
    static /* synthetic */ class C25194 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$network$MoPubNetworkError$Reason;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.mopub.network.MoPubNetworkError$Reason[] r0 = com.mopub.network.MoPubNetworkError.Reason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = r0
                com.mopub.network.MoPubNetworkError$Reason r1 = com.mopub.network.MoPubNetworkError.Reason.WARMING_UP     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$mopub$network$MoPubNetworkError$Reason     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.network.MoPubNetworkError$Reason r1 = com.mopub.network.MoPubNetworkError.Reason.NO_FILL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$mopub$network$MoPubNetworkError$Reason     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.network.MoPubNetworkError$Reason r1 = com.mopub.network.MoPubNetworkError.Reason.TOO_MANY_REQUESTS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AdViewController.C25194.<clinit>():void");
        }
    }

    public MoPubAd getMoPubAd() {
        return this.mMoPubAd;
    }

    public AdAdapter getAdAdapter() {
        return this.mAdAdapter;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void loadAd() {
        this.mBackoffPower = 1;
        internalLoadAd();
    }

    /* access modifiers changed from: private */
    public void internalLoadAd() {
        this.mAdWasLoaded = true;
        if (TextUtils.isEmpty(this.mAdUnitId)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Can't load an ad in this ad view because the ad unit ID is not set. Did you forget to call setAdUnitId()?");
            adDidFail(MoPubErrorCode.MISSING_AD_UNIT_ID);
        } else if (!isNetworkAvailable()) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Can't load an ad because there is no network connectivity.");
            adDidFail(MoPubErrorCode.NO_CONNECTION);
        } else {
            loadNonJavascript(generateAdUrl(), (MoPubError) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void loadNonJavascript(String str, MoPubError moPubError) {
        if (str == null) {
            adDidFail(MoPubErrorCode.NO_FILL);
            return;
        }
        if (!str.startsWith("javascript:")) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent, "Loading url: " + str);
        }
        if (this.mActiveRequest == null) {
            fetchAd(str, moPubError);
        } else if (!TextUtils.isEmpty(this.mAdUnitId)) {
            MoPubLog.SdkLogEvent sdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
            MoPubLog.log(sdkLogEvent2, "Already loading an ad for " + this.mAdUnitId + ", wait to finish.");
        }
    }

    @Deprecated
    public void reload() {
        loadAd();
    }

    /* access modifiers changed from: package-private */
    public boolean loadFailUrl(MoPubErrorCode moPubErrorCode) {
        if (moPubErrorCode == null) {
            MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE;
            MoPubErrorCode moPubErrorCode2 = MoPubErrorCode.UNSPECIFIED;
            MoPubLog.log(sdkLogEvent, "Load failed.", Integer.valueOf(moPubErrorCode2.getIntCode()), moPubErrorCode2);
        } else {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE, "Load failed.", moPubErrorCode, Integer.valueOf(moPubErrorCode.getIntCode()));
        }
        AdLoader adLoader = this.mAdLoader;
        if (adLoader == null || !adLoader.hasMoreAds()) {
            adDidFail(MoPubErrorCode.NO_FILL);
            return false;
        }
        loadNonJavascript("", moPubErrorCode);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setNotLoading() {
        Request request = this.mActiveRequest;
        if (request != null) {
            if (!request.isCanceled()) {
                this.mActiveRequest.cancel();
            }
            this.mActiveRequest = null;
        }
        this.mAdLoader = null;
    }

    public String getKeywords() {
        return this.mKeywords;
    }

    public void setKeywords(String str) {
        this.mKeywords = str;
    }

    public String getUserDataKeywords() {
        if (!MoPub.canCollectPersonalInformation()) {
            return null;
        }
        return this.mUserDataKeywords;
    }

    public void setUserDataKeywords(String str) {
        if (!MoPub.canCollectPersonalInformation()) {
            this.mUserDataKeywords = null;
        } else {
            this.mUserDataKeywords = str;
        }
    }

    public Location getLocation() {
        return LocationService.getLastKnownLocation(this.mContext);
    }

    /* access modifiers changed from: package-private */
    public void setRequestedAdSize(Point point) {
        this.mRequestedAdSize = point;
    }

    public void setWindowInsets(WindowInsets windowInsets) {
        this.mWindowInsets = windowInsets;
    }

    public String getAdUnitId() {
        return this.mAdUnitId;
    }

    public String getBaseAdClassName() {
        return this.mBaseAdClassName;
    }

    public void setAdUnitId(String str) {
        this.mAdUnitId = str;
    }

    public long getBroadcastIdentifier() {
        return this.mBroadcastIdentifier;
    }

    public int getAdWidth() {
        AdResponse adResponse = this.mAdResponse;
        if (adResponse == null || adResponse.getWidth() == null) {
            return 0;
        }
        return this.mAdResponse.getWidth().intValue();
    }

    public int getAdHeight() {
        AdResponse adResponse = this.mAdResponse;
        if (adResponse == null || adResponse.getHeight() == null) {
            return 0;
        }
        return this.mAdResponse.getHeight().intValue();
    }

    @Deprecated
    public boolean getAutorefreshEnabled() {
        return getCurrentAutoRefreshStatus();
    }

    public boolean getCurrentAutoRefreshStatus() {
        return this.mCurrentAutoRefreshStatus;
    }

    /* access modifiers changed from: package-private */
    public void pauseRefresh() {
        setAutoRefreshStatus(false);
    }

    /* access modifiers changed from: package-private */
    public void resumeRefresh() {
        if (this.mShouldAllowAutoRefresh && !this.mHasOverlay) {
            setAutoRefreshStatus(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void setShouldAllowAutoRefresh(boolean z) {
        this.mShouldAllowAutoRefresh = z;
        setAutoRefreshStatus(z);
    }

    private void setAutoRefreshStatus(boolean z) {
        if (this.mAdWasLoaded && this.mCurrentAutoRefreshStatus != z) {
            String str = z ? "enabled" : "disabled";
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Refresh " + str + " for ad unit (" + this.mAdUnitId + ").");
        }
        this.mCurrentAutoRefreshStatus = z;
        if (this.mAdWasLoaded && z) {
            this.mShowStartedTimestampMillis = SystemClock.uptimeMillis();
            scheduleRefreshTimerIfEnabled();
        } else if (!z) {
            this.mOnPauseViewedTimeMillis += SystemClock.uptimeMillis() - this.mShowStartedTimestampMillis;
            cancelRefreshTimer();
        }
    }

    /* access modifiers changed from: package-private */
    public void engageOverlay() {
        this.mHasOverlay = true;
        pauseRefresh();
    }

    /* access modifiers changed from: package-private */
    public void dismissOverlay() {
        this.mHasOverlay = false;
        resumeRefresh();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.mAdResponse;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDspCreativeId() {
        /*
            r1 = this;
            java.lang.String r0 = r1.mAdUnitId
            if (r0 == 0) goto L_0x000d
            com.mopub.network.AdResponse r0 = r1.mAdResponse
            if (r0 == 0) goto L_0x000d
            java.lang.String r0 = r0.getDspCreativeId()
            return r0
        L_0x000d:
            java.lang.String r0 = ""
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.AdViewController.getDspCreativeId():java.lang.String");
    }

    public boolean getAllowCustomClose() {
        AdResponse adResponse = this.mAdResponse;
        if (adResponse == null) {
            return false;
        }
        return adResponse.allowCustomClose();
    }

    public String getFullAdType() {
        AdResponse adResponse = this.mAdResponse;
        if (adResponse == null) {
            return null;
        }
        return adResponse.getFullAdType();
    }

    public boolean getTesting() {
        return this.mIsTesting;
    }

    public void setTesting(boolean z) {
        this.mIsTesting = z;
    }

    /* access modifiers changed from: package-private */
    public void cleanup() {
        if (!this.mIsDestroyed) {
            setNotLoading();
            setAutoRefreshStatus(false);
            cancelRefreshTimer();
            invalidateAdapter();
            this.mMoPubAd = null;
            this.mContext = null;
            this.mUrlGenerator = null;
            this.mLastTrackedRequestId = "";
            this.mIsDestroyed = true;
        }
    }

    /* access modifiers changed from: package-private */
    public Integer getAdTimeoutDelay(AdFormat adFormat) {
        int i = adFormat == AdFormat.BANNER ? 10000 : 30000;
        AdResponse adResponse = this.mAdResponse;
        if (adResponse == null) {
            return Integer.valueOf(i);
        }
        return adResponse.getAdTimeoutMillis(i);
    }

    /* access modifiers changed from: package-private */
    public void registerClick() {
        AdResponse adResponse = this.mAdResponse;
        if (adResponse != null) {
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) adResponse.getClickTrackingUrls(), this.mContext);
        }
    }

    /* access modifiers changed from: package-private */
    public void fetchAd(String str, MoPubError moPubError) {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd == null || this.mContext == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Can't load an ad in this ad view because it was destroyed.");
            setNotLoading();
            return;
        }
        synchronized (this) {
            AdLoader adLoader = this.mAdLoader;
            if (adLoader == null || !adLoader.hasMoreAds()) {
                this.mAdLoader = new AdLoader(str, moPubAd.getAdFormat(), this.mAdUnitId, this.mContext, this.mAdListener);
            }
        }
        this.mActiveRequest = this.mAdLoader.loadNextAd(moPubError);
    }

    /* access modifiers changed from: package-private */
    public void forceRefresh() {
        invalidateAdapter();
        setNotLoading();
        loadAd();
    }

    /* access modifiers changed from: protected */
    public void invalidateAdapter() {
        AdAdapter adAdapter = getAdAdapter();
        if (adAdapter != null) {
            adAdapter.invalidate();
            this.mAdAdapter = null;
        }
    }

    /* access modifiers changed from: package-private */
    public String generateAdUrl() {
        String str = null;
        if (this.mUrlGenerator == null) {
            return null;
        }
        boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
        AdUrlGenerator withKeywords = this.mUrlGenerator.withAdUnitId(this.mAdUnitId).withKeywords(this.mKeywords);
        if (canCollectPersonalInformation) {
            str = this.mUserDataKeywords;
        }
        withKeywords.withUserDataKeywords(str).withRequestedAdSize(this.mRequestedAdSize).withWindowInsets(this.mWindowInsets);
        return this.mUrlGenerator.generateUrlString(Constants.HOST);
    }

    /* access modifiers changed from: package-private */
    public void adDidFail(MoPubErrorCode moPubErrorCode) {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Ad failed to load.");
        setNotLoading();
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            if (!TextUtils.isEmpty(this.mAdUnitId)) {
                scheduleRefreshTimerIfEnabled();
            }
            moPubAd.onAdLoadFailed(moPubErrorCode);
        }
    }

    /* access modifiers changed from: package-private */
    public void scheduleRefreshTimerIfEnabled() {
        Integer num;
        cancelRefreshTimer();
        if (this.mCurrentAutoRefreshStatus && (num = this.mRefreshTimeMillis) != null && num.intValue() > 0) {
            long min = Math.min(600000, ((long) this.mRefreshTimeMillis.intValue()) * ((long) Math.pow(1.5d, (double) this.mBackoffPower)));
            long j = min - this.mOnPauseViewedTimeMillis;
            if (j >= 0) {
                min = j;
            }
            this.mHandler.postDelayed(this.mRefreshRunnable, min);
        }
    }

    /* access modifiers changed from: package-private */
    public void setLocalExtras(Map<String, Object> map) {
        TreeMap treeMap;
        if (map == null) {
            treeMap = new TreeMap();
        }
        this.mLocalExtras = treeMap;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Object> getLocalExtras() {
        return this.mLocalExtras != null ? new TreeMap(this.mLocalExtras) : new TreeMap();
    }

    private void cancelRefreshTimer() {
        this.mHandler.removeCallbacks(this.mRefreshRunnable);
    }

    @SuppressLint({"MissingPermission"})
    private boolean isNetworkAvailable() {
        Context context = this.mContext;
        if (context == null) {
            return false;
        }
        if (!DeviceUtils.isPermissionGranted(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        NetworkInfo networkInfo = null;
        if (connectivityManager != null) {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public void setAdContentView(final View view) {
        final MoPubAd moPubAd = getMoPubAd();
        if (moPubAd instanceof MoPubView) {
            this.mHandler.post(new Runnable() {
                public void run() {
                    ((MoPubView) moPubAd).removeAllViews();
                    View view = view;
                    ((MoPubView) moPubAd).addView(view, AdViewController.this.getAdLayoutParams(view));
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public FrameLayout.LayoutParams getAdLayoutParams(View view) {
        Integer num;
        AdResponse adResponse = this.mAdResponse;
        Integer num2 = null;
        if (adResponse != null) {
            num2 = adResponse.getWidth();
            num = this.mAdResponse.getHeight();
        } else {
            num = null;
        }
        if (num2 == null || num == null || !getShouldHonorServerDimensions(view) || num2.intValue() <= 0 || num.intValue() <= 0 || this.mContext == null) {
            return WRAP_AND_CENTER_LAYOUT_PARAMS;
        }
        return new FrameLayout.LayoutParams(Dips.asIntPixels((float) num2.intValue(), this.mContext), Dips.asIntPixels((float) num.intValue(), this.mContext), 17);
    }

    /* access modifiers changed from: protected */
    public void loadBaseAd() {
        String baseAdClassName = this.mAdResponse.getBaseAdClassName();
        Map<String, String> serverExtras = this.mAdResponse.getServerExtras();
        String adType = this.mAdResponse.getAdType();
        String fullAdType = this.mAdResponse.getFullAdType();
        String impressionMinVisibleDips = this.mAdResponse.getImpressionMinVisibleDips();
        String impressionMinVisibleMs = this.mAdResponse.getImpressionMinVisibleMs();
        boolean allowCustomClose = this.mAdResponse.allowCustomClose();
        Set<ViewabilityVendor> viewabilityVendors = this.mAdResponse.getViewabilityVendors();
        Preconditions.checkNotNull(serverExtras);
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Can't load an ad in this ad view because it was destroyed.");
            loadFailUrl(MoPubErrorCode.INTERNAL_ERROR);
        } else if (TextUtils.isEmpty(baseAdClassName)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Couldn't invoke base ad because the server did not specify one.");
            loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
        } else {
            invalidateAdapter();
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Loading ad adapter.");
            TreeMap treeMap = new TreeMap(serverExtras);
            for (String next : this.mLocalExtras.keySet()) {
                Object obj = this.mLocalExtras.get(next);
                if (obj != null && !treeMap.containsKey(next)) {
                    treeMap.put(next, obj.toString());
                }
            }
            String str = moPubAd.getAdFormat() == AdFormat.BANNER ? "com.mopub.mobileads.InlineAdAdapter" : "com.mopub.mobileads.FullscreenAdAdapter";
            String remove = serverExtras.remove(DataKeys.HTML_RESPONSE_BODY_KEY);
            AdData.Builder dspCreativeId = new AdData.Builder().extras(treeMap).broadcastIdentifier(getBroadcastIdentifier()).timeoutDelayMillis(getAdTimeoutDelay(moPubAd.getAdFormat()).intValue()).impressionMinVisibleDips(impressionMinVisibleDips).impressionMinVisibleMs(impressionMinVisibleMs).dspCreativeId(getDspCreativeId());
            if (remove == null) {
                remove = "";
            }
            AdData build = dspCreativeId.adPayload(remove).adWidth(Integer.valueOf(getAdWidth())).adHeight(Integer.valueOf(getAdHeight())).adType(adType).fullAdType(fullAdType).allowCustomClose(allowCustomClose).viewabilityVendors(viewabilityVendors).build();
            if (Reflection.classFound(str)) {
                try {
                    Constructor<? extends U> declaredConstructor = Class.forName(str).asSubclass(AdAdapter.class).getDeclaredConstructor(new Class[]{Context.class, String.class, AdData.class});
                    declaredConstructor.setAccessible(true);
                    AdAdapter adAdapter = (AdAdapter) declaredConstructor.newInstance(new Object[]{this.mContext, baseAdClassName, build});
                    this.mAdAdapter = adAdapter;
                    adAdapter.load(this);
                } catch (Exception e) {
                    MoPubLog.log(MoPubLog.SdkLogEvent.ERROR_WITH_THROWABLE, "Error loading ad adapter", e);
                    loadFailUrl(MoPubErrorCode.ADAPTER_NOT_FOUND);
                }
            } else {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM_WITH_THROWABLE;
                MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_NOT_FOUND;
                MoPubLog.log(sdkLogEvent, "Could not load adapter", moPubErrorCode, Integer.valueOf(moPubErrorCode.getIntCode()));
                loadFailUrl(moPubErrorCode);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void show() {
        this.mOnPauseViewedTimeMillis = 0;
        this.mShowStartedTimestampMillis = SystemClock.uptimeMillis();
        AdAdapter adAdapter = getAdAdapter();
        if (adAdapter != null) {
            adAdapter.setInteractionListener(this);
            adAdapter.show(getMoPubAd());
        }
    }

    public void onAdLoaded() {
        scheduleRefreshTimerIfEnabled();
        AdLoader adLoader = this.mAdLoader;
        if (adLoader != null) {
            adLoader.creativeDownloadSuccess();
            this.mAdLoader = null;
        } else {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "mAdLoader is not supposed to be null");
        }
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdLoaded();
        }
    }

    public void onAdLoadFailed(MoPubErrorCode moPubErrorCode) {
        if (!loadFailUrl(moPubErrorCode)) {
            adDidFail(moPubErrorCode);
        }
    }

    public void onAdFailed(MoPubErrorCode moPubErrorCode) {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdFailed(moPubErrorCode);
        }
    }

    public void onAdShown() {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdShown();
        }
    }

    public void onAdClicked() {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdClicked();
        }
    }

    public void onAdImpression() {
        AdResponse adResponse = this.mAdResponse;
        if (adResponse != null) {
            String requestId = adResponse.getRequestId();
            if (this.mLastTrackedRequestId.equals(requestId)) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Ignoring duplicate impression.");
                return;
            }
            if (requestId != null) {
                this.mLastTrackedRequestId = requestId;
            }
            TrackingRequest.makeTrackingHttpRequest((Iterable<String>) this.mAdResponse.getImpressionTrackingUrls(), this.mContext);
            new SingleImpression(this.mAdResponse.getAdUnitId(), this.mAdResponse.getImpressionData()).sendImpression();
        }
    }

    public void onAdDismissed() {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdDismissed();
        }
    }

    public void onAdComplete(MoPubReward moPubReward) {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdComplete(moPubReward);
        }
    }

    public void onAdResumeAutoRefresh() {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdResumeAutoRefresh();
        }
    }

    public void onAdPauseAutoRefresh() {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdPauseAutoRefresh();
        }
    }

    public void onAdExpanded() {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdExpanded();
        }
    }

    public void onAdCollapsed() {
        MoPubAd moPubAd = getMoPubAd();
        if (moPubAd != null) {
            moPubAd.onAdCollapsed();
        }
    }

    @VisibleForTesting
    public void setMoPubAd(MoPubAd moPubAd) {
        this.mMoPubAd = moPubAd;
    }

    @VisibleForTesting
    public void setAdResponse(AdResponse adResponse) {
        this.mAdResponse = adResponse;
    }
}
