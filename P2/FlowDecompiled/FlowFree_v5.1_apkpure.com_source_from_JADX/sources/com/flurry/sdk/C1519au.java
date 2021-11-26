package com.flurry.sdk;

/* renamed from: com.flurry.sdk.au */
public final class C1519au {

    /* renamed from: a */
    public final boolean f3825a;

    /* renamed from: b */
    public final C1520a f3826b;

    /* renamed from: c */
    public final String f3827c;

    /* renamed from: d */
    public final String f3828d;

    /* renamed from: e */
    public final String f3829e;

    /* renamed from: f */
    public final String f3830f;

    /* renamed from: g */
    public final String f3831g;

    /* renamed from: h */
    public final String f3832h;

    /* renamed from: i */
    public final int f3833i;

    /* renamed from: com.flurry.sdk.au$a */
    public enum C1520a {
        NONE_OR_UNKNOWN(0),
        NETWORK_AVAILABLE(1),
        WIFI(2),
        CELL(3);
        

        /* renamed from: e */
        public int f3839e;

        private C1520a(int i) {
            this.f3839e = i;
        }
    }

    C1519au(C1520a aVar, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f3825a = z;
        this.f3826b = aVar;
        this.f3827c = str;
        this.f3828d = str2;
        this.f3829e = str3;
        this.f3830f = str4;
        this.f3831g = str5;
        this.f3832h = str6;
        this.f3833i = i;
    }
}
