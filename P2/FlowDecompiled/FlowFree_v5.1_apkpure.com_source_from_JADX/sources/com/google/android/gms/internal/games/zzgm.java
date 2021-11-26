package com.google.android.gms.internal.games;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzgm extends WeakReference<Throwable> {
    private final int zznn;

    public zzgm(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zznn = System.identityHashCode(th);
    }

    public final int hashCode() {
        return this.zznn;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzgm.class) {
            if (this == obj) {
                return true;
            }
            zzgm zzgm = (zzgm) obj;
            return this.zznn == zzgm.zznn && get() == zzgm.get();
        }
    }
}
