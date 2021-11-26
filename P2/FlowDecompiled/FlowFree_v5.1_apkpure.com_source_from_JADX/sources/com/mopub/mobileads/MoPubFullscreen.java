package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.mopub.common.AdType;
import com.mopub.common.CacheService;
import com.mopub.common.CreativeOrientation;
import com.mopub.common.DataKeys;
import com.mopub.common.FullAdType;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import com.mopub.mobileads.BaseHtmlWebView;
import com.mopub.mobileads.MoPubWebViewController;
import com.mopub.mobileads.VastManager;
import com.mopub.mobileads.factories.HtmlControllerFactory;
import com.mopub.mobileads.factories.VastManagerFactory;
import com.mopub.mraid.MraidBridge;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.PlacementType;
import com.mopub.network.C2676Networking;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubFullscreen extends BaseAd implements VastManager.VastManagerListener {
    public static final String ADAPTER_NAME = "MoPubFullscreen";
    AdData mAdData;
    private Runnable mAdExpiration;
    private long mBroadcastIdentifier;
    private EventForwardingBroadcastReceiver mBroadcastReceiver;
    private Context mContext;
    private Handler mHandler;
    private boolean mReady;
    private VastManager mVastManager;
    private JSONObject mVideoTrackers;

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(this.mLoadListener);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adapterLogEvent, str);
        this.mContext = context;
        this.mAdData = adData;
        extractExtras(adData.getExtras());
        try {
            this.mBroadcastIdentifier = adData.getBroadcastIdentifier();
            preRender();
            MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_SUCCESS, str);
        } catch (ClassCastException unused) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, "LocalExtras contained an incorrect type.");
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
            MoPubLog.log(adapterLogEvent2, ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            this.mLoadListener.onAdLoadFailed(moPubErrorCode);
        }
    }

    public String getAdNetworkId() {
        Class<MoPubFullscreen> cls = MoPubFullscreen.class;
        String name = cls.getName();
        AdData adData = this.mAdData;
        if (adData != null && !TextUtils.isEmpty(adData.getAdUnit())) {
            name = this.mAdData.getAdUnit();
        }
        if (cls.getName().equals(name)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Called getAdNetworkId before load() or no ad unit associated. Returning class name.");
        }
        return name;
    }

    /* access modifiers changed from: protected */
    public void extractExtras(Map<String, String> map) {
        AdData adData = this.mAdData;
        if (adData != null) {
            adData.setOrientation(CreativeOrientation.fromString(map.get(DataKeys.CREATIVE_ORIENTATION_KEY)));
            String str = map.get(DataKeys.VIDEO_TRACKERS_KEY);
            if (!TextUtils.isEmpty(str)) {
                try {
                    this.mVideoTrackers = new JSONObject(str);
                } catch (JSONException e) {
                    MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE;
                    MoPubLog.log(adapterLogEvent, "Failed to parse video trackers to JSON: " + str, e);
                    this.mVideoTrackers = null;
                }
            }
        } else {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, "Error extracting extras due to null ad data.");
            throw new IllegalStateException("Ad Data cannot be null here.");
        }
    }

    /* access modifiers changed from: protected */
    public void preRender() {
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adapterLogEvent, str);
        if (!CacheService.initializeDiskCache(this.mContext)) {
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.VIDEO_CACHE_ERROR;
            MoPubLog.log(adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            this.mLoadListener.onAdLoadFailed(moPubErrorCode);
        } else if (this.mAdData == null) {
            this.mLoadListener.onAdLoadFailed(MoPubErrorCode.NETWORK_INVALID_STATE);
        } else {
            this.mHandler = new Handler();
            this.mAdExpiration = new Runnable() {
                public final void run() {
                    MoPubFullscreen.this.lambda$preRender$0$MoPubFullscreen();
                }
            };
            if (FullAdType.VAST.equals(this.mAdData.getFullAdType())) {
                VastManager create = VastManagerFactory.create(this.mContext);
                this.mVastManager = create;
                create.prepareVastVideoConfiguration(this.mAdData.getAdPayload(), this, this.mAdData.getDspCreativeId(), this.mContext);
            } else if ("json".equals(this.mAdData.getFullAdType())) {
                preRenderJson(this.mContext, this.mAdData);
            } else {
                preRenderWeb(this.mContext, this.mAdData);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: lambda$preRender$0 */
    public /* synthetic */ void lambda$preRender$0$MoPubFullscreen() {
        MoPubLog.log(MoPubLog.AdapterLogEvent.EXPIRED, ADAPTER_NAME, "time in seconds");
        this.mLoadListener.onAdLoadFailed(MoPubErrorCode.EXPIRED);
        onInvalidate();
    }

    public void preRenderWeb(Context context, AdData adData) {
        MoPubWebViewController moPubWebViewController;
        BaseWebView baseWebView;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        Long valueOf = Long.valueOf(adData.getBroadcastIdentifier());
        Preconditions.checkNotNull(valueOf);
        String adPayload = adData.getAdPayload();
        Preconditions.checkNotNull(adPayload);
        if ("mraid".equals(adData.getAdType())) {
            baseWebView = new MraidBridge.MraidWebView(context);
            baseWebView.enableJavascriptCaching();
            moPubWebViewController = new MraidController(context, adData.getDspCreativeId(), PlacementType.INTERSTITIAL, adData.getAllowCustomClose());
            baseWebView.enableJavascriptCaching();
        } else if (AdType.HTML.equals(adData.getAdType())) {
            baseWebView = new HtmlWebView(context);
            moPubWebViewController = HtmlControllerFactory.create(context, adData.getDspCreativeId());
        } else {
            this.mLoadListener.onAdLoadFailed(MoPubErrorCode.FULLSCREEN_LOAD_ERROR);
            return;
        }
        moPubWebViewController.setMoPubWebViewListener(new MoPubFullScreenWebListener(this.mLoadListener));
        moPubWebViewController.fillContent(adPayload, adData.getViewabilityVendors(), (MoPubWebViewController.WebViewCacheListener) null);
        WebViewCacheService.storeWebViewConfig(valueOf, baseWebView, this, moPubWebViewController);
    }

    /* access modifiers changed from: package-private */
    public void preRenderJson(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        try {
            String string = new JSONObject(adData.getAdPayload()).getString("image");
            if (TextUtils.isEmpty(string)) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, "Image url is empty.");
                this.mLoadListener.onAdLoadFailed(MoPubErrorCode.FULLSCREEN_LOAD_ERROR);
                return;
            }
            C2676Networking.getImageLoader(context).get(string, new ImageLoader.ImageListener() {
                public void onResponse(ImageLoader.ImageContainer imageContainer, boolean z) {
                    if (imageContainer.getBitmap() != null) {
                        MoPubFullscreen.this.mLoadListener.onAdLoaded();
                        MoPubFullscreen.this.markReady();
                    }
                }

                public void onErrorResponse(VolleyError volleyError) {
                    MoPubFullscreen.this.mLoadListener.onAdLoadFailed(MoPubErrorCode.FULLSCREEN_LOAD_ERROR);
                }
            });
        } catch (JSONException unused) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, "Unable to get image url.");
            this.mLoadListener.onAdLoadFailed(MoPubErrorCode.FULLSCREEN_LOAD_ERROR);
        }
    }

    /* access modifiers changed from: protected */
    public void show() {
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adapterLogEvent, str);
        if (!this.mReady || this.mContext == null) {
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(moPubErrorCode);
                return;
            }
            return;
        }
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = new EventForwardingBroadcastReceiver(this.mInteractionListener, this.mBroadcastIdentifier);
        this.mBroadcastReceiver = eventForwardingBroadcastReceiver;
        eventForwardingBroadcastReceiver.register(eventForwardingBroadcastReceiver, this.mContext);
        MoPubFullscreenActivity.start(this.mContext, this.mAdData);
    }

    public void onInvalidate() {
        VastManager vastManager = this.mVastManager;
        if (vastManager != null) {
            vastManager.cancel();
        }
        markNotReady();
        this.mAdExpiration = null;
        this.mHandler = null;
        this.mLoadListener = null;
        this.mInteractionListener = null;
        this.mContext = null;
        EventForwardingBroadcastReceiver eventForwardingBroadcastReceiver = this.mBroadcastReceiver;
        if (eventForwardingBroadcastReceiver != null) {
            eventForwardingBroadcastReceiver.unregister(eventForwardingBroadcastReceiver);
            this.mBroadcastReceiver = null;
        }
    }

    public void onVastVideoConfigurationPrepared(VastVideoConfig vastVideoConfig) {
        if (vastVideoConfig == null || this.mAdData == null) {
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(MoPubErrorCode.VIDEO_DOWNLOAD_ERROR);
                return;
            }
            return;
        }
        vastVideoConfig.addVideoTrackers(this.mVideoTrackers);
        vastVideoConfig.addViewabilityVendors(this.mAdData.getViewabilityVendors());
        if (this.mAdData.isRewarded()) {
            vastVideoConfig.setRewarded(true);
        }
        this.mAdData.setVastVideoConfigString(vastVideoConfig.toJsonString());
        AdLifecycleListener.LoadListener loadListener2 = this.mLoadListener;
        if (loadListener2 != null) {
            loadListener2.onAdLoaded();
        }
        markReady();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void markReady() {
        Handler handler;
        Runnable runnable;
        this.mReady = true;
        if (this.mAdData != null && (handler = this.mHandler) != null && (runnable = this.mAdExpiration) != null) {
            handler.postDelayed(runnable, 14400000);
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void markNotReady() {
        Handler handler;
        Runnable runnable;
        this.mReady = false;
        if (this.mAdData != null && (handler = this.mHandler) != null && (runnable = this.mAdExpiration) != null) {
            handler.removeCallbacks(runnable);
        }
    }

    private class MoPubFullScreenWebListener implements BaseHtmlWebView.BaseWebViewListener {
        final AdLifecycleListener.LoadListener loadListener;

        public void onClicked() {
        }

        public void onClose() {
        }

        public void onExpand() {
        }

        public void onFailed() {
        }

        public void onRenderProcessGone(MoPubErrorCode moPubErrorCode) {
        }

        public void onResize(boolean z) {
        }

        MoPubFullScreenWebListener(AdLifecycleListener.LoadListener loadListener2) {
            this.loadListener = loadListener2;
        }

        public void onLoaded(View view) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_SUCCESS, MoPubFullscreen.ADAPTER_NAME);
            MoPubFullscreen.this.markReady();
            this.loadListener.onAdLoaded();
        }

        public void onFailedToLoad(MoPubErrorCode moPubErrorCode) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_FAILED, MoPubFullscreen.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            MoPubFullscreen.this.markNotReady();
            this.loadListener.onAdLoadFailed(moPubErrorCode);
        }
    }
}
