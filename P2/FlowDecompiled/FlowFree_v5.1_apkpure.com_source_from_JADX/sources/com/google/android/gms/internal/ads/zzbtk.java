package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbtk implements Callable {
    private final zzbtl zza;
    private final zzefw zzb;

    zzbtk(zzbtl zzbtl, zzefw zzefw) {
        this.zza = zzbtl;
        this.zzb = zzefw;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb);
    }
}
