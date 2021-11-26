package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdqc implements zzeyl<zzdqb> {
    private final zzeyw<Context> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzbid> zzc;
    private final zzeyw<zzdof<zzckb, zzcjw>> zzd;
    private final zzeyw<zzdps> zze;
    private final zzeyw<zzdrf> zzf;
    private final zzeyw<zzdrb> zzg;

    public zzdqc(zzeyw<Context> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzbid> zzeyw3, zzeyw<zzdof<zzckb, zzcjw>> zzeyw4, zzeyw<zzdps> zzeyw5, zzeyw<zzdrf> zzeyw6, zzeyw<zzdrb> zzeyw7) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdqb(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), ((zzdok) this.zzd).zzb(), this.zze.zzb(), new zzdrf(), this.zzg.zzb());
    }
}
