package com.amazon.device.iap.internal.p008b;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.amazon.device.iap.internal.b.h */
/* compiled from: KiwiRequestContext */
public class C0514h {

    /* renamed from: b */
    static final /* synthetic */ boolean f70b = true;

    /* renamed from: a */
    public final Map<String, Object> f71a = new HashMap();

    /* renamed from: a */
    public Object mo7462a(String str) {
        return this.f71a.get(str);
    }

    /* renamed from: a */
    public void mo7464a(String str, Object obj) {
        this.f71a.put(str, obj);
    }

    /* renamed from: a */
    public void mo7463a(Object obj) {
        if (f70b || obj != null) {
            this.f71a.put("RESPONSE", obj);
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public Object mo7461a() {
        return this.f71a.get("RESPONSE");
    }

    /* renamed from: b */
    public void mo7465b() {
        this.f71a.remove("RESPONSE");
    }
}
