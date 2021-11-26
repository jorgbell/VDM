package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdjd<T> implements zzeyl<zzdjc<T>> {
    private final zzeyw<Executor> zza;
    private final zzeyw<Set<zzdiz<? extends zzdiy<T>>>> zzb;

    public zzdjd(zzeyw<Executor> zzeyw, zzeyw<Set<zzdiz<? extends zzdiy<T>>>> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    /* renamed from: zza */
    public final zzdjc<T> zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzdjc<>(zzefx, ((zzeyu) this.zzb).zzb());
    }
}
