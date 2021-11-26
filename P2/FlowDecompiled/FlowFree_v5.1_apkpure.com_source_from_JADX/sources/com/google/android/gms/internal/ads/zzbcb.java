package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzbcb<T> implements zzefw<T> {
    private final zzege<T> zza = zzege.zza();

    private static final boolean zza(boolean z) {
        if (!z) {
            zzs.zzg().zzh(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    public boolean cancel(boolean z) {
        return this.zza.cancel(z);
    }

    public final T get() throws ExecutionException, InterruptedException {
        return this.zza.get();
    }

    public final boolean isCancelled() {
        return this.zza.isCancelled();
    }

    public final boolean isDone() {
        return this.zza.isDone();
    }

    public final boolean zzc(T t) {
        boolean zzh = this.zza.zzh(t);
        zza(zzh);
        return zzh;
    }

    public final boolean zzd(Throwable th) {
        boolean zzi = this.zza.zzi(th);
        zza(zzi);
        return zzi;
    }

    public final void zze(Runnable runnable, Executor executor) {
        this.zza.zze(runnable, executor);
    }

    public final T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zza.get(j, timeUnit);
    }
}
