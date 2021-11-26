package com.flurry.sdk;

/* renamed from: com.flurry.sdk.bj */
public final class C1562bj {

    /* renamed from: a */
    private static C1562bj f3955a;

    private C1562bj() {
    }

    /* renamed from: a */
    public static synchronized C1562bj m4092a() {
        C1562bj bjVar;
        synchronized (C1562bj.class) {
            if (f3955a == null) {
                f3955a = new C1562bj();
            }
            bjVar = f3955a;
        }
        return bjVar;
    }
}
