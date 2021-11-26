package com.flurry.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.cg */
public final class C1623cg {

    /* renamed from: a */
    public static final C1623cg f4101a = new C1623cg("APP");

    /* renamed from: b */
    public static final C1623cg f4102b = new C1623cg("KILLSWITCH");

    /* renamed from: c */
    private static final Map<String, C1623cg> f4103c = new HashMap();

    /* renamed from: d */
    private static final Map<String, C1623cg> f4104d = new HashMap();

    /* renamed from: e */
    private String f4105e;

    private C1623cg(String str) {
        this.f4105e = str;
        f4103c.put(str, this);
    }

    /* renamed from: a */
    public static C1623cg m4237a(String str) {
        Map<String, C1623cg> map = f4103c;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        C1623cg cgVar = new C1623cg(str);
        f4104d.put(str, cgVar);
        return cgVar;
    }

    /* renamed from: a */
    public static Map<String, C1623cg> m4238a() {
        return f4104d;
    }

    /* renamed from: b */
    public static Collection<C1623cg> m4239b() {
        return f4103c.values();
    }

    public final String toString() {
        return this.f4105e;
    }
}
