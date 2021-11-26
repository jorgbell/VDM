package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0965b;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.b */
public class C1085b<T> {

    /* renamed from: a */
    private String f2279a;

    /* renamed from: b */
    private String f2280b;

    /* renamed from: c */
    private Map<String, String> f2281c;

    /* renamed from: d */
    private Map<String, String> f2282d;

    /* renamed from: e */
    private final JSONObject f2283e;

    /* renamed from: f */
    private String f2284f;

    /* renamed from: g */
    private final T f2285g;

    /* renamed from: h */
    private final int f2286h;

    /* renamed from: i */
    private int f2287i;

    /* renamed from: j */
    private final int f2288j;

    /* renamed from: k */
    private final int f2289k;

    /* renamed from: l */
    private final boolean f2290l;

    /* renamed from: m */
    private final boolean f2291m;

    /* renamed from: n */
    private final boolean f2292n;

    /* renamed from: o */
    private final boolean f2293o;

    /* renamed from: p */
    private final boolean f2294p;

    /* renamed from: com.applovin.impl.sdk.network.b$a */
    public static class C1086a<T> {

        /* renamed from: a */
        String f2295a;

        /* renamed from: b */
        String f2296b;

        /* renamed from: c */
        String f2297c;

        /* renamed from: d */
        Map<String, String> f2298d;

        /* renamed from: e */
        Map<String, String> f2299e;

        /* renamed from: f */
        JSONObject f2300f;

        /* renamed from: g */
        T f2301g;

        /* renamed from: h */
        int f2302h = 1;

        /* renamed from: i */
        int f2303i;

        /* renamed from: j */
        int f2304j;

        /* renamed from: k */
        boolean f2305k;

        /* renamed from: l */
        boolean f2306l;

        /* renamed from: m */
        boolean f2307m;

        /* renamed from: n */
        boolean f2308n;

        /* renamed from: o */
        boolean f2309o;

        public C1086a(C1062k kVar) {
            this.f2303i = ((Integer) kVar.mo9350a(C0965b.f1696cP)).intValue();
            this.f2304j = ((Integer) kVar.mo9350a(C0965b.f1695cO)).intValue();
            this.f2306l = ((Boolean) kVar.mo9350a(C0965b.f1694cN)).booleanValue();
            this.f2307m = ((Boolean) kVar.mo9350a(C0965b.f1818ek)).booleanValue();
            this.f2308n = ((Boolean) kVar.mo9350a(C0965b.f1823ep)).booleanValue();
            this.f2298d = new HashMap();
        }

        /* renamed from: a */
        public C1086a<T> mo9479a(int i) {
            this.f2302h = i;
            return this;
        }

        /* renamed from: a */
        public C1086a<T> mo9480a(T t) {
            this.f2301g = t;
            return this;
        }

        /* renamed from: a */
        public C1086a<T> mo9481a(String str) {
            this.f2296b = str;
            return this;
        }

        /* renamed from: a */
        public C1086a<T> mo9482a(Map<String, String> map) {
            this.f2298d = map;
            return this;
        }

        /* renamed from: a */
        public C1086a<T> mo9483a(JSONObject jSONObject) {
            this.f2300f = jSONObject;
            return this;
        }

        /* renamed from: a */
        public C1086a<T> mo9484a(boolean z) {
            this.f2305k = z;
            return this;
        }

        /* renamed from: a */
        public C1085b<T> mo9485a() {
            return new C1085b<>(this);
        }

        /* renamed from: b */
        public C1086a<T> mo9486b(int i) {
            this.f2303i = i;
            return this;
        }

        /* renamed from: b */
        public C1086a<T> mo9487b(String str) {
            this.f2295a = str;
            return this;
        }

        /* renamed from: b */
        public C1086a<T> mo9488b(Map<String, String> map) {
            this.f2299e = map;
            return this;
        }

        /* renamed from: b */
        public C1086a<T> mo9489b(boolean z) {
            this.f2306l = z;
            return this;
        }

        /* renamed from: c */
        public C1086a<T> mo9490c(int i) {
            this.f2304j = i;
            return this;
        }

        /* renamed from: c */
        public C1086a<T> mo9491c(String str) {
            this.f2297c = str;
            return this;
        }

        /* renamed from: c */
        public C1086a<T> mo9492c(boolean z) {
            this.f2307m = z;
            return this;
        }

        /* renamed from: d */
        public C1086a<T> mo9493d(boolean z) {
            this.f2308n = z;
            return this;
        }

        /* renamed from: e */
        public C1086a<T> mo9494e(boolean z) {
            this.f2309o = z;
            return this;
        }
    }

    protected C1085b(C1086a<T> aVar) {
        this.f2279a = aVar.f2296b;
        this.f2280b = aVar.f2295a;
        this.f2281c = aVar.f2298d;
        this.f2282d = aVar.f2299e;
        this.f2283e = aVar.f2300f;
        this.f2284f = aVar.f2297c;
        this.f2285g = aVar.f2301g;
        int i = aVar.f2302h;
        this.f2286h = i;
        this.f2287i = i;
        this.f2288j = aVar.f2303i;
        this.f2289k = aVar.f2304j;
        this.f2290l = aVar.f2305k;
        this.f2291m = aVar.f2306l;
        this.f2292n = aVar.f2307m;
        this.f2293o = aVar.f2308n;
        this.f2294p = aVar.f2309o;
    }

