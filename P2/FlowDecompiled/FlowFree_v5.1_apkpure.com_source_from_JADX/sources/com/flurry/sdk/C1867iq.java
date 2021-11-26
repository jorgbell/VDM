package com.flurry.sdk;

/* renamed from: com.flurry.sdk.iq */
public final class C1867iq extends C1892jn {
    private C1867iq(C1894jp jpVar) {
        super(jpVar);
    }

    /* renamed from: a */
    public final C1893jo mo11542a() {
        return C1893jo.FRAME_COUNTER;
    }

    /* renamed from: b */
    public static C1867iq m4732b() {
        long b = C1739fe.m4515b("frame.counter", 0) + 1;
        C1739fe.m4512a("frame.counter", b);
        return new C1867iq(new C1868ir(b));
    }
}
