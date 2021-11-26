package com.google.android.gms.internal.ads;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-base@@20.1.0 */
final class zzerh extends WeakReference<Throwable> {
    private final int zza;

    public zzerh(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        Objects.requireNonNull(th, "The referent cannot be null");
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzerh.class) {
            if (this == obj) {
                return true;
            }
            zzerh zzerh = (zzerh) obj;
            return this.zza == zzerh.zza && get() == zzerh.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
