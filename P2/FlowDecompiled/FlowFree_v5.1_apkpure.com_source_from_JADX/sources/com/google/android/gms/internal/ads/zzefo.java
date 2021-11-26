package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzefo extends zzefq {
    public static <V> zzefw<V> zza(@NullableDecl V v) {
        if (v == null) {
            return zzefs.zza;
        }
        return new zzefs(v);
    }

    public static <O> zzefw<O> zzc(Callable<O> callable, Executor executor) {
        zzegl zzegl = new zzegl(callable);
        executor.execute(zzegl);
        return zzegl;
    }

    public static <O> zzefw<O> zzd(zzeeu<O> zzeeu, Executor executor) {
        zzegl zzegl = new zzegl(zzeeu);
        executor.execute(zzegl);
        return zzegl;
    }

    public static <V, X extends Throwable> zzefw<V> zze(zzefw<? extends V> zzefw, Class<X> cls, zzecb<? super X, ? extends V> zzecb, Executor executor) {
        zzeef zzeef = new zzeef(zzefw, cls, zzecb);
        zzefw.zze(zzeef, zzegd.zzc(executor, zzeef));
        return zzeef;
    }

    public static <V, X extends Throwable> zzefw<V> zzf(zzefw<? extends V> zzefw, Class<X> cls, zzeev<? super X, ? extends V> zzeev, Executor executor) {
        zzeee zzeee = new zzeee(zzefw, cls, zzeev);
        zzefw.zze(zzeee, zzegd.zzc(executor, zzeee));
        return zzeee;
    }

    public static <V> zzefw<V> zzg(zzefw<V> zzefw, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzefw.isDone()) {
            return zzefw;
        }
        return zzegi.zza(zzefw, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzefw<O> zzh(zzefw<I> zzefw, zzeev<? super I, ? extends O> zzeev, Executor executor) {
        int i = zzeel.zzc;
        Objects.requireNonNull(executor);
        zzeej zzeej = new zzeej(zzefw, zzeev);
        zzefw.zze(zzeej, zzegd.zzc(executor, zzeej));
        return zzeej;
    }

    public static <I, O> zzefw<O> zzi(zzefw<I> zzefw, zzecb<? super I, ? extends O> zzecb, Executor executor) {
        int i = zzeel.zzc;
        Objects.requireNonNull(zzecb);
        zzeek zzeek = new zzeek(zzefw, zzecb);
        zzefw.zze(zzeek, zzegd.zzc(executor, zzeek));
        return zzeek;
    }

    public static <V> zzefw<List<V>> zzj(Iterable<? extends zzefw<? extends V>> iterable) {
        return new zzeew(zzede.zzl(iterable), true);
    }

    @SafeVarargs
    public static <V> zzefn<V> zzk(zzefw<? extends V>... zzefwArr) {
        return new zzefn<>(false, zzede.zzn(zzefwArr), (zzefl) null);
    }

    public static <V> zzefn<V> zzl(Iterable<? extends zzefw<? extends V>> iterable) {
        return new zzefn<>(false, zzede.zzl(iterable), (zzefl) null);
    }

    @SafeVarargs
    public static <V> zzefn<V> zzm(zzefw<? extends V>... zzefwArr) {
        return new zzefn<>(true, zzede.zzn(zzefwArr), (zzefl) null);
    }

    public static <V> zzefn<V> zzn(Iterable<? extends zzefw<? extends V>> iterable) {
        return new zzefn<>(true, zzede.zzl(iterable), (zzefl) null);
    }

    public static <V> V zzp(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return zzegn.zza(future);
        }
        throw new IllegalStateException(zzecs.zzd("Future was expected to be done: %s", future));
    }

    public static <V> V zzq(Future<V> future) {
        try {
            return zzegn.zza(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzefd((Error) cause);
            }
            throw new zzegm(cause);
        }
    }

    public static <V> zzefw<V> zzb(Throwable th) {
        Objects.requireNonNull(th);
        return new zzefr(th);
    }

    public static <V> void zzo(zzefw<V> zzefw, zzefk<? super V> zzefk, Executor executor) {
        Objects.requireNonNull(zzefk);
        zzefw.zze(new zzefm(zzefw, zzefk), executor);
    }
}
