package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import android.text.TextUtils;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p037c.C0968e;

/* renamed from: com.applovin.impl.sdk.utils.q */
public final class C1159q {

    /* renamed from: a */
    private final C1062k f2491a;

    /* renamed from: b */
    private String f2492b;

    /* renamed from: c */
    private final String f2493c;

    /* renamed from: d */
    private final String f2494d;

    public C1159q(C1062k kVar) {
        this.f2491a = kVar;
        this.f2493c = m2692a(C0967d.f1852g, (String) C0968e.m1771b(C0967d.f1851f, null, kVar.mo9334J()));
        this.f2494d = m2692a(C0967d.f1853h, (String) kVar.mo9350a(C0965b.f1569U));
        mo9667a(m2694d());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.applovin.impl.sdk.c.d, com.applovin.impl.sdk.c.d<java.lang.String>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String m2692a(com.applovin.impl.sdk.p037c.C0967d<java.lang.String> r3, java.lang.String r4) {
        /*
            r2 = this;
            com.applovin.impl.sdk.k r0 = r2.f2491a
            android.content.Context r0 = r0.mo9334J()
            r1 = 0
            java.lang.Object r0 = com.applovin.impl.sdk.p037c.C0968e.m1771b(r3, r1, (android.content.Context) r0)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.applovin.impl.sdk.utils.C1155o.m2673b(r0)
            if (r1 == 0) goto L_0x0014
            return r0
        L_0x0014:
            boolean r0 = com.applovin.impl.sdk.utils.C1155o.m2673b(r4)
            if (r0 == 0) goto L_0x001b
            goto L_0x0029
        L_0x001b:
            java.util.UUID r4 = java.util.UUID.randomUUID()
            java.lang.String r4 = r4.toString()
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r4 = r4.toLowerCase(r0)
        L_0x0029:
            com.applovin.impl.sdk.k r0 = r2.f2491a
            android.content.Context r0 = r0.mo9334J()
            com.applovin.impl.sdk.p037c.C0968e.m1769a(r3, r4, (android.content.Context) r0)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.C1159q.m2692a(com.applovin.impl.sdk.c.d, java.lang.String):java.lang.String");
    }

    /* renamed from: a */
    public static String m2693a(C1062k kVar) {
        C0967d dVar = C0967d.f1854i;
        String str = (String) kVar.mo9351a(dVar);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String valueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        kVar.mo9357a(dVar, valueOf);
        return valueOf;
    }

    /* renamed from: d */
    private String m2694d() {
        if (!((Boolean) this.f2491a.mo9350a(C0965b.f1778dt)).booleanValue()) {
            this.f2491a.mo9383b(C0967d.f1850e);
        }
        String str = (String) this.f2491a.mo9351a(C0967d.f1850e);
        if (!C1155o.m2673b(str)) {
            return null;
        }
        C1107r z = this.f2491a.mo9411z();
        z.mo9584b("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        return str;
    }

    /* renamed from: a */
    public String mo9666a() {
        return this.f2492b;
    }

    /* renamed from: a */
    public void mo9667a(String str) {
        if (((Boolean) this.f2491a.mo9350a(C0965b.f1778dt)).booleanValue()) {
            this.f2491a.mo9357a(C0967d.f1850e, str);
        }
        this.f2492b = str;
        Bundle bundle = new Bundle();
        bundle.putString("user_id", C1155o.m2675c(str));
        bundle.putString("applovin_random_token", mo9669c());
        this.f2491a.mo9372ag().mo9302a(bundle, "user_info");
    }

    /* renamed from: b */
    public String mo9668b() {
        return this.f2493c;
    }

    /* renamed from: c */
    public String mo9669c() {
        return this.f2494d;
    }
}
