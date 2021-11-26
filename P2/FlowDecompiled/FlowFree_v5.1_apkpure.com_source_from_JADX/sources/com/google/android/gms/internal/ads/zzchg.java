package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbe;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzchg implements zzeyl<zzchf> {
    private final zzeyw<zzbe> zza;
    private final zzeyw<Clock> zzb;
    private final zzeyw<Executor> zzc;

    public zzchg(zzeyw<zzbe> zzeyw, zzeyw<Clock> zzeyw2, zzeyw<Executor> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzchf(this.zza.zzb(), this.zzb.zzb(), zzefx);
    }
}
