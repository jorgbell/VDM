package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdkf implements zzeyl<zzdkd> {
    private final zzeyw<zzbao> zza;
    private final zzeyw<Integer> zzb;
    private final zzeyw<Context> zzc;
    private final zzeyw<zzbav> zzd;
    private final zzeyw<ScheduledExecutorService> zze;
    private final zzeyw<Executor> zzf;

    public zzdkf(zzeyw<zzbao> zzeyw, zzeyw<Integer> zzeyw2, zzeyw<Context> zzeyw3, zzeyw<zzbav> zzeyw4, zzeyw<ScheduledExecutorService> zzeyw5, zzeyw<Executor> zzeyw6) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
        this.zzf = zzeyw6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdkd(new zzbao(), ((zzdla) this.zzb).zzb().intValue(), ((zzbii) this.zzc).zza(), this.zzd.zzb(), this.zze.zzb(), zzefx, (byte[]) null);
    }
}
