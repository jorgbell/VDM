package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.LifecycleListener;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;

public class UnityInterstitial extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = "UnityInterstitial";
    private int impressionOrdinal;
    private Context mContext;
    /* access modifiers changed from: private */
    public String mPlacementId;
    private UnityAdsAdapterConfiguration mUnityAdsAdapterConfiguration = new UnityAdsAdapterConfiguration();
    private IUnityAdsLoadListener mUnityLoadListener = new IUnityAdsLoadListener() {
        public void onUnityAdsAdLoaded(String str) {
            String unused = UnityInterstitial.this.mPlacementId = str;
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityInterstitial.ADAPTER_NAME, "Unity interstitial successfully loaded for placementId " + str);
            MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_SUCCESS, UnityInterstitial.ADAPTER_NAME);
            AdLifecycleListener.LoadListener loadListener = UnityInterstitial.this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoaded();
            }
        }

        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
            String unused = UnityInterstitial.this.mPlacementId = str;
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityInterstitial.ADAPTER_NAME, "Unity interstitial failed to load for placement " + str + ", with error message: " + str2);
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adapterLogEvent2, UnityInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener = UnityInterstitial.this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(moPubErrorCode);
            }
        }
    };
    private IUnityAdsShowListener mUnityShowListener = new IUnityAdsShowListener() {
        public void onUnityAdsShowStart(String str) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.SHOW_SUCCESS, UnityInterstitial.ADAPTER_NAME);
            AdLifecycleListener.InteractionListener interactionListener = UnityInterstitial.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdShown();
                UnityInterstitial.this.mInteractionListener.onAdImpression();
            }
        }

        public void onUnityAdsShowClick(String str) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CLICKED, UnityInterstitial.ADAPTER_NAME);
            AdLifecycleListener.InteractionListener interactionListener = UnityInterstitial.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdClicked();
            }
        }

        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            if (UnityInterstitial.this.mInteractionListener != null) {
                MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                MoPubLog.log(adapterLogEvent, UnityInterstitial.ADAPTER_NAME, "Unity interstitial video completed for placement " + str);
                UnityInterstitial.this.mInteractionListener.onAdDismissed();
            }
        }

        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityInterstitial.ADAPTER_NAME, "Unity interstitial video encountered a playback error for placement " + str + ", with error message: " + str2);
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
            MoPubLog.log(adapterLogEvent2, UnityInterstitial.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.InteractionListener interactionListener = UnityInterstitial.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(moPubErrorCode);
            }
        }
    };

    /* access modifiers changed from: protected */
    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        return false;
    }

    /* access modifiers changed from: protected */
    public LifecycleListener getLifecycleListener() {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onInvalidate() {
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        Map<String, String> extras = adData.getExtras();
        this.mContext = context;
        setAutomaticImpressionAndClickTracking(false);
        if (!UnityAds.isInitialized()) {
            UnityRouter.initUnityAds(extras, context, new IUnityAdsInitializationListener(this) {
                public void onInitializationComplete() {
                    MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, UnityInterstitial.ADAPTER_NAME, "Unity Ads successfully initialized.");
                }

                public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                    if (str != null) {
                        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                        MoPubLog.log(adapterLogEvent, UnityInterstitial.ADAPTER_NAME, "Unity Ads failed to initialize initialize with message: " + str);
                    }
                }
            });
            if (this.mLoadListener != null) {
                MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.CUSTOM, ADAPTER_NAME, "Unity Ads adapter failed to request interstitial ad, Unity Ads is not initialized yet. Failing this ad request and calling Unity Ads initialization, so it would be available for an upcoming ad request");
                this.mLoadListener.onAdLoadFailed(MoPubErrorCode.ADAPTER_CONFIGURATION_ERROR);
                return;
            }
            return;
        }
        MoPubLog.log(getAdNetworkId(), MoPubLog.AdapterLogEvent.LOAD_ATTEMPTED, ADAPTER_NAME);
        UnityAds.load(UnityRouter.placementIdForServerExtras(extras, ""), this.mUnityLoadListener);
        this.mUnityAdsAdapterConfiguration.setCachedInitializationParameters(context, extras);
    }

    /* access modifiers changed from: protected */
    public void show() {
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adapterLogEvent, str);
        Context context = this.mContext;
        if (context == null || !(context instanceof Activity)) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, str, "Failed to show Unity interstitial as the context calling it is null, or is not an Activity");
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
        if (this.mPlacementId == null) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, str, "Unity Ads received call to show before successfully loading an ad");
        }
        MediationMetaData mediationMetaData = new MediationMetaData(this.mContext);
        int i = this.impressionOrdinal + 1;
        this.impressionOrdinal = i;
        mediationMetaData.setOrdinal(i);
        mediationMetaData.commit();
        UnityAds.show((Activity) this.mContext, this.mPlacementId, this.mUnityShowListener);
    }

    /* access modifiers changed from: protected */
    public String getAdNetworkId() {
        String str = this.mPlacementId;
        return str != null ? str : "";
    }
}
