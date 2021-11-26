package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowInsets;
import com.applovin.sdk.AppLovinEventParameters;
import com.mopub.common.AdUrlGenerator;
import com.mopub.common.ClientMetadata;
import com.mopub.common.Constants;
import com.mopub.common.DataKeys;
import com.mopub.common.MediationSettings;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Json;
import com.mopub.common.util.MoPubCollections;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.AdData;
import com.mopub.mobileads.AdLifecycleListener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;
import com.unity3d.ads.metadata.MediationMetaData;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MoPubRewardedAdManager {
    public static final int API_VERSION = 1;
    private static SharedPreferences sBaseAdSharedPrefs;
    /* access modifiers changed from: private */
    public static MoPubRewardedAdManager sInstance;
    private final Handler mBaseAdTimeoutHandler;
    private final Handler mCallbackHandler = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Set<MediationSettings> mGlobalMediationSettings;
    private final Map<String, Set<MediationSettings>> mInstanceMediationSettings;
    private WeakReference<Activity> mMainActivity;
    /* access modifiers changed from: private */
    public final RewardedAdData mRewardedAdData = new RewardedAdData();
    /* access modifiers changed from: private */
    public MoPubRewardedAdListener mRewardedAdListener;
    private final Map<String, Runnable> mTimeoutMap;
    /* access modifiers changed from: private */
    public final RewardedAdsLoaders rewardedAdsLoaders;

    public static final class RequestParameters {
        public final String mCustomerId;
        public final String mKeywords;
        public final Location mLocation;
        public final String mUserDataKeywords;

        public RequestParameters(String str) {
            this(str, (String) null);
        }

        public RequestParameters(String str, String str2) {
            this(str, str2, (Location) null);
        }

        public RequestParameters(String str, String str2, Location location) {
            this(str, str2, location, (String) null);
        }

        public RequestParameters(String str, String str2, Location location, String str3) {
            this.mKeywords = str;
            this.mCustomerId = str3;
            boolean canCollectPersonalInformation = MoPub.canCollectPersonalInformation();
            this.mUserDataKeywords = !canCollectPersonalInformation ? null : str2;
            this.mLocation = !canCollectPersonalInformation ? null : location;
        }
    }

    private MoPubRewardedAdManager(Activity activity, MediationSettings... mediationSettingsArr) {
        this.mMainActivity = new WeakReference<>(activity);
        Context applicationContext = activity.getApplicationContext();
        this.mContext = applicationContext;
        HashSet hashSet = new HashSet();
        this.mGlobalMediationSettings = hashSet;
        MoPubCollections.addAllNonNull(hashSet, (T[]) mediationSettingsArr);
        this.mInstanceMediationSettings = new HashMap();
        this.mBaseAdTimeoutHandler = new Handler();
        this.mTimeoutMap = new HashMap();
        this.rewardedAdsLoaders = new RewardedAdsLoaders(this);
        sBaseAdSharedPrefs = SharedPreferencesHelper.getSharedPreferences(applicationContext, "mopubBaseAdSettings");
    }

    public static synchronized void init(Activity activity, MediationSettings... mediationSettingsArr) {
        synchronized (MoPubRewardedAdManager.class) {
            if (sInstance == null) {
                sInstance = new MoPubRewardedAdManager(activity, mediationSettingsArr);
            } else {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Tried to call init more than once. Only the first initialization call has any effect.");
            }
        }
    }

    @ReflectionTarget
    public static void updateActivity(Activity activity) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager != null) {
            moPubRewardedAdManager.mMainActivity = new WeakReference<>(activity);
        } else {
            logErrorNotInitialized();
        }
    }

    public static <T extends MediationSettings> T getGlobalMediationSettings(Class<T> cls) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager == null) {
            logErrorNotInitialized();
            return null;
        }
        for (MediationSettings next : moPubRewardedAdManager.mGlobalMediationSettings) {
            if (cls.equals(next.getClass())) {
                return (MediationSettings) cls.cast(next);
            }
        }
        return null;
    }

    public static <T extends MediationSettings> T getInstanceMediationSettings(Class<T> cls, String str) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager == null) {
            logErrorNotInitialized();
            return null;
        }
        Set<MediationSettings> set = moPubRewardedAdManager.mInstanceMediationSettings.get(str);
        if (set == null) {
            return null;
        }
        for (MediationSettings mediationSettings : set) {
            if (cls.equals(mediationSettings.getClass())) {
                return (MediationSettings) cls.cast(mediationSettings);
            }
        }
        return null;
    }

    public static void setRewardedAdListener(MoPubRewardedAdListener moPubRewardedAdListener) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager != null) {
            moPubRewardedAdManager.mRewardedAdListener = moPubRewardedAdListener;
        } else {
            logErrorNotInitialized();
        }
    }

    public static void loadAd(final String str, RequestParameters requestParameters, MediationSettings... mediationSettingsArr) {
        String str2;
        Preconditions.checkNotNull(str);
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager == null) {
            logErrorNotInitialized();
        } else if (str.equals(moPubRewardedAdManager.mRewardedAdData.getCurrentlyShowingAdUnitId())) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. The ad is already showing.", new Object[]{str}));
        } else if (hasAd(str)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. This ad unit already finished loading and is ready to show.", new Object[]{str}));
            postToInstance(new Runnable() {
                public void run() {
                    if (MoPubRewardedAdManager.sInstance.mRewardedAdListener != null) {
                        MoPubRewardedAdManager.sInstance.mRewardedAdListener.onRewardedAdLoadSuccess(str);
                    }
                }
            });
        } else {
            HashSet hashSet = new HashSet();
            MoPubCollections.addAllNonNull(hashSet, (T[]) mediationSettingsArr);
            sInstance.mInstanceMediationSettings.put(str, hashSet);
            if (requestParameters == null) {
                str2 = null;
            } else {
                str2 = requestParameters.mCustomerId;
            }
            if (!TextUtils.isEmpty(str2)) {
                sInstance.mRewardedAdData.setCustomerId(str2);
            }
            WebViewAdUrlGenerator webViewAdUrlGenerator = new WebViewAdUrlGenerator(sInstance.mContext);
            webViewAdUrlGenerator.withAdUnitId(str).withKeywords(requestParameters == null ? null : requestParameters.mKeywords).withUserDataKeywords((requestParameters == null || !MoPub.canCollectPersonalInformation()) ? null : requestParameters.mUserDataKeywords);
            setSafeAreaValues(webViewAdUrlGenerator);
            loadAd(str, webViewAdUrlGenerator.generateUrlString(Constants.HOST), (MoPubErrorCode) null);
        }
    }

    private static void loadAd(String str, String str2, MoPubErrorCode moPubErrorCode) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager == null) {
            logErrorNotInitialized();
        } else {
            moPubRewardedAdManager.fetchAd(str, str2, moPubErrorCode);
        }
    }

    private void fetchAd(String str, String str2, MoPubErrorCode moPubErrorCode) {
        if (this.rewardedAdsLoaders.isLoading(str)) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Did not queue rewarded ad request for ad unit %s. A request is already pending.", new Object[]{str}));
            return;
        }
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Loading rewarded ad request for ad unit %s with URL %s", new Object[]{str, str2}));
        this.rewardedAdsLoaders.loadNextAd(this.mContext, str, str2, moPubErrorCode);
    }

    public static boolean hasAd(String str) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager != null) {
            return isPlayable(str, moPubRewardedAdManager.mRewardedAdData.getAdAdapter(str));
        }
        logErrorNotInitialized();
        return false;
    }

    public static void showAd(String str) {
        showAd(str, (String) null);
    }

    public static void showAd(String str, String str2) {
        if (sInstance == null) {
            logErrorNotInitialized();
            return;
        }
        if (str2 != null && str2.length() > 8192) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Provided rewarded ad custom data parameter longer than supported(%d bytes, %d maximum)", new Object[]{Integer.valueOf(str2.length()), 8192}));
        }
        AdAdapter adAdapter = sInstance.mRewardedAdData.getAdAdapter(str);
        if (!isPlayable(str, adAdapter)) {
            if (sInstance.rewardedAdsLoaders.isLoading(str)) {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Rewarded ad is not ready to be shown yet.");
            } else {
                MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "No rewarded ad loading or loaded.");
            }
            sInstance.failover(str, MoPubErrorCode.AD_NOT_AVAILABLE);
        } else if (sInstance.mRewardedAdData.getAvailableRewards(str).isEmpty() || sInstance.mRewardedAdData.getMoPubReward(str) != null) {
            RewardedAdData rewardedAdData = sInstance.mRewardedAdData;
            rewardedAdData.updateLastShownRewardMapping(adAdapter, rewardedAdData.getMoPubReward(str));
            sInstance.mRewardedAdData.updateAdUnitToCustomDataMapping(str, str2);
            sInstance.mRewardedAdData.setCurrentlyShowingAdUnitId(str);
            adAdapter.show((MoPubAd) null);
        } else {
            sInstance.failover(str, MoPubErrorCode.REWARD_NOT_SELECTED);
        }
    }

    private static boolean isPlayable(String str, AdAdapter adAdapter) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        return moPubRewardedAdManager != null && moPubRewardedAdManager.rewardedAdsLoaders.canPlay(str) && adAdapter != null && adAdapter.isReady();
    }

    public static Set<MoPubReward> getAvailableRewards(String str) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager != null) {
            return moPubRewardedAdManager.mRewardedAdData.getAvailableRewards(str);
        }
        logErrorNotInitialized();
        return Collections.emptySet();
    }

    public static void selectReward(String str, MoPubReward moPubReward) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager != null) {
            moPubRewardedAdManager.mRewardedAdData.selectReward(str, moPubReward);
        } else {
            logErrorNotInitialized();
        }
    }

    private static void setSafeAreaValues(AdUrlGenerator adUrlGenerator) {
        Window window;
        WindowInsets rootWindowInsets;
        Preconditions.checkNotNull(adUrlGenerator);
        adUrlGenerator.withRequestedAdSize(ClientMetadata.getInstance(sInstance.mContext).getDeviceDimensions());
        if (Build.VERSION.SDK_INT >= 28 && ((Activity) sInstance.mMainActivity.get()) != null && (window = ((Activity) sInstance.mMainActivity.get()).getWindow()) != null && (rootWindowInsets = window.getDecorView().getRootWindowInsets()) != null) {
            adUrlGenerator.withWindowInsets(rootWindowInsets);
        }
    }

    /* access modifiers changed from: package-private */
    public void onAdSuccess(AdResponse adResponse) {
        int i;
        AdResponse adResponse2 = adResponse;
        String adUnitId = adResponse.getAdUnitId();
        Integer adTimeoutMillis = adResponse2.getAdTimeoutMillis(30000);
        String baseAdClassName = adResponse.getBaseAdClassName();
        if (baseAdClassName == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Couldn't create base ad, class name was null.");
            failover(adUnitId, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        AdAdapter adAdapter = this.mRewardedAdData.getAdAdapter(adUnitId);
        if (adAdapter != null) {
            adAdapter.invalidate();
        }
        String rewardedCurrencies = adResponse.getRewardedCurrencies();
        this.mRewardedAdData.resetAvailableRewards(adUnitId);
        this.mRewardedAdData.resetSelectedReward(adUnitId);
        if (TextUtils.isEmpty(rewardedCurrencies)) {
            this.mRewardedAdData.updateAdUnitRewardMapping(adUnitId, adResponse.getRewardedAdCurrencyName(), adResponse.getRewardedAdCurrencyAmount());
        } else {
            try {
                parseMultiCurrencyJson(adUnitId, rewardedCurrencies);
            } catch (Exception unused) {
                MoPubLog.SdkLogEvent sdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent, "Error parsing rewarded currencies JSON header: " + rewardedCurrencies);
                failover(adUnitId, MoPubErrorCode.REWARDED_CURRENCIES_PARSING_ERROR);
                return;
            }
        }
        this.mRewardedAdData.updateAdUnitToServerCompletionUrlMapping(adUnitId, adResponse.getRewardedAdCompletionUrl());
        if (((Activity) this.mMainActivity.get()) == null) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Could not load base ad because Activity reference was null. Call MoPub#updateActivity before requesting more rewarded ads.");
            this.rewardedAdsLoaders.markFail(adUnitId);
            return;
        }
        Map<String, String> serverExtras = adResponse.getServerExtras();
        String jSONObject = new JSONObject(serverExtras).toString();
        String impressionMinVisibleDips = adResponse.getImpressionMinVisibleDips();
        String impressionMinVisibleMs = adResponse.getImpressionMinVisibleMs();
        int intValue = adResponse2.getAdTimeoutMillis(30000).intValue();
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Updating init settings for base ad %s with params %s", new Object[]{baseAdClassName, jSONObject}));
        sBaseAdSharedPrefs.edit().putString(baseAdClassName, jSONObject).apply();
        String remove = serverExtras.remove(DataKeys.HTML_RESPONSE_BODY_KEY);
        AdData.Builder adType = new AdData.Builder().adUnit(adUnitId).isRewarded(true).adType(adResponse.getFullAdType());
        if (remove == null) {
            remove = "";
        }
        AdData.Builder extras = adType.adPayload(remove).currencyName(adResponse.getRewardedAdCurrencyName()).impressionMinVisibleDips(impressionMinVisibleDips).impressionMinVisibleMs(impressionMinVisibleMs).dspCreativeId(adResponse.getDspCreativeId()).broadcastIdentifier(Utils.generateUniqueId()).timeoutDelayMillis(intValue).customerId(this.mRewardedAdData.getCustomerId()).allowCustomClose(false).viewabilityVendors(adResponse.getViewabilityVendors()).fullAdType(adResponse.getFullAdType()).extras(serverExtras);
        Integer rewardedDuration = adResponse.getRewardedDuration();
        if (rewardedDuration != null) {
            extras.rewardedDurationSeconds(rewardedDuration.intValue());
        }
        String rewardedAdCurrencyAmount = adResponse.getRewardedAdCurrencyAmount();
        if (!TextUtils.isEmpty(rewardedAdCurrencyAmount)) {
            try {
                i = Integer.parseInt(rewardedAdCurrencyAmount);
            } catch (NumberFormatException unused2) {
                MoPubLog.SdkLogEvent sdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
                MoPubLog.log(sdkLogEvent2, "Unable to convert currency amount: " + rewardedAdCurrencyAmount + ". Using the default reward amount: " + 0);
            }
            extras.currencyAmount(i);
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Loading base ad with class name %s", new Object[]{baseAdClassName}));
            Constructor<? extends U> declaredConstructor = Class.forName("com.mopub.mobileads.FullscreenAdAdapter").asSubclass(AdAdapter.class).getDeclaredConstructor(new Class[]{Context.class, String.class, AdData.class});
            declaredConstructor.setAccessible(true);
            AdAdapter adAdapter2 = (AdAdapter) declaredConstructor.newInstance(new Object[]{sInstance.mMainActivity.get(), baseAdClassName, extras.build()});
            InternalRewardedAdListener internalRewardedAdListener = new InternalRewardedAdListener(adAdapter2);
            $$Lambda$MoPubRewardedAdManager$NnMR62KVeD0RLOmiKT400xGyVk r8 = new Runnable() {
                public final void run() {
                    MoPubRewardedAdManager.lambda$onAdSuccess$0(AdAdapter.this);
                }
            };
            this.mBaseAdTimeoutHandler.postDelayed(r8, (long) adTimeoutMillis.intValue());
            this.mTimeoutMap.put(adUnitId, r8);
            adAdapter2.load(internalRewardedAdListener);
            adAdapter2.setInteractionListener(internalRewardedAdListener);
            adAdapter2.getAdNetworkId();
            this.mRewardedAdData.updateAdUnitAdAdapterMapping(adUnitId, adAdapter2);
        }
        i = 0;
        extras.currencyAmount(i);
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Loading base ad with class name %s", new Object[]{baseAdClassName}));
        try {
            Constructor<? extends U> declaredConstructor2 = Class.forName("com.mopub.mobileads.FullscreenAdAdapter").asSubclass(AdAdapter.class).getDeclaredConstructor(new Class[]{Context.class, String.class, AdData.class});
            declaredConstructor2.setAccessible(true);
            AdAdapter adAdapter22 = (AdAdapter) declaredConstructor2.newInstance(new Object[]{sInstance.mMainActivity.get(), baseAdClassName, extras.build()});
            InternalRewardedAdListener internalRewardedAdListener2 = new InternalRewardedAdListener(adAdapter22);
            $$Lambda$MoPubRewardedAdManager$NnMR62KVeD0RLOmiKT400xGyVk r82 = new Runnable() {
                public final void run() {
                    MoPubRewardedAdManager.lambda$onAdSuccess$0(AdAdapter.this);
                }
            };
            this.mBaseAdTimeoutHandler.postDelayed(r82, (long) adTimeoutMillis.intValue());
            this.mTimeoutMap.put(adUnitId, r82);
            adAdapter22.load(internalRewardedAdListener2);
            adAdapter22.setInteractionListener(internalRewardedAdListener2);
            adAdapter22.getAdNetworkId();
            this.mRewardedAdData.updateAdUnitAdAdapterMapping(adUnitId, adAdapter22);
        } catch (Exception unused3) {
            MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, String.format(Locale.US, "Couldn't create base ad with class name %s", new Object[]{baseAdClassName}));
            failover(adUnitId, MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
        }
    }

    static /* synthetic */ void lambda$onAdSuccess$0(AdAdapter adAdapter) {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "Base Ad failed to load rewarded ad in a timely fashion.");
        adAdapter.onAdLoadFailed(MoPubErrorCode.NETWORK_TIMEOUT);
        adAdapter.getClass();
        postToInstance(new Runnable() {
            public final void run() {
                AdAdapter.this.invalidate();
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void onAdError(VolleyError volleyError, String str) {
        MoPubErrorCode moPubErrorCode = MoPubErrorCode.INTERNAL_ERROR;
        if (volleyError instanceof MoPubNetworkError) {
            int i = C256213.$SwitchMap$com$mopub$network$MoPubNetworkError$Reason[((MoPubNetworkError) volleyError).getReason().ordinal()];
            if (i == 1 || i == 2) {
                moPubErrorCode = MoPubErrorCode.NO_FILL;
            } else if (i == 3) {
                moPubErrorCode = MoPubErrorCode.TOO_MANY_REQUESTS;
            }
        }
        if (volleyError instanceof NoConnectionError) {
            moPubErrorCode = MoPubErrorCode.NO_CONNECTION;
        }
        failover(str, moPubErrorCode);
    }

    private void parseMultiCurrencyJson(String str, String str2) throws JSONException {
        String[] jsonArrayToStringArray = Json.jsonArrayToStringArray(Json.jsonStringToMap(str2).get("rewards"));
        if (jsonArrayToStringArray.length == 1) {
            Map<String, String> jsonStringToMap = Json.jsonStringToMap(jsonArrayToStringArray[0]);
            this.mRewardedAdData.updateAdUnitRewardMapping(str, jsonStringToMap.get(MediationMetaData.KEY_NAME), jsonStringToMap.get(AppLovinEventParameters.REVENUE_AMOUNT));
        }
        for (String jsonStringToMap2 : jsonArrayToStringArray) {
            Map<String, String> jsonStringToMap3 = Json.jsonStringToMap(jsonStringToMap2);
            this.mRewardedAdData.addAvailableReward(str, jsonStringToMap3.get(MediationMetaData.KEY_NAME), jsonStringToMap3.get(AppLovinEventParameters.REVENUE_AMOUNT));
        }
    }

    /* access modifiers changed from: private */
    public void failover(String str, MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(moPubErrorCode);
        if (!this.rewardedAdsLoaders.hasMoreAds(str) || moPubErrorCode.equals(MoPubErrorCode.EXPIRED)) {
            MoPubRewardedAdListener moPubRewardedAdListener = sInstance.mRewardedAdListener;
            if (moPubRewardedAdListener != null) {
                moPubRewardedAdListener.onRewardedAdLoadFailure(str, moPubErrorCode);
                this.rewardedAdsLoaders.markFail(str);
                return;
            }
            return;
        }
        loadAd(str, "", moPubErrorCode);
    }

    /* access modifiers changed from: private */
    public void cancelTimeouts(String str) {
        Runnable remove = this.mTimeoutMap.remove(str);
        if (remove != null) {
            this.mBaseAdTimeoutHandler.removeCallbacks(remove);
        }
    }

    public static void onRewardedAdLoadSuccess(AdAdapter adAdapter, String str) {
        postToInstance(new ForEachAdUnitIdRunnable(adAdapter) {
            /* access modifiers changed from: protected */
            public void forEach(String str) {
                MoPubRewardedAdManager.sInstance.cancelTimeouts(str);
                MoPubRewardedAdManager.sInstance.rewardedAdsLoaders.creativeDownloadSuccess(str);
                if (MoPubRewardedAdManager.sInstance.mRewardedAdListener != null) {
                    MoPubRewardedAdManager.sInstance.mRewardedAdListener.onRewardedAdLoadSuccess(str);
                }
            }
        });
    }

    public static void onRewardedAdLoadFailure(AdAdapter adAdapter, String str, final MoPubErrorCode moPubErrorCode) {
        postToInstance(new ForEachAdUnitIdRunnable(adAdapter) {
            /* access modifiers changed from: protected */
            public void forEach(String str) {
                MoPubRewardedAdManager.sInstance.cancelTimeouts(str);
                MoPubRewardedAdManager.sInstance.failover(str, moPubErrorCode);
                if (str.equals(MoPubRewardedAdManager.sInstance.mRewardedAdData.getCurrentlyShowingAdUnitId())) {
                    MoPubRewardedAdManager.sInstance.mRewardedAdData.setCurrentlyShowingAdUnitId((String) null);
                }
            }
        });
    }

    public static void onRewardedAdStarted(AdAdapter adAdapter, String str) {
        final String currentlyShowingAdUnitId = sInstance.mRewardedAdData.getCurrentlyShowingAdUnitId();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            postToInstance(new ForEachAdUnitIdRunnable(adAdapter) {
                /* access modifiers changed from: protected */
                public void forEach(String str) {
                    MoPubRewardedAdManager.onRewardedAdStartedAction(str);
                }
            });
        } else {
            postToInstance(new Runnable() {
                public void run() {
                    MoPubRewardedAdManager.onRewardedAdStartedAction(currentlyShowingAdUnitId);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void onRewardedAdStartedAction(String str) {
        Preconditions.checkNotNull(str);
        MoPubRewardedAdListener moPubRewardedAdListener = sInstance.mRewardedAdListener;
        if (moPubRewardedAdListener != null) {
            moPubRewardedAdListener.onRewardedAdStarted(str);
        }
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        moPubRewardedAdManager.rewardedAdsLoaders.onRewardedAdStarted(str, moPubRewardedAdManager.mContext);
    }

    public static void onRewardedAdShowError(AdAdapter adAdapter, String str, final MoPubErrorCode moPubErrorCode) {
        final String currentlyShowingAdUnitId = sInstance.mRewardedAdData.getCurrentlyShowingAdUnitId();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            postToInstance(new ForEachAdUnitIdRunnable(adAdapter) {
                /* access modifiers changed from: protected */
                public void forEach(String str) {
                    MoPubRewardedAdManager.onRewardedAdShowErrorAction(str, moPubErrorCode);
                }
            });
        } else {
            postToInstance(new Runnable() {
                public void run() {
                    MoPubRewardedAdManager.onRewardedAdShowErrorAction(currentlyShowingAdUnitId, moPubErrorCode);
                }
            });
        }
        sInstance.mRewardedAdData.setCurrentlyShowingAdUnitId((String) null);
    }

    /* access modifiers changed from: private */
    public static void onRewardedAdShowErrorAction(String str, MoPubErrorCode moPubErrorCode) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(moPubErrorCode);
        sInstance.rewardedAdsLoaders.markFail(str);
        MoPubRewardedAdListener moPubRewardedAdListener = sInstance.mRewardedAdListener;
        if (moPubRewardedAdListener != null) {
            moPubRewardedAdListener.onRewardedAdShowError(str, moPubErrorCode);
            sInstance.mRewardedAdListener.onRewardedAdLoadFailure(str, MoPubErrorCode.EXPIRED);
        }
    }

    public static void onRewardedAdClicked(AdAdapter adAdapter, String str) {
        final String currentlyShowingAdUnitId = sInstance.mRewardedAdData.getCurrentlyShowingAdUnitId();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            postToInstance(new ForEachAdUnitIdRunnable(adAdapter) {
                /* access modifiers changed from: protected */
                public void forEach(String str) {
                    MoPubRewardedAdManager.onRewardedAdClickedAction(str);
                }
            });
        } else {
            postToInstance(new Runnable() {
                public void run() {
                    MoPubRewardedAdManager.onRewardedAdClickedAction(currentlyShowingAdUnitId);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static void onRewardedAdClickedAction(String str) {
        Preconditions.checkNotNull(str);
        MoPubRewardedAdListener moPubRewardedAdListener = sInstance.mRewardedAdListener;
        if (moPubRewardedAdListener != null) {
            moPubRewardedAdListener.onRewardedAdClicked(str);
        }
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        moPubRewardedAdManager.rewardedAdsLoaders.onRewardedAdClicked(str, moPubRewardedAdManager.mContext);
    }

    public static void onRewardedAdClosed(AdAdapter adAdapter, String str) {
        final String currentlyShowingAdUnitId = sInstance.mRewardedAdData.getCurrentlyShowingAdUnitId();
        if (TextUtils.isEmpty(currentlyShowingAdUnitId)) {
            postToInstance(new ForEachAdUnitIdRunnable(adAdapter) {
                /* access modifiers changed from: protected */
                public void forEach(String str) {
                    MoPubRewardedAdManager.onRewardedAdClosedAction(str);
                }
            });
        } else {
            postToInstance(new Runnable() {
                public void run() {
                    MoPubRewardedAdManager.onRewardedAdClosedAction(currentlyShowingAdUnitId);
                }
            });
        }
        sInstance.mRewardedAdData.setCurrentlyShowingAdUnitId((String) null);
    }

    /* access modifiers changed from: private */
    public static void onRewardedAdClosedAction(String str) {
        Preconditions.checkNotNull(str);
        sInstance.rewardedAdsLoaders.markPlayed(str);
        MoPubRewardedAdListener moPubRewardedAdListener = sInstance.mRewardedAdListener;
        if (moPubRewardedAdListener != null) {
            moPubRewardedAdListener.onRewardedAdClosed(str);
        }
    }

    public static void onRewardedAdCompleted(AdAdapter adAdapter, String str, MoPubReward moPubReward) {
        String currentlyShowingAdUnitId = sInstance.mRewardedAdData.getCurrentlyShowingAdUnitId();
        rewardOnClient(adAdapter, moPubReward, currentlyShowingAdUnitId);
        rewardOnServer(currentlyShowingAdUnitId);
    }

    private static void rewardOnServer(final String str) {
        final String serverCompletionUrl = sInstance.mRewardedAdData.getServerCompletionUrl(str);
        if (!TextUtils.isEmpty(serverCompletionUrl)) {
            postToInstance(new Runnable() {
                public void run() {
                    String str;
                    String str2;
                    String str3;
                    MoPubReward moPubReward = MoPubRewardedAdManager.sInstance.mRewardedAdData.getMoPubReward(str);
                    if (moPubReward == null) {
                        str = "";
                    } else {
                        str = moPubReward.getLabel();
                    }
                    String str4 = str;
                    if (moPubReward == null) {
                        str2 = Integer.toString(0);
                    } else {
                        str2 = Integer.toString(moPubReward.getAmount());
                    }
                    String str5 = str2;
                    AdAdapter adAdapter = MoPubRewardedAdManager.sInstance.mRewardedAdData.getAdAdapter(str);
                    if (adAdapter == null) {
                        str3 = null;
                    } else {
                        str3 = adAdapter.getBaseAdClassName();
                    }
                    RewardedAdCompletionRequestHandler.makeRewardedAdCompletionRequest(MoPubRewardedAdManager.sInstance.mContext, serverCompletionUrl, MoPubRewardedAdManager.sInstance.mRewardedAdData.getCustomerId(), str4, str5, str3, MoPubRewardedAdManager.sInstance.mRewardedAdData.getCustomData(str));
                }
            });
        }
    }

    private static void rewardOnClient(AdAdapter adAdapter, MoPubReward moPubReward, String str) {
        postToInstance(new Runnable(moPubReward, str) {
            public final /* synthetic */ MoPubReward f$1;
            public final /* synthetic */ String f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                MoPubRewardedAdManager.lambda$rewardOnClient$1(AdAdapter.this, this.f$1, this.f$2);
            }
        });
    }

    static /* synthetic */ void lambda$rewardOnClient$1(AdAdapter adAdapter, MoPubReward moPubReward, String str) {
        MoPubReward chooseReward = chooseReward(sInstance.mRewardedAdData.getLastShownMoPubReward(adAdapter), moPubReward);
        HashSet hashSet = new HashSet();
        if (TextUtils.isEmpty(str)) {
            hashSet.addAll(sInstance.mRewardedAdData.getAdUnitIdsForAdAdapter(adAdapter));
        } else {
            hashSet.add(str);
        }
        MoPubLog.log(MoPubLog.AdLogEvent.SHOULD_REWARD, Integer.valueOf(chooseReward.getAmount()), chooseReward.getLabel());
        MoPubRewardedAdListener moPubRewardedAdListener = sInstance.mRewardedAdListener;
        if (moPubRewardedAdListener != null) {
            moPubRewardedAdListener.onRewardedAdCompleted(hashSet, chooseReward);
        }
    }

    @VisibleForTesting
    static MoPubReward chooseReward(MoPubReward moPubReward, MoPubReward moPubReward2) {
        if (!moPubReward2.isSuccessful()) {
            return moPubReward2;
        }
        return moPubReward != null ? moPubReward : moPubReward2;
    }

    private static void postToInstance(Runnable runnable) {
        MoPubRewardedAdManager moPubRewardedAdManager = sInstance;
        if (moPubRewardedAdManager != null) {
            moPubRewardedAdManager.mCallbackHandler.post(runnable);
        }
    }

    private static void logErrorNotInitialized() {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, "MoPub rewarded ad was not initialized. You must call MoPub.initializeSdk() with an Activity Context before loading or attempting to show rewarded ads.");
    }

    private static abstract class ForEachAdUnitIdRunnable implements Runnable {
        private final AdAdapter mAdAdapter;

        /* access modifiers changed from: protected */
        public abstract void forEach(String str);

        ForEachAdUnitIdRunnable(AdAdapter adAdapter) {
            Preconditions.checkNotNull(adAdapter);
            this.mAdAdapter = adAdapter;
        }

        public void run() {
            for (String forEach : MoPubRewardedAdManager.sInstance.mRewardedAdData.getAdUnitIdsForAdAdapter(this.mAdAdapter)) {
                forEach(forEach);
            }
        }
    }

    private static class InternalRewardedAdListener implements AdLifecycleListener.LoadListener, AdLifecycleListener.InteractionListener {
        final AdAdapter adAdapter;

        public void onAdCollapsed() {
        }

        public void onAdExpanded() {
        }

        public void onAdImpression() {
        }

        public void onAdPauseAutoRefresh() {
        }

        public void onAdResumeAutoRefresh() {
        }

        InternalRewardedAdListener(AdAdapter adAdapter2) {
            this.adAdapter = adAdapter2;
        }

        public void onAdLoaded() {
            MoPubLog.log(MoPubLog.AdLogEvent.LOAD_SUCCESS, new Object[0]);
            AdAdapter adAdapter2 = this.adAdapter;
            MoPubRewardedAdManager.onRewardedAdLoadSuccess(adAdapter2, adAdapter2.getAdNetworkId());
        }

        public void onAdLoadFailed(MoPubErrorCode moPubErrorCode) {
            MoPubLog.log(MoPubLog.AdLogEvent.LOAD_FAILED, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            onAdFailed(moPubErrorCode);
        }

        public void onAdFailed(MoPubErrorCode moPubErrorCode) {
            int i = C256213.$SwitchMap$com$mopub$mobileads$MoPubErrorCode[moPubErrorCode.ordinal()];
            if (i == 1 || i == 2 || i == 3) {
                MoPubLog.log(MoPubLog.AdLogEvent.SHOW_FAILED, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
                AdAdapter adAdapter2 = this.adAdapter;
                MoPubRewardedAdManager.onRewardedAdShowError(adAdapter2, adAdapter2.getAdNetworkId(), moPubErrorCode);
                return;
            }
            AdAdapter adAdapter3 = this.adAdapter;
            MoPubRewardedAdManager.onRewardedAdLoadFailure(adAdapter3, adAdapter3.getAdNetworkId(), moPubErrorCode);
        }

        public void onAdShown() {
            MoPubLog.log(MoPubLog.AdLogEvent.SHOW_SUCCESS, new Object[0]);
            AdAdapter adAdapter2 = this.adAdapter;
            MoPubRewardedAdManager.onRewardedAdStarted(adAdapter2, adAdapter2.getAdNetworkId());
        }

        public void onAdClicked() {
            MoPubLog.log(MoPubLog.AdLogEvent.CLICKED, new Object[0]);
            AdAdapter adAdapter2 = this.adAdapter;
            MoPubRewardedAdManager.onRewardedAdClicked(adAdapter2, adAdapter2.getAdNetworkId());
        }

        public void onAdDismissed() {
            MoPubLog.log(MoPubLog.AdLogEvent.DID_DISAPPEAR, new Object[0]);
            AdAdapter adAdapter2 = this.adAdapter;
            MoPubRewardedAdManager.onRewardedAdClosed(adAdapter2, adAdapter2.getAdNetworkId());
        }

        public void onAdComplete(MoPubReward moPubReward) {
            if (moPubReward == null) {
                moPubReward = MoPubReward.success("", 0);
            }
            AdAdapter adAdapter2 = this.adAdapter;
            MoPubRewardedAdManager.onRewardedAdCompleted(adAdapter2, adAdapter2.getAdNetworkId(), moPubReward);
        }
    }

    /* renamed from: com.mopub.mobileads.MoPubRewardedAdManager$13 */
    static /* synthetic */ class C256213 {
        static final /* synthetic */ int[] $SwitchMap$com$mopub$mobileads$MoPubErrorCode;
        static final /* synthetic */ int[] $SwitchMap$com$mopub$network$MoPubNetworkError$Reason;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|(3:21|22|24)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|24) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0039 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0058 */
        static {
            /*
                com.mopub.mobileads.MoPubErrorCode[] r0 = com.mopub.mobileads.MoPubErrorCode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$mopub$mobileads$MoPubErrorCode = r0
                r1 = 1
                com.mopub.mobileads.MoPubErrorCode r2 = com.mopub.mobileads.MoPubErrorCode.AD_SHOW_ERROR     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = $SwitchMap$com$mopub$mobileads$MoPubErrorCode     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mopub.mobileads.MoPubErrorCode r3 = com.mopub.mobileads.MoPubErrorCode.VIDEO_PLAYBACK_ERROR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = $SwitchMap$com$mopub$mobileads$MoPubErrorCode     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mopub.mobileads.MoPubErrorCode r4 = com.mopub.mobileads.MoPubErrorCode.EXPIRED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                com.mopub.network.MoPubNetworkError$Reason[] r3 = com.mopub.network.MoPubNetworkError.Reason.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                $SwitchMap$com$mopub$network$MoPubNetworkError$Reason = r3
                com.mopub.network.MoPubNetworkError$Reason r4 = com.mopub.network.MoPubNetworkError.Reason.NO_FILL     // Catch:{ NoSuchFieldError -> 0x0039 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0039 }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                int[] r1 = $SwitchMap$com$mopub$network$MoPubNetworkError$Reason     // Catch:{ NoSuchFieldError -> 0x0043 }
                com.mopub.network.MoPubNetworkError$Reason r3 = com.mopub.network.MoPubNetworkError.Reason.WARMING_UP     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                int[] r0 = $SwitchMap$com$mopub$network$MoPubNetworkError$Reason     // Catch:{ NoSuchFieldError -> 0x004d }
                com.mopub.network.MoPubNetworkError$Reason r1 = com.mopub.network.MoPubNetworkError.Reason.TOO_MANY_REQUESTS     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                int[] r0 = $SwitchMap$com$mopub$network$MoPubNetworkError$Reason     // Catch:{ NoSuchFieldError -> 0x0058 }
                com.mopub.network.MoPubNetworkError$Reason r1 = com.mopub.network.MoPubNetworkError.Reason.BAD_BODY     // Catch:{ NoSuchFieldError -> 0x0058 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0058 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0058 }
            L_0x0058:
                int[] r0 = $SwitchMap$com$mopub$network$MoPubNetworkError$Reason     // Catch:{ NoSuchFieldError -> 0x0063 }
                com.mopub.network.MoPubNetworkError$Reason r1 = com.mopub.network.MoPubNetworkError.Reason.BAD_HEADER_DATA     // Catch:{ NoSuchFieldError -> 0x0063 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0063 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0063 }
            L_0x0063:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mopub.mobileads.MoPubRewardedAdManager.C256213.<clinit>():void");
        }
    }
}
