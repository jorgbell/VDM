package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* renamed from: com.flurry.sdk.ct */
public final class C1638ct extends C1642cx<C1659df> {

    /* renamed from: b */
    private static C1638ct f4140b;

    protected C1638ct() {
        super("HttpRequestManager", TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new C1640cv()));
    }

    /* renamed from: a */
    public static synchronized C1638ct m4301a() {
        C1638ct ctVar;
        synchronized (C1638ct.class) {
            if (f4140b == null) {
                f4140b = new C1638ct();
            }
            ctVar = f4140b;
        }
        return ctVar;
    }
}
