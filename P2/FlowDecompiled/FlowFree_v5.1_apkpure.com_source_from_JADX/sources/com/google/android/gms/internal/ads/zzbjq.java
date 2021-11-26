package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbjq implements zzdlt {
    final /* synthetic */ zzbko zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<String> zzc;
    private final zzeyw<zzdof<zzbnp, zzbnv>> zzd;
    private final zzeyw<zzdmm> zze;
    private final zzeyw<zzdlk> zzf;
    private final zzeyw<zzdlq> zzg;
    private final zzeyw<zzdof<zzboa, zzbof>> zzh;
    private final zzeyw<zzdmo> zzi;
    private final zzeyw<zzdmu> zzj;

    /* synthetic */ zzbjq(zzbko zzbko, Context context, String str, zzbjd zzbjd) {
        this.zza = zzbko;
        zzeyl zza2 = zzeym.zza(context);
        this.zzb = zza2;
        zzeyl zza3 = zzeym.zza(str);
        this.zzc = zza3;
        zzdoj zzdoj = new zzdoj(zza2, zzbko.zzaq, zzbko.zzar);
        this.zzd = zzdoj;
        zzeyw<zzdmm> zza4 = zzeyk.zza(new zzdmn(zzbko.zzaq));
        this.zze = zza4;
        zzeyw<zzdmm> zzeyw = zza4;
        zzeyw<zzdlk> zza5 = zzeyk.zza(new zzdll(zza2, zzbko.zzn, zzbko.zzL, zzdoj, zzeyw, zzdri.zza()));
        this.zzf = zza5;
        this.zzg = zzeyk.zza(new zzdlr(zzbko.zzL, zza2, zza3, zza5, zzeyw, zzbko.zzg));
        zzdoi zzdoi = new zzdoi(zza2, zzbko.zzaq, zzbko.zzar);
        this.zzh = zzdoi;
        zzeyw<zzdmo> zza6 = zzeyk.zza(new zzdmp(zza2, zzbko.zzn, zzbko.zzL, zzdoi, zzeyw, zzdri.zza()));
        this.zzi = zza6;
        this.zzj = zzeyk.zza(new zzdmv(zzbko.zzL, zza2, zza3, zza6, zzeyw));
    }

    public final zzdlq zza() {
        return this.zzg.zzb();
    }

    public final zzdmu zzb() {
        return this.zzj.zzb();
    }
}
