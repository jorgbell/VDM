package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzclp implements zzeyl<zzug> {
    private final zzeyw<Context> zza;
    private final zzeyw<String> zzb;
    private final zzeyw<zzbbq> zzc;
    private final zzeyw<zzuq> zzd;
    private final zzeyw<String> zze;

    public zzclp(zzeyw<Context> zzeyw, zzeyw<String> zzeyw2, zzeyw<zzbbq> zzeyw3, zzeyw<zzuq> zzeyw4, zzeyw<String> zzeyw5) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzbii) this.zza).zza();
        String zza3 = ((zzcrd) this.zzb).zzb();
        zzbbq zza4 = ((zzbir) this.zzc).zza();
        zzuq zzb2 = this.zzd.zzb();
        String zzb3 = this.zze.zzb();
        zzug zzug = new zzug(new zzum(zza2));
        zzxj zza5 = zzxk.zza();
        zza5.zza(zza4.zzb);
        zza5.zzb(zza4.zzc);
        zza5.zzc(true != zza4.zzd ? 2 : 0);
        zzug.zzc(new zzclo(zzb2, zza3, (zzxk) zza5.zzah(), zzb3));
        return zzug;
    }
}
