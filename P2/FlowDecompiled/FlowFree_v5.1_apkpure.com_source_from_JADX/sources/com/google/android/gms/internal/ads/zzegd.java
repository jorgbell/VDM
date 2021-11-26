package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzegd {
    public static Executor zza() {
        return zzefc.INSTANCE;
    }

    public static zzefx zzb(ExecutorService executorService) {
        zzefx zzefx;
        if (executorService instanceof zzefx) {
            return (zzefx) executorService;
        }
        if (executorService instanceof ScheduledExecutorService) {
            zzefx = new zzegc((ScheduledExecutorService) executorService);
        } else {
            zzefx = new zzefz(executorService);
        }
        return zzefx;
    }

    static Executor zzc(Executor executor, zzeeh<?> zzeeh) {
        Objects.requireNonNull(executor);
        if (executor == zzefc.INSTANCE) {
            return executor;
        }
        return new zzefy(executor, zzeeh);
    }
}
