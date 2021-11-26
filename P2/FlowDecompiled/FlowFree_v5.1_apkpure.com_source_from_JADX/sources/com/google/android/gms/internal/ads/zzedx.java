package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzedx<F, T> implements Iterator<T> {
    final Iterator<? extends F> zzb;

    zzedx(Iterator<? extends F> it) {
        Objects.requireNonNull(it);
        this.zzb = it;
    }

    public final boolean hasNext() {
        return this.zzb.hasNext();
    }

    public final T next() {
        return zza(this.zzb.next());
    }

    public final void remove() {
        this.zzb.remove();
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(F f);
}
