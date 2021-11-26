package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcxn implements Callable {
    private final zzcxq zza;
    private final zzdra zzb;
    private final zzdqo zzc;

    zzcxn(zzcxq zzcxq, zzdra zzdra, zzdqo zzdqo) {
        this.zza = zzcxq;
        this.zzb = zzdra;
        this.zzc = zzdqo;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
