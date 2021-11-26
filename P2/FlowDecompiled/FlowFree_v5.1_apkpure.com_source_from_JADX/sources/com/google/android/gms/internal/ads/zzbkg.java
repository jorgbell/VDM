package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbkg implements zzdow {
    final /* synthetic */ zzbko zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<zzyx> zzc;
    private final zzeyw<String> zzd;
    private final zzeyw<zzdda> zze;
    private final zzeyw<zzdps> zzf;
    private final zzeyw<zzdot> zzg;
    private final zzeyw<zzddi> zzh;

    /* synthetic */ zzbkg(zzbko zzbko, Context context, String str, zzyx zzyx, zzbjd zzbjd) {
        this.zza = zzbko;
        zzeyl zza2 = zzeym.zza(context);
        this.zzb = zza2;
        zzeyl zza3 = zzeym.zza(zzyx);
        this.zzc = zza3;
        zzeyl zza4 = zzeym.zza(str);
        this.zzd = zza4;
        zzeyw<zzdda> zza5 = zzeyk.zza(new zzddb(zzbko.zzm));
        this.zze = zza5;
        zzeyw<zzdps> zza6 = zzeyk.zza(new zzdpt(zzbko.zzaq));
        this.zzf = zza6;
        zzeyl zzeyl = zza2;
        zzeyw<zzdot> zza7 = zzeyk.zza(new zzdou(zzeyl, zzbko.zzn, zzbko.zzL, zza5, zza6, zzdri.zza()));
        this.zzg = zza7;
        this.zzh = zzeyk.zza(new zzddj(zzeyl, zza3, zza4, zza7, zza5, zza6));
    }

    public final zzddi zza() {
        return this.zzh.zzb();
    }
}
