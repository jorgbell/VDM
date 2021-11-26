package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* renamed from: com.flurry.sdk.cw */
public final class C1641cw<V> extends FutureTask<V> {

    /* renamed from: a */
    private final WeakReference<Callable<V>> f4143a = new WeakReference<>((Object) null);

    /* renamed from: b */
    private final WeakReference<Runnable> f4144b;

    public C1641cw(Runnable runnable, V v) {
        super(runnable, v);
        this.f4144b = new WeakReference<>(runnable);
    }

    /* renamed from: a */
    public final Runnable mo11422a() {
        return (Runnable) this.f4144b.get();
    }
}
