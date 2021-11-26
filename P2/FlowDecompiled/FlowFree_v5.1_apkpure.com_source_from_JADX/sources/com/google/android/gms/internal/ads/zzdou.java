package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdou implements zzeyl<zzdot> {
    private final zzeyw<Context> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzbid> zzc;
    private final zzeyw<zzdda> zzd;
    private final zzeyw<zzdps> zze;
    private final zzeyw<zzdrf> zzf;

    public zzdou(zzeyw<Context> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzbid> zzeyw3, zzeyw<zzdda> zzeyw4, zzeyw<zzdps> zzeyw5, zzeyw<zzdrf> zzeyw6) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdot(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb(), new zzdrf());
    }
}
