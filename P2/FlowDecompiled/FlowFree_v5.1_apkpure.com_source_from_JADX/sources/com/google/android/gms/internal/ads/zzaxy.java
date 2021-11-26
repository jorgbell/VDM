package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxy extends zzaxr {
    private final RewardedAdLoadCallback zza;
    private final RewardedAd zzb;

    public zzaxy(RewardedAdLoadCallback rewardedAdLoadCallback, RewardedAd rewardedAd) {
        this.zza = rewardedAdLoadCallback;
        this.zzb = rewardedAd;
    }

    public final void zze() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zza;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onAdLoaded(this.zzb);
        }
    }

    public final void zzf(int i) {
    }

    public final void zzg(zzym zzym) {
        if (this.zza != null) {
            this.zza.onAdFailedToLoad(zzym.zzb());
        }
    }
}
