package com.applovin.impl.sdk.p038d;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.d.a */
public class C0973a {

    /* renamed from: a */
    private final String f1884a;

    /* renamed from: b */
    private final String f1885b;

    /* renamed from: c */
    private final Map<String, String> f1886c;

    /* renamed from: d */
    private final boolean f1887d;

    public C0973a(String str, String str2) {
        this(str, str2, (Map<String, String>) null, false);
    }

    public C0973a(String str, String str2, Map<String, String> map, boolean z) {
        this.f1884a = str;
        this.f1885b = str2;
        this.f1886c = map;
        this.f1887d = z;
    }

    /* renamed from: a */
    public String mo9151a() {
        return this.f1884a;
    }

    /* renamed from: b */
    public String mo9152b() {
        return this.f1885b;
    }

    /* renamed from: c */
    public Map<String, String> mo9153c() {
        return this.f1886c;
    }

    /* renamed from: d */
    public boolean mo9154d() {
        return this.f1887d;
    }

    public String toString() {
        return "AdEventPostback{url='" + this.f1884a + '\'' + ", backupUrl='" + this.f1885b + '\'' + ", headers='" + this.f1886c + '\'' + ", shouldFireInWebView='" + this.f1887d + '\'' + '}';
    }
}
