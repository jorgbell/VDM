package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
final class zzacr extends zzzz {
    final /* synthetic */ zzacs zza;

    zzacr(zzacs zzacs) {
        this.zza = zzacs;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        this.zza.zze.zza(this.zza.zzw());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        this.zza.zze.zza(this.zza.zzw());
        super.onAdLoaded();
    }
}
