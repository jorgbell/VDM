package com.google.android.gms.ads.mediation.rtb;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class RtbAdapter extends Adapter {
    public abstract void collectSignals(@RecentlyNonNull RtbSignalData rtbSignalData, @RecentlyNonNull SignalCallbacks signalCallbacks);

    public void loadRtbBannerAd(@RecentlyNonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationBannerAd, Object> mediationAdLoadCallback) {
        loadBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbInterscrollerAd(@RecentlyNonNull MediationBannerAdConfiguration mediationBannerAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationInterscrollerAd, Object> mediationAdLoadCallback) {
        mediationAdLoadCallback.onFailure(new AdError(7, String.valueOf(getClass().getSimpleName()).concat(" does not support interscroller ads."), "com.google.android.gms.ads"));
    }

    public void loadRtbInterstitialAd(@RecentlyNonNull MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationInterstitialAd, Object> mediationAdLoadCallback) {
        loadInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbNativeAd(@RecentlyNonNull MediationNativeAdConfiguration mediationNativeAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<UnifiedNativeAdMapper, Object> mediationAdLoadCallback) {
        loadNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbRewardedAd(@RecentlyNonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationRewardedAd, Object> mediationAdLoadCallback) {
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbRewardedInterstitialAd(@RecentlyNonNull MediationRewardedAdConfiguration mediationRewardedAdConfiguration, @RecentlyNonNull MediationAdLoadCallback<MediationRewardedAd, Object> mediationAdLoadCallback) {
        loadRewardedInterstitialAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }
}