    /* renamed from: a */
    public static <T> C1086a<T> m2299a(C1062k kVar) {
        return new C1086a<>(kVar);
    }

    /* renamed from: a */
    public String mo9457a() {
        return this.f2279a;
    }

    /* renamed from: a */
    public void mo9458a(int i) {
        this.f2287i = i;
    }

    /* renamed from: a */
    public void mo9459a(String str) {
        this.f2279a = str;
    }

    /* renamed from: b */
    public String mo9460b() {
        return this.f2280b;
    }

    /* renamed from: b */
    public void mo9461b(String str) {
        this.f2280b = str;
    }

    /* renamed from: c */
    public Map<String, String> mo9462c() {
        return this.f2281c;
    }

    /* renamed from: d */
    public Map<String, String> mo9463d() {
        return this.f2282d;
    }

    /* renamed from: e */
    public JSONObject mo9464e() {
        return this.f2283e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1085b)) {
            return false;
        }
        C1085b bVar = (C1085b) obj;
        String str = this.f2279a;
        if (str == null ? bVar.f2279a != null : !str.equals(bVar.f2279a)) {
            return false;
        }
        Map<String, String> map = this.f2281c;
        if (map == null ? bVar.f2281c != null : !map.equals(bVar.f2281c)) {
            return false;
        }
        Map<String, String> map2 = this.f2282d;
        if (map2 == null ? bVar.f2282d != null : !map2.equals(bVar.f2282d)) {
            return false;
        }
        String str2 = this.f2284f;
        if (str2 == null ? bVar.f2284f != null : !str2.equals(bVar.f2284f)) {
            return false;
        }
        String str3 = this.f2280b;
        if (str3 == null ? bVar.f2280b != null : !str3.equals(bVar.f2280b)) {
            return false;
        }
        JSONObject jSONObject = this.f2283e;
        if (jSONObject == null ? bVar.f2283e != null : !jSONObject.equals(bVar.f2283e)) {
            return false;
        }
        T t = this.f2285g;
        if (t == null ? bVar.f2285g == null : t.equals(bVar.f2285g)) {
            return this.f2286h == bVar.f2286h && this.f2287i == bVar.f2287i && this.f2288j == bVar.f2288j && this.f2289k == bVar.f2289k && this.f2290l == bVar.f2290l && this.f2291m == bVar.f2291m && this.f2292n == bVar.f2292n && this.f2293o == bVar.f2293o && this.f2294p == bVar.f2294p;
        }
        return false;
    }

    /* renamed from: f */
    public String mo9466f() {
        return this.f2284f;
    }

    /* renamed from: g */
    public T mo9467g() {
        return this.f2285g;
    }

    /* renamed from: h */
    public int mo9468h() {
        return this.f2287i;
    }

    public int hashCode() {
        int hashCode = super.hashCode() * 31;
        String str = this.f2279a;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.f2284f;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.f2280b;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        T t = this.f2285g;
        if (t != null) {
            i = t.hashCode();
        }
        int i2 = ((((((((((((((((((hashCode4 + i) * 31) + this.f2286h) * 31) + this.f2287i) * 31) + this.f2288j) * 31) + this.f2289k) * 31) + (this.f2290l ? 1 : 0)) * 31) + (this.f2291m ? 1 : 0)) * 31) + (this.f2292n ? 1 : 0)) * 31) + (this.f2293o ? 1 : 0)) * 31) + (this.f2294p ? 1 : 0);
        Map<String, String> map = this.f2281c;
        if (map != null) {
            i2 = (i2 * 31) + map.hashCode();
        }
        Map<String, String> map2 = this.f2282d;
        if (map2 != null) {
            i2 = (i2 * 31) + map2.hashCode();
        }
        JSONObject jSONObject = this.f2283e;
        if (jSONObject == null) {
            return i2;
        }
        char[] charArray = jSONObject.toString().toCharArray();
        Arrays.sort(charArray);
        return (i2 * 31) + new String(charArray).hashCode();
    }

    /* renamed from: i */
    public int mo9470i() {
        return this.f2286h - this.f2287i;
    }

    /* renamed from: j */
    public int mo9471j() {
        return this.f2288j;
    }

    /* renamed from: k */
    public int mo9472k() {
        return this.f2289k;
    }

    /* renamed from: l */
    public boolean mo9473l() {
        return this.f2290l;
    }

    /* renamed from: m */
    public boolean mo9474m() {
        return this.f2291m;
    }

    /* renamed from: n */
    public boolean mo9475n() {
        return this.f2292n;
    }

    /* renamed from: o */
    public boolean mo9476o() {
        return this.f2293o;
    }

    /* renamed from: p */
    public boolean mo9477p() {
        return this.f2294p;
    }

    public String toString() {
        return "HttpRequest {endpoint=" + this.f2279a + ", backupEndpoint=" + this.f2284f + ", httpMethod=" + this.f2280b + ", httpHeaders=" + this.f2282d + ", body=" + this.f2283e + ", emptyResponse=" + this.f2285g + ", initialRetryAttempts=" + this.f2286h + ", retryAttemptsLeft=" + this.f2287i + ", timeoutMillis=" + this.f2288j + ", retryDelayMillis=" + this.f2289k + ", exponentialRetries=" + this.f2290l + ", retryOnAllErrors=" + this.f2291m + ", encodingEnabled=" + this.f2292n + ", gzipBodyEncoding=" + this.f2293o + ", trackConnectionSpeed=" + this.f2294p + '}';
    }
}
