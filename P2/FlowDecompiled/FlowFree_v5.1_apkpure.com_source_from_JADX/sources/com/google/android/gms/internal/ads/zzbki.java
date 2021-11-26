package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbki implements zzdqi {
    final /* synthetic */ zzbko zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<zzdof<zzckb, zzcjw>> zzc;
    private final zzeyw<zzdps> zzd;
    private final zzeyw<zzdrb> zze;
    private final zzeyw<zzdqb> zzf;
    private final zzeyw<zzdql> zzg;
    private final zzeyw<String> zzh;
    private final zzeyw<zzdqf> zzi;

    /* synthetic */ zzbki(zzbko zzbko, Context context, String str, zzbjd zzbjd) {
        this.zza = zzbko;
        zzeyl zza2 = zzeym.zza(context);
        this.zzb = zza2;
        zzdok zzdok = new zzdok(zza2, zzbko.zzaq, zzbko.zzar);
        this.zzc = zzdok;
        zzeyw<zzdps> zza3 = zzeyk.zza(new zzdpt(zzbko.zzaq));
        this.zzd = zza3;
        zzeyw<zzdrb> zza4 = zzeyk.zza(zzdrd.zza());
        this.zze = zza4;
        zzeyw<zzdqb> zza5 = zzeyk.zza(new zzdqc(zza2, zzbko.zzn, zzbko.zzL, zzdok, zza3, zzdri.zza(), zza4));
        this.zzf = zza5;
        this.zzg = zzeyk.zza(new zzdqm(zza5, zza3, zza4));
        zzeyl zzc2 = zzeym.zzc(str);
        this.zzh = zzc2;
        this.zzi = zzeyk.zza(new zzdqg(zzc2, zza5, zza2, zza3, zza4));
    }

    public final zzdql zza() {
        return this.zzg.zzb();
    }

    public final zzdqf zzb() {
        return this.zzi.zzb();
    }
}
