package com.applovin.impl.sdk.p038d;

import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.p039e.C0989a;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.p039e.C1033t;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.c */
public class C0975c {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1062k f1921a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1107r f1922b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Object f1923c = new Object();
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final C0980c f1924d = new C0980c();

    /* renamed from: com.applovin.impl.sdk.d.c$a */
    private static class C0978a {

        /* renamed from: a */
        private final C1062k f1927a;

        /* renamed from: b */
        private final JSONObject f1928b;

        private C0978a(String str, String str2, String str3, C1062k kVar) {
            JSONObject jSONObject = new JSONObject();
            this.f1928b = jSONObject;
            this.f1927a = kVar;
            C1123j.m2584a(jSONObject, "pk", str, kVar);
            C1123j.m2601b(jSONObject, "ts", System.currentTimeMillis(), kVar);
            if (C1155o.m2673b(str2)) {
                C1123j.m2584a(jSONObject, "sk1", str2, kVar);
            }
            if (C1155o.m2673b(str3)) {
                C1123j.m2584a(jSONObject, "sk2", str3, kVar);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: a */
        public String m1821a() throws OutOfMemoryError {
            return this.f1928b.toString();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9162a(String str, long j) {
            mo9164b(str, C1123j.m2566a(this.f1928b, str, 0, this.f1927a) + j);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo9163a(String str, String str2) {
            JSONArray b = C1123j.m2599b(this.f1928b, str, new JSONArray(), this.f1927a);
            b.put(str2);
            C1123j.m2585a(this.f1928b, str, b, this.f1927a);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public void mo9164b(String str, long j) {
            C1123j.m2601b(this.f1928b, str, j, this.f1927a);
        }

        public String toString() {
            return "AdEventStats{stats='" + this.f1928b + '\'' + '}';
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.c$b */
    public class C0979b {

        /* renamed from: b */
        private final AppLovinAdBase f1930b;

        /* renamed from: c */
        private final C0975c f1931c;

        public C0979b(AppLovinAdBase appLovinAdBase, C0975c cVar) {
            this.f1930b = appLovinAdBase;
            this.f1931c = cVar;
        }

        /* renamed from: a */
        public C0979b mo9166a(C0974b bVar) {
            this.f1931c.m1801a(bVar, 1, this.f1930b);
            return this;
        }

        /* renamed from: a */
        public C0979b mo9167a(C0974b bVar, long j) {
            this.f1931c.m1808b(bVar, j, this.f1930b);
            return this;
        }

        /* renamed from: a */
        public C0979b mo9168a(C0974b bVar, String str) {
            this.f1931c.m1802a(bVar, str, this.f1930b);
            return this;
        }

        /* renamed from: a */
        public void mo9169a() {
            this.f1931c.m1814e();
        }
    }

    /* renamed from: com.applovin.impl.sdk.d.c$c */
    private class C0980c extends LinkedHashMap<String, C0978a> {
        private C0980c() {
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<String, C0978a> entry) {
            return size() > ((Integer) C0975c.this.f1921a.mo9350a(C0965b.f1754dV)).intValue();
        }
    }

    public C0975c(C1062k kVar) {
        this.f1921a = kVar;
        this.f1922b = kVar.mo9411z();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1801a(C0974b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase != null && bVar != null && ((Boolean) this.f1921a.mo9350a(C0965b.f1751dS)).booleanValue()) {
            synchronized (this.f1923c) {
                m1806b(appLovinAdBase).mo9162a(((Boolean) this.f1921a.mo9350a(C0965b.f1755dW)).booleanValue() ? bVar.mo9157b() : bVar.mo9156a(), j);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m1802a(C0974b bVar, String str, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase != null && bVar != null && ((Boolean) this.f1921a.mo9350a(C0965b.f1751dS)).booleanValue()) {
            synchronized (this.f1924d) {
                m1806b(appLovinAdBase).mo9163a(((Boolean) this.f1921a.mo9350a(C0965b.f1755dW)).booleanValue() ? bVar.mo9157b() : bVar.mo9156a(), str);
            }
        }
    }

    /* renamed from: a */
    private void m1805a(JSONObject jSONObject) {
        C09761 r0 = new C1033t<Object>(C1085b.m2299a(this.f1921a).mo9481a(m1811c()).mo9491c(m1813d()).mo9482a(C1120h.m2550e(this.f1921a)).mo9487b("POST").mo9483a(jSONObject).mo9493d(((Boolean) this.f1921a.mo9350a(C0965b.f1828eu)).booleanValue()).mo9486b(((Integer) this.f1921a.mo9350a(C0965b.f1752dT)).intValue()).mo9479a(((Integer) this.f1921a.mo9350a(C0965b.f1753dU)).intValue()).mo9485a(), this.f1921a) {
            /* renamed from: a */
            public void mo8530a(int i) {
                C1107r a = C0975c.this.f1922b;
                a.mo9588e("AdEventStatsManager", "Failed to submitted ad stats: " + i);
            }

            /* renamed from: a */
            public void mo8531a(Object obj, int i) {
                C1107r a = C0975c.this.f1922b;
                a.mo9584b("AdEventStatsManager", "Ad stats submitted: " + i);
            }
        };
        r0.mo9285a(C0965b.f1590aO);
        r0.mo9287b(C0965b.f1591aP);
        this.f1921a.mo9340Q().mo9266a((C0989a) r0, C1020o.C1022a.BACKGROUND);
    }

    /* renamed from: b */
    private C0978a m1806b(AppLovinAdBase appLovinAdBase) {
        C0978a aVar;
        synchronized (this.f1923c) {
            String primaryKey = appLovinAdBase.getPrimaryKey();
            aVar = (C0978a) this.f1924d.get(primaryKey);
            if (aVar == null) {
                C0978a aVar2 = new C0978a(primaryKey, appLovinAdBase.getSecondaryKey1(), appLovinAdBase.getSecondaryKey2(), this.f1921a);
                this.f1924d.put(primaryKey, aVar2);
                aVar = aVar2;
            }
        }
        return aVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1808b(C0974b bVar, long j, AppLovinAdBase appLovinAdBase) {
        if (appLovinAdBase != null && bVar != null && ((Boolean) this.f1921a.mo9350a(C0965b.f1751dS)).booleanValue()) {
            synchronized (this.f1923c) {
                m1806b(appLovinAdBase).mo9164b(((Boolean) this.f1921a.mo9350a(C0965b.f1755dW)).booleanValue() ? bVar.mo9157b() : bVar.mo9156a(), j);
            }
        }
    }

    /* renamed from: c */
    private String m1811c() {
        return C1120h.m2537a("2.0/s", this.f1921a);
    }

    /* renamed from: d */
    private String m1813d() {
        return C1120h.m2547b("2.0/s", this.f1921a);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m1814e() {
        if (((Boolean) this.f1921a.mo9350a(C0965b.f1751dS)).booleanValue()) {
            this.f1921a.mo9340Q().mo9270b().execute(new Runnable() {
                public void run() {
                    HashSet hashSet;
                    synchronized (C0975c.this.f1923c) {
                        hashSet = new HashSet(C0975c.this.f1924d.size());
                        for (C0978a aVar : C0975c.this.f1924d.values()) {
                            try {
                                hashSet.add(aVar.m1821a());
                            } catch (OutOfMemoryError e) {
                                C1107r a = C0975c.this.f1922b;
                                a.mo9585b("AdEventStatsManager", "Failed to serialize " + aVar + " due to OOM error", e);
                                C0975c.this.mo9160b();
                            }
                        }
                    }
                    C0975c.this.f1921a.mo9357a(C0967d.f1866u, hashSet);
                }
            });
        }
    }

    /* renamed from: a */
    public C0979b mo9158a(AppLovinAdBase appLovinAdBase) {
        return new C0979b(appLovinAdBase, this);
    }

    /* renamed from: a */
    public void mo9159a() {
        if (((Boolean) this.f1921a.mo9350a(C0965b.f1751dS)).booleanValue()) {
            C1062k kVar = this.f1921a;
            C0967d dVar = C0967d.f1866u;
            Set<String> set = (Set) kVar.mo9379b(dVar, new HashSet(0));
            this.f1921a.mo9383b(dVar);
            if (set == null || set.isEmpty()) {
                this.f1922b.mo9584b("AdEventStatsManager", "No serialized ad events found");
                return;
            }
            C1107r rVar = this.f1922b;
            rVar.mo9584b("AdEventStatsManager", "De-serializing " + set.size() + " stat ad events");
            JSONArray jSONArray = new JSONArray();
            for (String str : set) {
                try {
                    jSONArray.put(new JSONObject(str));
                } catch (JSONException e) {
                    C1107r rVar2 = this.f1922b;
                    rVar2.mo9585b("AdEventStatsManager", "Failed to parse: " + str, e);
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("stats", jSONArray);
                m1805a(jSONObject);
            } catch (JSONException e2) {
                this.f1922b.mo9585b("AdEventStatsManager", "Failed to create stats to submit", e2);
            }
        }
    }

    /* renamed from: b */
    public void mo9160b() {
        synchronized (this.f1923c) {
            this.f1922b.mo9584b("AdEventStatsManager", "Clearing ad stats...");
            this.f1924d.clear();
        }
    }
}
