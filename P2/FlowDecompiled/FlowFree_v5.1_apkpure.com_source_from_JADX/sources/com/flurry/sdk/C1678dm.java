package com.flurry.sdk;

import android.app.ActivityManager;
import android.content.Context;

/* renamed from: com.flurry.sdk.dm */
public final class C1678dm {

    /* renamed from: a */
    public long f4264a = System.nanoTime();

    /* renamed from: b */
    public long f4265b;

    /* renamed from: c */
    public long f4266c;

    public C1678dm() {
        Runtime runtime = Runtime.getRuntime();
        this.f4265b = runtime.totalMemory() - runtime.freeMemory();
        Context a = C1536b.m4057a();
        if (a != null) {
            ActivityManager.MemoryInfo a2 = C1676dl.m4398a(a);
            this.f4266c = a2.totalMem - a2.availMem;
        }
    }
}
