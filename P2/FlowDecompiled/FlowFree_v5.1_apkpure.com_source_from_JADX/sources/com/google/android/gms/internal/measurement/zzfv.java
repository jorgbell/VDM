package com.google.android.gms.internal.measurement;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzfv extends WeakReference<Throwable> {
    private final int zza;

    public zzfv(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.zza = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzfv.class) {
            if (this == obj) {
                return true;
            }
            zzfv zzfv = (zzfv) obj;
            return this.zza == zzfv.zza && get() == zzfv.get();
        }
    }

    public final int hashCode() {
        return this.zza;
    }
}
