package com.applovin.impl.sdk;

import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.utils.C1123j;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.u */
public class C1111u {

    /* renamed from: a */
    private final C1062k f2383a;

    /* renamed from: b */
    private final JSONObject f2384b;

    /* renamed from: c */
    private final Object f2385c = new Object();

    public C1111u(C1062k kVar) {
        this.f2383a = kVar;
        this.f2384b = C1123j.m2579a((String) kVar.mo9379b(C0967d.f1865t, "{}"), new JSONObject(), kVar);
    }

    /* renamed from: a */
    public Integer mo9597a(String str) {
        Integer valueOf;
        synchronized (this.f2385c) {
            if (this.f2384b.has(str)) {
                C1123j.m2582a(this.f2384b, str, C1123j.m2592b(this.f2384b, str, 0, this.f2383a) + 1, this.f2383a);
            } else {
                C1123j.m2582a(this.f2384b, str, 1, this.f2383a);
            }
            this.f2383a.mo9357a(C0967d.f1865t, this.f2384b.toString());
            valueOf = Integer.valueOf(C1123j.m2592b(this.f2384b, str, 0, this.f2383a));
        }
        return valueOf;
    }
}
