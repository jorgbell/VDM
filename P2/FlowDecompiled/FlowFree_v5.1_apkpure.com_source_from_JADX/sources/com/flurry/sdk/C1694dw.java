package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

/* renamed from: com.flurry.sdk.dw */
public final class C1694dw implements ThreadFactory {

    /* renamed from: a */
    private final ThreadGroup f4288a;

    /* renamed from: b */
    private final int f4289b = 1;

    public C1694dw(String str) {
        this.f4288a = new ThreadGroup(str);
    }

    public final Thread newThread(Runnable runnable) {
        Thread thread = new Thread(this.f4288a, runnable);
        thread.setName(this.f4288a.getName() + ":" + thread.getId());
        thread.setPriority(this.f4289b);
        return thread;
    }
}
