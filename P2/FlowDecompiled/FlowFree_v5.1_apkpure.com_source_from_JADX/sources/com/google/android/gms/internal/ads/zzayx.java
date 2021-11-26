package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzayx implements zzeyl<zzayw> {
    private final zzeyw<Clock> zza;
    private final zzeyw<zzayu> zzb;

    public zzayx(zzeyw<Clock> zzeyw, zzeyw<zzayu> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    /* renamed from: zza */
    public final zzayw zzb() {
        return new zzayw(this.zza.zzb(), this.zzb.zzb());
    }
}
