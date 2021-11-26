package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzedy<F, T> extends zzedx<F, T> implements ListIterator<T> {
    zzedy(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    public final void add(T t) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final boolean hasPrevious() {
        return this.zzb.hasPrevious();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final int nextIndex() {
        return this.zzb.nextIndex();
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final T previous() {
        return zza(this.zzb.previous());
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.util.ListIterator, java.util.Iterator<? extends F>] */
    public final int previousIndex() {
        return this.zzb.previousIndex();
    }

    public final void set(T t) {
        throw new UnsupportedOperationException();
    }
}
