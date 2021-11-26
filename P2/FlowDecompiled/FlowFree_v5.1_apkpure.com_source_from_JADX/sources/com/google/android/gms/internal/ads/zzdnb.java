package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdnb implements zzeyl<zzdna> {
    private final zzeyw<Context> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzyx> zzc;
    private final zzeyw<zzbid> zzd;
    private final zzeyw<zzdda> zze;
    private final zzeyw<zzdde> zzf;
    private final zzeyw<zzdrf> zzg;

    public zzdnb(zzeyw<Context> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzyx> zzeyw3, zzeyw<zzbid> zzeyw4, zzeyw<zzdda> zzeyw5, zzeyw<zzdde> zzeyw6, zzeyw<zzdrf> zzeyw7) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdna(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb(), this.zzf.zzb(), new zzdrf());
    }
}
