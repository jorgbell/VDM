package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcqm implements Callable {
    private final zzcqp zza;
    private final zzawc zzb;

    zzcqm(zzcqp zzcqp, zzawc zzawc) {
        this.zza = zzcqp;
        this.zzb = zzawc;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb);
    }
}
