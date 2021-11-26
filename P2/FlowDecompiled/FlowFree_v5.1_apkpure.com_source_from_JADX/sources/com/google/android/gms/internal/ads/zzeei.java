package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzeei extends AbstractExecutorService implements zzefx {
    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzegl.zza(runnable, t);
    }

    public final /* bridge */ /* synthetic */ Future submit(Runnable runnable) {
        return (zzefw) super.submit(runnable);
    }

    public final zzefw<?> zza(Runnable runnable) {
        return (zzefw) super.submit(runnable);
    }

    public final <T> zzefw<T> zzb(Callable<T> callable) {
        return (zzefw) super.submit(callable);
    }

    /* access modifiers changed from: protected */
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new zzegl(callable);
    }

    public final /* bridge */ /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzefw) super.submit(runnable, obj);
    }

    public final /* bridge */ /* synthetic */ Future submit(Callable callable) {
        return (zzefw) super.submit(callable);
    }
}
