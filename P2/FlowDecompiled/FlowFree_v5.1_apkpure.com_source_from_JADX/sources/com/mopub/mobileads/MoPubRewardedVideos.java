package com.mopub.mobileads;

import com.mopub.common.MediationSettings;
import com.mopub.common.MoPubReward;
import com.mopub.common.util.ReflectionTarget;
import com.mopub.mobileads.MoPubRewardedAdManager;
import com.mopub.mobileads.MoPubRewardedVideoManager;
import java.util.Set;

@Deprecated
public class MoPubRewardedVideos {
    @ReflectionTarget
    public static void setRewardedVideoListener(final MoPubRewardedVideoListener moPubRewardedVideoListener) {
        if (moPubRewardedVideoListener == null) {
            MoPubRewardedAds.setRewardedAdListener((MoPubRewardedAdListener) null);
        } else {
            MoPubRewardedAds.setRewardedAdListener(new MoPubRewardedAdListener() {
                public void onRewardedAdCompleted(Set<String> set, MoPubReward moPubReward) {
                    moPubRewardedVideoListener.onRewardedVideoCompleted(set, moPubReward);
                }

                public void onRewardedAdClosed(String str) {
                    moPubRewardedVideoListener.onRewardedVideoClosed(str);
                }

                public void onRewardedAdClicked(String str) {
                    moPubRewardedVideoListener.onRewardedVideoClicked(str);
                }

                public void onRewardedAdShowError(String str, MoPubErrorCode moPubErrorCode) {
                    moPubRewardedVideoListener.onRewardedVideoPlaybackError(str, moPubErrorCode);
                }

                public void onRewardedAdStarted(String str) {
                    moPubRewardedVideoListener.onRewardedVideoStarted(str);
                }

                public void onRewardedAdLoadFailure(String str, MoPubErrorCode moPubErrorCode) {
                    moPubRewardedVideoListener.onRewardedVideoLoadFailure(str, moPubErrorCode);
                }

                public void onRewardedAdLoadSuccess(String str) {
                    moPubRewardedVideoListener.onRewardedVideoLoadSuccess(str);
                }
            });
        }
    }

    @ReflectionTarget
    public static void loadRewardedVideo(String str, MediationSettings... mediationSettingsArr) {
        MoPubRewardedAds.loadRewardedAd(str, mediationSettingsArr);
    }

    @ReflectionTarget
    public static void loadRewardedVideo(String str, MoPubRewardedVideoManager.RequestParameters requestParameters, MediationSettings... mediationSettingsArr) {
        MoPubRewardedAds.loadRewardedAd(str, requestParameters != null ? new MoPubRewardedAdManager.RequestParameters(requestParameters.mKeywords, requestParameters.mUserDataKeywords, requestParameters.mLocation, requestParameters.mCustomerId) : null, mediationSettingsArr);
    }

    @ReflectionTarget
    public static boolean hasRewardedVideo(String str) {
        return MoPubRewardedAds.hasRewardedAd(str);
    }

    @ReflectionTarget
    public static void showRewardedVideo(String str) {
        MoPubRewardedAds.showRewardedAd(str);
    }

    @ReflectionTarget
    public static void showRewardedVideo(String str, String str2) {
        MoPubRewardedAds.showRewardedAd(str, str2);
    }

    @ReflectionTarget
    public static Set<MoPubReward> getAvailableRewards(String str) {
        return MoPubRewardedAds.getAvailableRewards(str);
    }

    @ReflectionTarget
    public static void selectReward(String str, MoPubReward moPubReward) {
        MoPubRewardedAds.selectReward(str, moPubReward);
    }
}
