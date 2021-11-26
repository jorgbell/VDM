package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdvg implements zzeyl<zzdve> {
    private final zzeyw<zzefx> zza;
    private final zzeyw<ScheduledExecutorService> zzb;
    private final zzeyw<zzdvd> zzc;

    public zzdvg(zzeyw<zzefx> zzeyw, zzeyw<ScheduledExecutorService> zzeyw2, zzeyw<zzdvd> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdve(zzefx, this.zzb.zzb(), ((zzdvh) this.zzc).zzb());
    }
}
