package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdeh implements zzdiz {
    private final zzefw<String> zza;
    private final Executor zzb;

    public zzdeh(zzefw<String> zzefw, Executor executor) {
        this.zza = zzefw;
        this.zzb = executor;
    }

    public final zzefw zza() {
        return zzefo.zzh(this.zza, zzdef.zza, this.zzb);
    }
}
