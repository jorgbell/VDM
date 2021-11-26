package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdkn implements Callable {
    private final zzefw zza;
    private final zzefw zzb;

    zzdkn(zzefw zzefw, zzefw zzefw2) {
        this.zza = zzefw;
        this.zzb = zzefw2;
    }

    public final Object call() {
        return new zzdkp((String) this.zza.get(), (String) this.zzb.get());
    }
}
