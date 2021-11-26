package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdjq implements zzeyl<zzdjo> {
    private final zzeyw<zzbao> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<ScheduledExecutorService> zzc;
    private final zzeyw<Executor> zzd;
    private final zzeyw<Integer> zze;

    public zzdjq(zzeyw<zzbao> zzeyw, zzeyw<Context> zzeyw2, zzeyw<ScheduledExecutorService> zzeyw3, zzeyw<Executor> zzeyw4, zzeyw<Integer> zzeyw5) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdjo(new zzbao(), ((zzbii) this.zzb).zza(), this.zzc.zzb(), zzefx, ((zzdla) this.zze).zzb().intValue(), (byte[]) null);
    }
}
