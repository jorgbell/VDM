package com.google.android.gms.internal.ads;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzduf implements zzeyl<ScheduledExecutorService> {
    private final zzeyw<ThreadFactory> zza;

    public zzduf(zzeyw<ThreadFactory> zzeyw) {
        this.zza = zzeyw;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzebp.zza();
        ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, this.zza.zzb()));
        zzeyr.zzb(unconfigurableScheduledExecutorService);
        return unconfigurableScheduledExecutorService;
    }
}
