package com.flurry.sdk;

import java.util.concurrent.Future;

/* renamed from: com.flurry.sdk.g */
public class C1783g extends C1848i {
    C1783g(String str) {
        super(str, (C1818h) null, true);
    }

    public void runSync(Runnable runnable) {
        super.runSync(runnable);
    }

    public Future<Void> runAsync(Runnable runnable) {
        return super.runAsync(runnable);
    }

    public Future<Void> runAfter(Runnable runnable, long j) {
        return super.runAfter(runnable, j);
    }
}
