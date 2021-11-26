package com.google.android.gms.internal.ads;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzegc extends zzefz implements ScheduledExecutorService, zzefx {
    final ScheduledExecutorService zza;

    zzegc(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        Objects.requireNonNull(scheduledExecutorService);
        this.zza = scheduledExecutorService;
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        zzegl zza2 = zzegl.zza(runnable, null);
        return new zzega(zza2, this.zza.schedule(zza2, j, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzegb zzegb = new zzegb(runnable);
        return new zzega(zzegb, this.zza.scheduleAtFixedRate(zzegb, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        zzegb zzegb = new zzegb(runnable);
        return new zzega(zzegb, this.zza.scheduleWithFixedDelay(zzegb, j, j2, timeUnit));
    }

    public final /* bridge */ /* synthetic */ ScheduledFuture schedule(Callable callable, long j, TimeUnit timeUnit) {
        zzegl zzegl = new zzegl(callable);
        return new zzega(zzegl, this.zza.schedule(zzegl, j, timeUnit));
    }
}
