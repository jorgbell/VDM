package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinEventParameters;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.mopub.common.DataKeys;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPub;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import java.util.HashMap;
import java.util.Map;

public class AppLovinRewardedVideo extends BaseAd implements AppLovinAdLoadListener, AppLovinAdDisplayListener, AppLovinAdClickListener, AppLovinAdVideoPlaybackListener, AppLovinAdRewardListener {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "AppLovinRewardedVideo";
    private static final Map<String, AppLovinIncentivizedInterstitial> GLOBAL_INCENTIVIZED_INTERSTITIAL_ADS = new HashMap();
    private String extrasZoneId = "";
    private boolean fullyWatched;
    private AppLovinIncentivizedInterstitial incentivizedInterstitial;
    private boolean initialized;
    private boolean isTokenEvent;
    private AppLovinAdapterConfiguration mAppLovinAdapterConfiguration = new AppLovinAdapterConfiguration();
    private Activity parentActivity;
    private MoPubReward reward;
    private AppLovinSdk sdk;
    private AppLovinAd tokenAd;

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
    }

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(adData);
        AppLovinPrivacySettings.setHasUserConsent(MoPub.canCollectPersonalInformation(), activity.getApplicationContext());
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str, "Initializing AppLovin rewarded video...");
        AppLovinSdk.getInstance(activity).getSettings().setMuted(MoPub.applicationMuted);
        if (this.initialized) {
            return false;
        }
        AppLovinSdk retrieveSdk = retrieveSdk(activity);
        this.sdk = retrieveSdk;
        if (retrieveSdk == null) {
            MoPubLog.log(getAdNetworkId(), adapterLogEvent, str, "AppLovinSdk instance is null likely because no AppLovin SDK key is available. Failing ad request.");
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener = this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(moPubErrorCode);
            }
            throw new IllegalStateException("Stopping AppLovinRewardedVideo load due to an adapter configuration error.");
        }
        retrieveSdk.setMediationProvider(AppLovinMediationProvider.MOPUB);
        this.sdk.setPluginVersion("MoPub-10.1.2.0");
        this.initialized = true;
        return true;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        String str;
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        this.parentActivity = (Activity) context;
        Map<String, String> extras = adData.getExtras();
        if (extras.isEmpty()) {
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "No extras provided");
            this.mLoadListener.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
            return;
        }
        setAutomaticImpressionAndClickTracking(false);
        String str2 = extras.get(DataKeys.ADM_KEY);
        boolean z = !TextUtils.isEmpty(str2);
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        String str3 = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str3, "Requesting AppLovin rewarded video with extras: " + extras + " and has ad markup: " + z);
        this.mAppLovinAdapterConfiguration.setCachedInitializationParameters(context, extras);
        if (z) {
            str = "token";
        } else {
            String str4 = extras.get("zone_id");
            this.extrasZoneId = str4;
            str = !TextUtils.isEmpty(str4) ? this.extrasZoneId : "";
        }
        AppLovinSdk.getInstance(this.parentActivity).getSettings().setMuted(MoPub.applicationMuted);
        AppLovinIncentivizedInterstitial createIncentivizedInterstitialAd = createIncentivizedInterstitialAd(str, this.sdk);
        this.incentivizedInterstitial = createIncentivizedInterstitialAd;
        if (z) {
            this.isTokenEvent = true;
            this.sdk.getAdService().loadNextAdForAdToken(str2, this);
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str3);
            return;
        }
        createIncentivizedInterstitialAd.preload(this);
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, str3);
    }

    /* access modifiers changed from: protected */
    public void show() {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adNetworkId, adapterLogEvent, str);
        if (hasVideoAvailable()) {
            this.fullyWatched = false;
            this.reward = null;
            AppLovinSdk.getInstance(this.parentActivity).getSettings().setMuted(MoPub.applicationMuted);
            if (this.isTokenEvent) {
                this.incentivizedInterstitial.show(this.tokenAd, (Context) this.parentActivity, (AppLovinAdRewardListener) this, (AppLovinAdVideoPlaybackListener) this, (AppLovinAdDisplayListener) this, (AppLovinAdClickListener) this);
            } else {
                this.incentivizedInterstitial.show((Context) this.parentActivity, (String) null, (AppLovinAdRewardListener) this, (AppLovinAdVideoPlaybackListener) this, (AppLovinAdDisplayListener) this, (AppLovinAdClickListener) this);
            }
        } else {
            String adNetworkId2 = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adNetworkId2, adapterLogEvent2, str, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, str, "Failed to show an AppLovin rewarded video before one was loaded");
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(MoPubErrorCode.VIDEO_PLAYBACK_ERROR);
            }
        }
    }

    private boolean hasVideoAvailable() {
        if (!this.isTokenEvent) {
            AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = this.incentivizedInterstitial;
            if (appLovinIncentivizedInterstitial == null || !appLovinIncentivizedInterstitial.isAdReadyToDisplay()) {
                return false;
            }
            return true;
        } else if (this.tokenAd != null) {
            return true;
        } else {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        return this.extrasZoneId;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "Rewarded video did load ad: " + appLovinAd.getAdIdNumber());
        if (this.isTokenEvent) {
            this.tokenAd = appLovinAd;
        }
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    AdLifecycleListener.LoadListener loadListener = AppLovinRewardedVideo.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoaded();
                    }
                    MoPubLog.log(AppLovinRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_SUCCESS, AppLovinRewardedVideo.ADAPTER_NAME);
                } catch (Throwable th) {
                    MoPubLog.log(AppLovinRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Unable to notify listener of successful ad load.", th);
                }
            }
        });
    }

    public void failedToReceiveAd(final int i) {
        this.parentActivity.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    AdLifecycleListener.LoadListener loadListener = AppLovinRewardedVideo.this.mLoadListener;
                    if (loadListener != null) {
                        loadListener.onAdLoadFailed(AppLovinAdapterConfiguration.getMoPubErrorCode(i));
                    }
                    MoPubLog.log(AppLovinRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_FAILED, AppLovinRewardedVideo.ADAPTER_NAME, Integer.valueOf(AppLovinAdapterConfiguration.getMoPubErrorCode(i).getIntCode()), AppLovinAdapterConfiguration.getMoPubErrorCode(i));
                } catch (Throwable th) {
                    MoPubLog.log(AppLovinRewardedVideo.this.getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM_WITH_THROWABLE, "Unable to notify listener of failure to receive ad.", th);
                }
            }
        });
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdShown();
            this.mInteractionListener.onAdImpression();
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOW_SUCCESS, ADAPTER_NAME);
    }

    public void adHidden(AppLovinAd appLovinAd) {
        if (this.fullyWatched && this.reward != null) {
            String adNetworkId = getAdNetworkId();
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            String str = ADAPTER_NAME;
            MoPubLog.log(adNetworkId, adapterLogEvent, str, "Rewarded: " + this.reward.getAmount() + " " + this.reward.getLabel());
            MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.SHOULD_REWARD, str, Integer.valueOf(this.reward.getAmount()), this.reward.getLabel());
            AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdComplete(this.reward);
            }
        }
        AdLifecycleListener.InteractionListener interactionListener2 = this.mInteractionListener;
        if (interactionListener2 != null) {
            interactionListener2.onAdDismissed();
        }
    }

    public void adClicked(AppLovinAd appLovinAd) {
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdClicked();
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CLICKED, ADAPTER_NAME);
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Rewarded video playback began");
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "Rewarded video playback ended at playback percent: " + d);
        this.fullyWatched = z;
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "Rewarded video validation request for ad did exceed quota with response: " + map);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "Rewarded video validation request for ad failed with error code: " + i);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "Rewarded video validation request was rejected with response: " + map);
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "User declined to view rewarded video");
        AdLifecycleListener.InteractionListener interactionListener = this.mInteractionListener;
        if (interactionListener != null) {
            interactionListener.onAdDismissed();
        }
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        String str = (String) map.get("currency");
        int parseDouble = (int) Double.parseDouble((String) map.get(AppLovinEventParameters.REVENUE_AMOUNT));
        String adNetworkId = getAdNetworkId();
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
        MoPubLog.log(adNetworkId, adapterLogEvent, ADAPTER_NAME, "Verified " + parseDouble + " " + str);
        this.reward = MoPubReward.success(str, parseDouble);
    }

    private static AppLovinSdk retrieveSdk(Context context) {
        if (AppLovinAdapterConfiguration.androidManifestContainsValidSdkKey(context)) {
            return AppLovinSdk.getInstance(context);
        }
        String sdkKey = AppLovinAdapterConfiguration.getSdkKey();
        if (!TextUtils.isEmpty(sdkKey)) {
            return AppLovinSdk.getInstance(sdkKey, new AppLovinSdkSettings(), context);
        }
        return null;
    }

    private static AppLovinIncentivizedInterstitial createIncentivizedInterstitialAd(String str, AppLovinSdk appLovinSdk) {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial;
        Map<String, AppLovinIncentivizedInterstitial> map = GLOBAL_INCENTIVIZED_INTERSTITIAL_ADS;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        if ("".equals(str) || "token".equals(str)) {
            appLovinIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(appLovinSdk);
        } else {
            appLovinIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(str, appLovinSdk);
        }
        map.put(str, appLovinIncentivizedInterstitial);
        return appLovinIncentivizedInterstitial;
    }
}
