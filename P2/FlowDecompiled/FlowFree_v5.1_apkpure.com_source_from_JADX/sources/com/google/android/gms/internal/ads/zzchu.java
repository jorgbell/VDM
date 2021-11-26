package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzchu implements zzeyl<zzcht> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzchf> zzb;
    private final zzeyw<zzfh> zzc;
    private final zzeyw<zzbbq> zzd;
    private final zzeyw<zza> zze;
    private final zzeyw<zzug> zzf;
    private final zzeyw<Executor> zzg;
    private final zzeyw<zzdrg> zzh;
    private final zzeyw<zzcil> zzi;
    private final zzeyw<ScheduledExecutorService> zzj;

    public zzchu(zzeyw<Context> zzeyw, zzeyw<zzchf> zzeyw2, zzeyw<zzfh> zzeyw3, zzeyw<zzbbq> zzeyw4, zzeyw<zza> zzeyw5, zzeyw<zzug> zzeyw6, zzeyw<Executor> zzeyw7, zzeyw<zzdrg> zzeyw8, zzeyw<zzcil> zzeyw9, zzeyw<ScheduledExecutorService> zzeyw10) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
        this.zzh = zzeyw8;
        this.zzi = zzeyw9;
        this.zzj = zzeyw10;
    }

    /* renamed from: zza */
    public final zzcht zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcht(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), ((zzbir) this.zzd).zza(), zzbkq.zza(), this.zzf.zzb(), zzefx, ((zzbtw) this.zzh).zza(), this.zzi.zzb(), this.zzj.zzb());
    }
}
