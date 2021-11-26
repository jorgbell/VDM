package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;

/* renamed from: com.applovin.impl.sdk.e.y */
public class C1042y extends C0989a {

    /* renamed from: a */
    private final Runnable f2113a;

    public C1042y(C1062k kVar, Runnable runnable) {
        this(kVar, false, runnable);
    }

    public C1042y(C1062k kVar, boolean z, Runnable runnable) {
        super("TaskRunnable", kVar, z);
        this.f2113a = runnable;
    }

    public void run() {
        this.f2113a.run();
    }
}
