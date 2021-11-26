package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdii implements zzeyl<zzdig> {
    private final zzeyw<zzefx> zza;
    private final zzeyw<ScheduledExecutorService> zzb;
    private final zzeyw<String> zzc;
    private final zzeyw<zzdbz> zzd;
    private final zzeyw<Context> zze;
    private final zzeyw<zzdrg> zzf;
    private final zzeyw<zzdbu> zzg;

    public zzdii(zzeyw<zzefx> zzeyw, zzeyw<ScheduledExecutorService> zzeyw2, zzeyw<String> zzeyw3, zzeyw<zzdbz> zzeyw4, zzeyw<Context> zzeyw5, zzeyw<zzdrg> zzeyw6, zzeyw<zzdbu> zzeyw7) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
        this.zzg = zzeyw7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdig(zzefx, this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb(), ((zzbtw) this.zzf).zza(), this.zzg.zzb());
    }
}
