package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrp implements zzeyl<zzcro> {
    private final zzeyw<zzdrg> zza;
    private final zzeyw<zzcqp> zzb;
    private final zzeyw<zzefx> zzc;
    private final zzeyw<ScheduledExecutorService> zzd;
    private final zzeyw<zzcuo> zze;

    public zzcrp(zzeyw<zzdrg> zzeyw, zzeyw<zzcqp> zzeyw2, zzeyw<zzefx> zzeyw3, zzeyw<ScheduledExecutorService> zzeyw4, zzeyw<zzcuo> zzeyw5) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzdrg zza2 = ((zzbtw) this.zza).zza();
        zzcqp zza3 = ((zzcqq) this.zzb).zzb();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcro(zza2, zza3, zzefx, this.zzd.zzb(), this.zze.zzb());
    }
}
