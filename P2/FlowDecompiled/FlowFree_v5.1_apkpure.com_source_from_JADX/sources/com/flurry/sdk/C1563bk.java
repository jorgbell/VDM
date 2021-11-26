package com.flurry.sdk;

/* renamed from: com.flurry.sdk.bk */
public final class C1563bk {

    /* renamed from: a */
    private static C1563bk f3956a;

    private C1563bk() {
    }

    /* renamed from: a */
    public static synchronized C1563bk m4093a() {
        C1563bk bkVar;
        synchronized (C1563bk.class) {
            if (f3956a == null) {
                f3956a = new C1563bk();
            }
            bkVar = f3956a;
        }
        return bkVar;
    }
}
