package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzctc implements Callable {
    private final zzctk zza;
    private final zzefw zzb;
    private final zzefw zzc;

    zzctc(zzctk zzctk, zzefw zzefw, zzefw zzefw2) {
        this.zza = zzctk;
        this.zzb = zzefw;
        this.zzc = zzefw2;
    }

    public final Object call() {
        return this.zza.zzj(this.zzb, this.zzc);
    }
}
