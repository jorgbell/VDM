package com.applovin.impl.sdk.p036b;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b.c */
public class C0962c {

    /* renamed from: a */
    private final String f1516a;

    /* renamed from: b */
    private Map<String, String> f1517b;

    private C0962c(String str, Map<String, String> map) {
        this.f1516a = str;
        this.f1517b = map;
    }

    /* renamed from: a */
    public static C0962c m1734a(String str) {
        return m1735a(str, (Map<String, String>) null);
    }

    /* renamed from: a */
    public static C0962c m1735a(String str, Map<String, String> map) {
        return new C0962c(str, map);
    }

    /* renamed from: a */
    public Map<String, String> mo9109a() {
        return this.f1517b;
    }

    /* renamed from: b */
    public String mo9110b() {
        return this.f1516a;
    }
}
