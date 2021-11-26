package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p037c.C0968e;

/* renamed from: com.applovin.impl.sdk.h */
public class C1048h {

    /* renamed from: a */
    private static final C1049a f2129a = new C1049a("Age Restricted User", C0967d.f1857l);

    /* renamed from: b */
    private static final C1049a f2130b = new C1049a("Has User Consent", C0967d.f1856k);

    /* renamed from: c */
    private static final C1049a f2131c = new C1049a("\"Do Not Sell\"", C0967d.f1858m);

    /* renamed from: com.applovin.impl.sdk.h$a */
    public static class C1049a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final String f2132a;

        /* renamed from: b */
        private final C0967d<Boolean> f2133b;

        C1049a(String str, C0967d<Boolean> dVar) {
            this.f2132a = str;
            this.f2133b = dVar;
        }

        /* renamed from: a */
        public Boolean mo9308a(Context context) {
            return (Boolean) C0968e.m1771b(this.f2133b, null, context);
        }

        /* renamed from: a */
        public String mo9309a() {
            return this.f2132a;
        }

        /* renamed from: b */
        public String mo9310b(Context context) {
            Boolean a = mo9308a(context);
            return a != null ? a.toString() : "No value set";
        }
    }

    /* renamed from: a */
    public static C1049a m2071a() {
        return f2129a;
    }

    /* renamed from: a */
    public static String m2072a(Context context) {
        return m2073a(f2129a, context) + m2073a(f2130b, context) + m2073a(f2131c, context);
    }

    /* renamed from: a */
    private static String m2073a(C1049a aVar, Context context) {
        return "\n" + aVar.f2132a + " - " + aVar.mo9310b(context);
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [com.applovin.impl.sdk.c.d, com.applovin.impl.sdk.c.d<java.lang.Boolean>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m2074a(com.applovin.impl.sdk.p037c.C0967d<java.lang.Boolean> r1, java.lang.Boolean r2, android.content.Context r3) {
        /*
            r0 = 0
            java.lang.Object r0 = com.applovin.impl.sdk.p037c.C0968e.m1771b(r1, r0, (android.content.Context) r3)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            com.applovin.impl.sdk.p037c.C0968e.m1769a(r1, r2, (android.content.Context) r3)
            r1 = 1
            if (r0 == 0) goto L_0x0011
            if (r0 == r2) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r1 = 0
        L_0x0011:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C1048h.m2074a(com.applovin.impl.sdk.c.d, java.lang.Boolean, android.content.Context):boolean");
    }

    /* renamed from: a */
    public static boolean m2075a(boolean z, Context context) {
        return m2074a(C0967d.f1857l, Boolean.valueOf(z), context);
    }

    /* renamed from: b */
    public static C1049a m2076b() {
        return f2130b;
    }

    /* renamed from: b */
    public static boolean m2077b(boolean z, Context context) {
        return m2074a(C0967d.f1856k, Boolean.valueOf(z), context);
    }

    /* renamed from: c */
    public static C1049a m2078c() {
        return f2131c;
    }

    /* renamed from: c */
    public static boolean m2079c(boolean z, Context context) {
        return m2074a(C0967d.f1858m, Boolean.valueOf(z), context);
    }
}
