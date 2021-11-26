package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbtg implements zzeyl<zzbtf> {
    private final zzeyw<zzbuv> zza;
    private final zzeyw<zzdqo> zzb;
    private final zzeyw<ScheduledExecutorService> zzc;
    private final zzeyw<Executor> zzd;

    public zzbtg(zzeyw<zzbuv> zzeyw, zzeyw<zzdqo> zzeyw2, zzeyw<ScheduledExecutorService> zzeyw3, zzeyw<Executor> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzbtf(this.zza.zzb(), ((zzbrb) this.zzb).zza(), this.zzc.zzb(), zzefx);
    }
}
