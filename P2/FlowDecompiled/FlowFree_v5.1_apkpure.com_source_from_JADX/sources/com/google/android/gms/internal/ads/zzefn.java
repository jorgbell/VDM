package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzefn<V> {
    private final boolean zza;
    private final zzede<zzefw<? extends V>> zzb;

    /* synthetic */ zzefn(boolean z, zzede zzede, zzefl zzefl) {
        this.zza = z;
        this.zzb = zzede;
    }

    public final <C> zzefw<C> zza(Callable<C> callable, Executor executor) {
        return new zzefb(this.zzb, this.zza, executor, callable);
    }
}
