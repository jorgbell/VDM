package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzefj<V> extends zzefh<V> implements zzefw<V> {
    protected zzefj() {
    }

    /* access modifiers changed from: protected */
    public abstract zzefw<? extends V> zzc();

    public final void zze(Runnable runnable, Executor executor) {
        zzc().zze(runnable, executor);
    }
}
