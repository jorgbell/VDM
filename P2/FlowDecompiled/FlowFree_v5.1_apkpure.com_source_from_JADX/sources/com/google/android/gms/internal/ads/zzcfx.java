package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcfx implements zzeyl<zzcfw> {
    private final zzeyw<zzg> zza;
    private final zzeyw<zzdrg> zzb;
    private final zzeyw<zzcfc> zzc;
    private final zzeyw<zzcex> zzd;
    private final zzeyw<zzcgh> zze;
    private final zzeyw<zzcgp> zzf;
    private final zzeyw<Executor> zzg;
    private final zzeyw<Executor> zzh;
    private final zzeyw<zzceu> zzi;

    public zzcfx(zzeyw<zzg> zzeyw, zzeyw<zzdrg> zzeyw2, zzeyw<zzcfc> zzeyw3, zzeyw<zzcex> zzeyw4, zzeyw<zzcgh> zzeyw5, zzeyw<zzcgp> zzeyw6, zzeyw<Executor> zzeyw7, zzeyw<Executor> zzeyw8, zzeyw<zzceu> zzeyw9) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
        this.zzh = zzeyw8;
        this.zzi = zzeyw9;
    }

    /* renamed from: zza */
    public final zzcfw zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcfw(((zzdsj) this.zza).zzb(), ((zzbtw) this.zzb).zza(), this.zzc.zzb(), ((zzcfp) this.zzd).zza(), this.zze.zzb(), this.zzf.zzb(), this.zzg.zzb(), zzefx, this.zzi.zzb());
    }
}
