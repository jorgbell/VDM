package com.mopub.mobileads;

import android.app.Activity;
import android.content.Context;
import com.mopub.common.BaseLifecycleListener;
import com.mopub.common.LifecycleListener;
import com.mopub.common.MoPubReward;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.AdLifecycleListener;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.Map;

public class UnityRewardedVideo extends BaseAd {
    /* access modifiers changed from: private */
    public static final String ADAPTER_NAME = UnityRewardedVideo.class.getSimpleName();
    private static final LifecycleListener sLifecycleListener = new UnityLifecycleListener();
    private int impressionOrdinal;
    private Activity mLauncherActivity;
    /* access modifiers changed from: private */
    public String mPlacementId;
    private UnityAdsAdapterConfiguration mUnityAdsAdapterConfiguration = new UnityAdsAdapterConfiguration();
    private IUnityAdsLoadListener mUnityLoadListener = new IUnityAdsLoadListener() {
        public void onUnityAdsAdLoaded(String str) {
            String unused = UnityRewardedVideo.this.mPlacementId = str;
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity rewarded video successfully loaded for placementId " + str);
            MoPubLog.log(MoPubLog.AdapterLogEvent.LOAD_SUCCESS, UnityRewardedVideo.ADAPTER_NAME);
            AdLifecycleListener.LoadListener loadListener = UnityRewardedVideo.this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoaded();
            }
        }

        public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
            String unused = UnityRewardedVideo.this.mPlacementId = str;
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity rewarded video failed to load for placement " + str + ", with error message: " + str2);
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.LOAD_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.NETWORK_NO_FILL;
            MoPubLog.log(adapterLogEvent2, UnityRewardedVideo.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.LoadListener loadListener = UnityRewardedVideo.this.mLoadListener;
            if (loadListener != null) {
                loadListener.onAdLoadFailed(moPubErrorCode);
            }
        }
    };
    private IUnityAdsShowListener mUnityShowListener = new IUnityAdsShowListener() {
        public void onUnityAdsShowStart(String str) {
            AdLifecycleListener.InteractionListener interactionListener = UnityRewardedVideo.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdShown();
                UnityRewardedVideo.this.mInteractionListener.onAdImpression();
            }
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity rewarded video started for placement " + UnityRewardedVideo.this.mPlacementId + ".");
            MoPubLog.log(MoPubLog.AdapterLogEvent.SHOW_SUCCESS, UnityRewardedVideo.ADAPTER_NAME);
        }

        public void onUnityAdsShowClick(String str) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity rewarded video clicked for placement " + str + ".");
            MoPubLog.log(MoPubLog.AdapterLogEvent.CLICKED, UnityRewardedVideo.ADAPTER_NAME);
            AdLifecycleListener.InteractionListener interactionListener = UnityRewardedVideo.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdClicked();
            }
        }

        public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity Ad finished with finish state = " + unityAdsShowCompletionState);
            if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.COMPLETED) {
                MoPubLog.log(MoPubLog.AdapterLogEvent.SHOULD_REWARD, UnityRewardedVideo.ADAPTER_NAME, Integer.valueOf(MoPubReward.NO_REWARD_AMOUNT), "");
                AdLifecycleListener.InteractionListener interactionListener = UnityRewardedVideo.this.mInteractionListener;
                if (interactionListener != null) {
                    interactionListener.onAdComplete(MoPubReward.success("", 0));
                    MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity rewarded video completed for placement " + str);
                }
            } else if (unityAdsShowCompletionState == UnityAds.UnityAdsShowCompletionState.SKIPPED) {
                MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity ad was skipped, no reward will be given.");
            }
            AdLifecycleListener.InteractionListener interactionListener2 = UnityRewardedVideo.this.mInteractionListener;
            if (interactionListener2 != null) {
                interactionListener2.onAdDismissed();
            }
        }

        public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
            MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
            MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity rewarded video encountered a playback error for placement " + str + ", with error message: " + str2);
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
            MoPubLog.log(adapterLogEvent2, UnityRewardedVideo.ADAPTER_NAME, Integer.valueOf(moPubErrorCode.getIntCode()), moPubErrorCode);
            AdLifecycleListener.InteractionListener interactionListener = UnityRewardedVideo.this.mInteractionListener;
            if (interactionListener != null) {
                interactionListener.onAdFailed(moPubErrorCode);
            }
        }
    };

    /* access modifiers changed from: protected */
    public void onInvalidate() {
    }

    public LifecycleListener getLifecycleListener() {
        return sLifecycleListener;
    }

    public String getAdNetworkId() {
        return this.mPlacementId;
    }

    public boolean checkAndInitializeSdk(Activity activity, AdData adData) {
        Preconditions.checkNotNull(activity);
        Preconditions.checkNotNull(adData);
        this.mLauncherActivity = activity;
        Map<String, String> extras = adData.getExtras();
        if (UnityAds.isInitialized()) {
            return true;
        }
        this.mUnityAdsAdapterConfiguration.setCachedInitializationParameters(activity, extras);
        if (UnityAds.isInitialized()) {
            return true;
        }
        UnityRouter.initUnityAds(extras, activity, new IUnityAdsInitializationListener(this) {
            public void onInitializationComplete() {
                MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, UnityRewardedVideo.ADAPTER_NAME, "Unity Ads successfully initialized.");
            }

            public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
                if (str != null) {
                    MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
                    MoPubLog.log(adapterLogEvent, UnityRewardedVideo.ADAPTER_NAME, "Unity Ads failed to initialize initialize with message: " + str);
                }
            }
        });
        return false;
    }

    /* access modifiers changed from: protected */
    public void load(Context context, AdData adData) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(adData);
        setAutomaticImpressionAndClickTracking(false);
        UnityAds.load(UnityRouter.placementIdForServerExtras(adData.getExtras(), ""), this.mUnityLoadListener);
    }

    public void show() {
        MoPubLog.AdapterLogEvent adapterLogEvent = MoPubLog.AdapterLogEvent.SHOW_ATTEMPTED;
        String str = ADAPTER_NAME;
        MoPubLog.log(adapterLogEvent, str);
        if (this.mLauncherActivity == null) {
            MoPubLog.log(MoPubLog.AdapterLogEvent.CUSTOM, str, "Failed to show Unity rewarded video as the activity calling it is null.");
            MoPubLog.AdapterLogEvent adapterLogEvent2 = MoPubLog.AdapterLogEvent.SHOW_FAILED;
            MoPubErrorCode moPubErrorCode = MoPubErrorCode.VIDEO_PLAYBACK_ERROR;
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
        MediationMetaData mediationMetaData = new MediationMetaData(this.mLauncherActivity);
        int i = this.impressionOrdinal + 1;
        this.impressionOrdinal = i;
        mediationMetaData.setOrdinal(i);
        mediationMetaData.commit();
        UnityAds.show(this.mLauncherActivity, this.mPlacementId, this.mUnityShowListener);
    }

    private static final class UnityLifecycleListener extends BaseLifecycleListener {
        private UnityLifecycleListener() {
        }

        public void onCreate(Activity activity) {
            super.onCreate(activity);
        }

        public void onResume(Activity activity) {
            super.onResume(activity);
        }
    }
}
