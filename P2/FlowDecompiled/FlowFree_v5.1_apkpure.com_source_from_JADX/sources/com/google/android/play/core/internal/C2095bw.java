package com.google.android.play.core.internal;

import java.util.Objects;

/* renamed from: com.google.android.play.core.internal.bw */
final class C2095bw extends C2092bt {

    /* renamed from: a */
    private final C2094bv f5198a = new C2094bv();

    C2095bw() {
    }

    /* renamed from: a */
    public final void mo22061a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.f5198a.mo22064a(th).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
