package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbol implements zzeyl<zzbwr> {
    private final zzeyw<ScheduledExecutorService> zza;
    private final zzeyw<Clock> zzb;

    public zzbol(zzeyw<ScheduledExecutorService> zzeyw, zzeyw<Clock> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    /* renamed from: zza */
    public final zzbwr zzb() {
        return new zzbwr(this.zza.zzb(), this.zzb.zzb());
    }
}
