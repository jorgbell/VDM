package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcrk implements zzeyl<zzcrj> {
    private final zzeyw<ScheduledExecutorService> zza;
    private final zzeyw<zzefx> zzb;
    private final zzeyw<zzcrz> zzc;
    private final zzeyw<zzctk> zzd;

    public zzcrk(zzeyw<ScheduledExecutorService> zzeyw, zzeyw<zzefx> zzeyw2, zzeyw<zzcrz> zzeyw3, zzeyw<zzctk> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    /* renamed from: zza */
    public final zzcrj zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcrj(this.zza.zzb(), zzefx, ((zzcsa) this.zzc).zzb(), zzeyk.zzc(this.zzd));
    }
}
