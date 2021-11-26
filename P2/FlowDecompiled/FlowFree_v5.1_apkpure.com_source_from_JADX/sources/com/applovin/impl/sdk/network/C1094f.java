package com.applovin.impl.sdk.network;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.network.f */
public class C1094f {

    /* renamed from: a */
    private String f2326a;

    /* renamed from: b */
    private String f2327b;

    /* renamed from: c */
    private String f2328c;

    /* renamed from: d */
    private String f2329d;

    /* renamed from: e */
    private Map<String, String> f2330e;

    /* renamed from: f */
    private Map<String, String> f2331f;

    /* renamed from: g */
    private Map<String, Object> f2332g;

    /* renamed from: h */
    private boolean f2333h;

    /* renamed from: i */
    private boolean f2334i;

    /* renamed from: j */
    private boolean f2335j;

    /* renamed from: k */
    private String f2336k;

    /* renamed from: l */
    private int f2337l;

    /* renamed from: com.applovin.impl.sdk.network.f$a */
    public static class C1096a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public String f2338a;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public String f2339b;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public String f2340c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public String f2341d;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public Map<String, String> f2342e;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public Map<String, String> f2343f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public Map<String, Object> f2344g;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public boolean f2345h;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public boolean f2346i;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public boolean f2347j;

        /* renamed from: a */
        public C1096a mo9521a(String str) {
            this.f2338a = str;
            return this;
        }

        /* renamed from: a */
        public C1096a mo9522a(Map<String, String> map) {
            this.f2342e = map;
            return this;
        }

        /* renamed from: a */
        public C1096a mo9523a(boolean z) {
            this.f2345h = z;
            return this;
        }

        /* renamed from: a */
        public C1094f mo9524a() {
            return new C1094f(this);
        }

        /* renamed from: b */
        public C1096a mo9525b(String str) {
            this.f2339b = str;
            return this;
        }

        /* renamed from: b */
        public C1096a mo9526b(Map<String, String> map) {
            this.f2343f = map;
            return this;
        }

        /* renamed from: b */
        public C1096a mo9527b(boolean z) {
            this.f2346i = z;
            return this;
        }

        /* renamed from: c */
        public C1096a mo9528c(String str) {
            this.f2340c = str;
            return this;
        }

        /* renamed from: c */
        public C1096a mo9529c(Map<String, Object> map) {
            this.f2344g = map;
            return this;
        }

        /* renamed from: c */
        public C1096a mo9530c(boolean z) {
            this.f2347j = z;
            return this;
        }

        /* renamed from: d */
        public C1096a mo9531d(String str) {
            this.f2341d = str;
            return this;
        }
    }

    private C1094f(C1096a aVar) {
        this.f2326a = UUID.randomUUID().toString();
        this.f2327b = aVar.f2339b;
        this.f2328c = aVar.f2340c;
        this.f2329d = aVar.f2341d;
        this.f2330e = aVar.f2342e;
        this.f2331f = aVar.f2343f;
        this.f2332g = aVar.f2344g;
        this.f2333h = aVar.f2345h;
        this.f2334i = aVar.f2346i;
        this.f2335j = aVar.f2347j;
        this.f2336k = aVar.f2338a;
        this.f2337l = 0;
    }

    C1094f(JSONObject jSONObject, C1062k kVar) throws Exception {
        String b = C1123j.m2594b(jSONObject, "uniqueId", UUID.randomUUID().toString(), kVar);
        String b2 = C1123j.m2594b(jSONObject, "communicatorRequestId", "", kVar);
        C1123j.m2594b(jSONObject, "httpMethod", "", kVar);
        String string = jSONObject.getString("targetUrl");
        String b3 = C1123j.m2594b(jSONObject, "backupUrl", "", kVar);
        int i = jSONObject.getInt("attemptNumber");
        Map<String, String> synchronizedMap = C1123j.m2591a(jSONObject, "parameters") ? Collections.synchronizedMap(C1123j.m2577a(jSONObject.getJSONObject("parameters"))) : Collections.emptyMap();
        Map<String, String> synchronizedMap2 = C1123j.m2591a(jSONObject, "httpHeaders") ? Collections.synchronizedMap(C1123j.m2577a(jSONObject.getJSONObject("httpHeaders"))) : Collections.emptyMap();
        Map<String, Object> synchronizedMap3 = C1123j.m2591a(jSONObject, "requestBody") ? Collections.synchronizedMap(C1123j.m2597b(jSONObject.getJSONObject("requestBody"))) : Collections.emptyMap();
        this.f2326a = b;
        this.f2336k = b2;
        this.f2328c = string;
        this.f2329d = b3;
        this.f2330e = synchronizedMap;
        this.f2331f = synchronizedMap2;
        this.f2332g = synchronizedMap3;
        this.f2333h = jSONObject.optBoolean("isEncodingEnabled", false);
        this.f2334i = jSONObject.optBoolean("gzipBodyEncoding", false);
        this.f2335j = jSONObject.optBoolean("shouldFireInWebView", false);
        this.f2337l = i;
    }

    /* renamed from: o */
    public static C1096a m2366o() {
        return new C1096a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo9504a() {
        return this.f2327b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo9505b() {
        return this.f2328c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo9506c() {
        return this.f2329d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public Map<String, String> mo9507d() {
        return this.f2330e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public Map<String, String> mo9508e() {
        return this.f2331f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f2326a.equals(((C1094f) obj).f2326a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public Map<String, Object> mo9510f() {
        return this.f2332g;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo9511g() {
        return this.f2333h;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo9512h() {
        return this.f2334i;
    }

    public int hashCode() {
        return this.f2326a.hashCode();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo9514i() {
        return this.f2335j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public String mo9515j() {
        return this.f2336k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public int mo9516k() {
        return this.f2337l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo9517l() {
        this.f2337l++;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo9518m() {
        HashMap hashMap = new HashMap();
        Map<String, String> map = this.f2330e;
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("postback_ts", String.valueOf(System.currentTimeMillis()));
        this.f2330e = hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public JSONObject mo9519n() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uniqueId", this.f2326a);
        jSONObject.put("communicatorRequestId", this.f2336k);
        jSONObject.put("httpMethod", this.f2327b);
        jSONObject.put("targetUrl", this.f2328c);
        jSONObject.put("backupUrl", this.f2329d);
        jSONObject.put("isEncodingEnabled", this.f2333h);
        jSONObject.put("gzipBodyEncoding", this.f2334i);
        jSONObject.put("attemptNumber", this.f2337l);
        if (this.f2330e != null) {
            jSONObject.put("parameters", new JSONObject(this.f2330e));
        }
        if (this.f2331f != null) {
            jSONObject.put("httpHeaders", new JSONObject(this.f2331f));
        }
        if (this.f2332g != null) {
            jSONObject.put("requestBody", new JSONObject(this.f2332g));
        }
        return jSONObject;
    }

    public String toString() {
        return "PostbackRequest{uniqueId='" + this.f2326a + '\'' + ", communicatorRequestId='" + this.f2336k + '\'' + ", httpMethod='" + this.f2327b + '\'' + ", targetUrl='" + this.f2328c + '\'' + ", backupUrl='" + this.f2329d + '\'' + ", attemptNumber=" + this.f2337l + ", isEncodingEnabled=" + this.f2333h + ", isGzipBodyEncoding=" + this.f2334i + '}';
    }
}
