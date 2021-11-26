package com.mopub.mobileads;

import com.mopub.common.MoPubReward;
import java.util.Set;

/* compiled from: MoPubRewardedAdListener.kt */
public interface MoPubRewardedAdListener {
    void onRewardedAdClicked(String str);

    void onRewardedAdClosed(String str);

    void onRewardedAdCompleted(Set<String> set, MoPubReward moPubReward);

    void onRewardedAdLoadFailure(String str, MoPubErrorCode moPubErrorCode);

    void onRewardedAdLoadSuccess(String str);

    void onRewardedAdShowError(String str, MoPubErrorCode moPubErrorCode);

    void onRewardedAdStarted(String str);
}
