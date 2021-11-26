package com.google.android.gms.internal.games;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzga extends zzgg<T> {
    private boolean zzmx;
    private final /* synthetic */ Object zzmy;

    zzga(Object obj) {
        this.zzmy = obj;
    }

    public final boolean hasNext() {
        return !this.zzmx;
    }

    public final T next() {
        if (!this.zzmx) {
            this.zzmx = true;
            return this.zzmy;
        }
        throw new NoSuchElementException();
    }
}
