package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzafq implements zzeyl<zzafp> {
    private final zzeyw<Context> zza;
    private final zzeyw<ScheduledExecutorService> zzb;
    private final zzeyw<zzafr> zzc;

    public zzafq(zzeyw<Context> zzeyw, zzeyw<ScheduledExecutorService> zzeyw2, zzeyw<zzafr> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzafp(((zzdsk) this.zza).zza(), this.zzb.zzb(), new zzafr(), (byte[]) null);
    }
}
