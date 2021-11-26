package com.flurry.sdk;

/* renamed from: com.flurry.sdk.ic */
public final class C1853ic extends C1892jn {

    /* renamed from: a */
    private static int f4591a;

    private C1853ic(C1894jp jpVar) {
        super(jpVar);
    }

    /* renamed from: a */
    public final C1893jo mo11542a() {
        return C1893jo.APP_ORIENTATION;
    }

    /* renamed from: a */
    public static void m4714a(int i) {
        if (i != 0 && f4591a != i) {
            f4591a = i;
            C1735fb.m4502a().mo11504a(new C1853ic(new C1854id(i)));
        }
    }
}
