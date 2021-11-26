package com.flurry.sdk;

/* renamed from: com.flurry.sdk.cc */
public final class C1618cc {

    /* renamed from: a */
    public static final C1618cc f4084a = new C1618cc(C1619a.SUCCEED, (String) null);

    /* renamed from: b */
    public static final C1618cc f4085b = new C1618cc(C1619a.NO_CHANGE, (String) null);

    /* renamed from: c */
    String f4086c;

    /* renamed from: d */
    C1619a f4087d;

    public C1618cc(C1619a aVar, String str) {
        this.f4087d = aVar;
        this.f4086c = str;
    }

    /* renamed from: com.flurry.sdk.cc$a */
    public enum C1619a {
        SUCCEED(1),
        NO_CHANGE(0),
        IO(-1),
        NOT_VALID_JSON(-2),
        AUTHENTICATE(-3),
        UNKNOWN_CERTIFICATE(-4),
        OTHER(-5);
        

        /* renamed from: h */
        int f4096h;

        private C1619a(int i) {
            this.f4096h = i;
        }
    }

    public final String toString() {
        return "[Error:" + this.f4087d.name() + "] " + this.f4086c;
    }
}
