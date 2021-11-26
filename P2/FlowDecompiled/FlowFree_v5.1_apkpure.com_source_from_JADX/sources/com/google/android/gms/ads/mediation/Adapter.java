package com.google.android.gms.ads.mediation;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class Adapter {
    @RecentlyNonNull
    public abstract VersionInfo getSDKVersionInfo();

    @RecentlyNonNull
    public abstract VersionInfo getVersionInfo();

    public abstract void initialize(@RecentlyNonNull Context context, @RecentlyNonNull InitializationCompleteCallback initializationCompleteCallback, @RecentlyNonNull List<MediationConfiguration> list);

    public void loadBannerAd(@RecentlyNonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationBannerAd, Object> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support banner ads."), "com.google.android.gms.ads"));
    }

    public void loadInterscrollerAd(@RecentlyNonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationInterscrollerAd, Object> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support interscroller ads."), "com.google.android.gms.ads"));
    }

    public void loadInterstitialAd(@RecentlyNonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationInterstitialAd, Object> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support interstitial ads."), "com.google.android.gms.ads"));
    }

    public void loadNativeAd(@RecentlyNonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<UnifiedNativeAdMapper, Object> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support native ads."), "com.google.android.gms.ads"));
    }

    public void loadRewardedAd(@RecentlyNonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationRewardedAd, Object> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support rewarded ads."), "com.google.android.gms.ads"));
    }

    public void loadRewardedInterstitialAd(@RecentlyNonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationRewardedAd, Object> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support rewarded interstitial ads."), "com.google.android.gms.ads"));
    }
}
