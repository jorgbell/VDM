package com.google.android.play.core.splitinstall;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.play.core.splitinstall.o */
public final class C2159o {

    /* renamed from: a */
    private static final AtomicReference<C2158n> f5286a = new AtomicReference<>((Object) null);

    /* renamed from: b */
    public static void m5419b(C2158n nVar) {
        f5286a.compareAndSet((Object) null, nVar);
    }
}
