package com.google.android.gms.internal.drive;

import java.util.Iterator;

final class zznc implements Iterator<String> {
    private final /* synthetic */ zzna zzvw;
    private Iterator<String> zzvx;

    zznc(zzna zzna) {
        this.zzvw = zzna;
        this.zzvx = zzna.zzvt.iterator();
    }

    public final boolean hasNext() {
        return this.zzvx.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzvx.next();
    }
}
