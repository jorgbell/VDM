package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdiy;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdhs<S extends zzdiy> implements zzdiz<S> {
    private final zzdiz<S> zza;
    private final long zzb;
    private final ScheduledExecutorService zzc;

    public zzdhs(zzdiz<S> zzdiz, long j, ScheduledExecutorService scheduledExecutorService) {
        this.zza = zzdiz;
        this.zzb = j;
        this.zzc = scheduledExecutorService;
    }

    public final zzefw<S> zza() {
        zzefw<S> zza2 = this.zza.zza();
        long j = this.zzb;
        if (j > 0) {
            zza2 = zzefo.zzg(zza2, j, TimeUnit.MILLISECONDS, this.zzc);
        }
        return zzefo.zzf(zza2, Throwable.class, zzdhr.zza, zzbbw.zzf);
    }
}
