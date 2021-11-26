package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdkr implements Callable {
    private final zzdks zza;

    zzdkr(zzdks zzdks) {
        this.zza = zzdks;
    }

    public final Object call() {
        return new zzdkt(this.zza.zzb);
    }
}
