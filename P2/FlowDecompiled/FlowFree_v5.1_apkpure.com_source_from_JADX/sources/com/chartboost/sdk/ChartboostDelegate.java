package com.chartboost.sdk;

import com.chartboost.sdk.Model.CBError;

public abstract class ChartboostDelegate implements C1272a {
    public void didCacheInPlay(String str) {
    }

    public void didCacheInterstitial(String str) {
    }

    public void didCacheMoreApps(String str) {
    }

    public void didCacheRewardedVideo(String str) {
    }

    public void didClickInterstitial(String str) {
    }

    public void didClickMoreApps(String str) {
    }

    public void didClickRewardedVideo(String str) {
    }

    public void didCloseInterstitial(String str) {
    }

    public void didCloseMoreApps(String str) {
    }

    public void didCloseRewardedVideo(String str) {
    }

    public void didCompleteInterstitial(String str) {
    }

    public void didCompleteRewardedVideo(String str, int i) {
    }

    public void didDismissInterstitial(String str) {
    }

    public void didDismissMoreApps(String str) {
    }

    public void didDismissRewardedVideo(String str) {
    }

    public void didDisplayInterstitial(String str) {
    }

    public void didDisplayMoreApps(String str) {
    }

    public void didDisplayRewardedVideo(String str) {
    }

    public void didFailToLoadInPlay(String str, CBError.CBImpressionError cBImpressionError) {
    }

    public void didFailToLoadInterstitial(String str, CBError.CBImpressionError cBImpressionError) {
    }

    public void didFailToLoadMoreApps(String str, CBError.CBImpressionError cBImpressionError) {
    }

    public void didFailToLoadRewardedVideo(String str, CBError.CBImpressionError cBImpressionError) {
    }

    public void didFailToRecordClick(String str, CBError.CBClickError cBClickError) {
    }

    public void didInitialize() {
    }

    public boolean shouldDisplayInterstitial(String str) {
        return true;
    }

    public boolean shouldDisplayMoreApps(String str) {
        return true;
    }

    public boolean shouldDisplayRewardedVideo(String str) {
        return true;
    }

    public boolean shouldRequestInterstitial(String str) {
        return true;
    }

    public boolean shouldRequestMoreApps(String str) {
        return true;
    }

    public void willDisplayInterstitial(String str) {
    }

    public void willDisplayVideo(String str) {
    }
}
