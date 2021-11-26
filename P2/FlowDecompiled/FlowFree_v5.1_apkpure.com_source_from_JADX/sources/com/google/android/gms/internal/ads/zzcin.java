package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcin implements zzeyl<zzcil> {
    private final zzeyw<zzdrg> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzckt> zzc;

    public zzcin(zzeyw<zzdrg> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzckt> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcil(((zzbtw) this.zza).zza(), this.zzb.zzb(), this.zzc.zzb());
    }
}
