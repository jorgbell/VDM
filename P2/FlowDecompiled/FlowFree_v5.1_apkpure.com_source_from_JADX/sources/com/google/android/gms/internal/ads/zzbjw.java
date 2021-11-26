package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbjw implements zzdnd {
    final /* synthetic */ zzbko zza;
    private final Context zzb;
    private final zzyx zzc;
    private final String zzd;
    private final zzeyw<Context> zze;
    private final zzeyw<zzyx> zzf;
    private final zzeyw<zzdda> zzg;
    private final zzeyw<zzdde> zzh;
    private final zzeyw<zzdna> zzi;

    /* synthetic */ zzbjw(zzbko zzbko, Context context, String str, zzyx zzyx, zzbjd zzbjd) {
        this.zza = zzbko;
        this.zzb = context;
        this.zzc = zzyx;
        this.zzd = str;
        zzeyl zza2 = zzeym.zza(context);
        this.zze = zza2;
        zzeyl zza3 = zzeym.zza(zzyx);
        this.zzf = zza3;
        zzeyw<zzdda> zza4 = zzeyk.zza(new zzddb(zzbko.zzm));
        this.zzg = zza4;
        zzeyw<zzdde> zza5 = zzeyk.zza(zzddg.zza());
        this.zzh = zza5;
        this.zzi = zzeyk.zza(new zzdnb(zza2, zzbko.zzn, zza3, zzbko.zzL, zza4, zza5, zzdri.zza()));
    }

    public final zzdci zza() {
        return new zzdci(this.zzb, this.zzc, this.zzd, this.zzi.zzb(), this.zzg.zzb());
    }
}
