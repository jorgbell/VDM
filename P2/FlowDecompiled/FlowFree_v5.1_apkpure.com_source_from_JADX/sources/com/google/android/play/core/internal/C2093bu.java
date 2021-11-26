package com.google.android.play.core.internal;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.play.core.internal.bu */
final class C2093bu extends WeakReference<Throwable> {

    /* renamed from: a */
    private final int f5195a;

    public C2093bu(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        this.f5195a = System.identityHashCode(th);
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == C2093bu.class) {
            if (this == obj) {
                return true;
            }
            C2093bu buVar = (C2093bu) obj;
            return this.f5195a == buVar.f5195a && get() == buVar.get();
        }
    }

    public final int hashCode() {
        return this.f5195a;
    }
}
