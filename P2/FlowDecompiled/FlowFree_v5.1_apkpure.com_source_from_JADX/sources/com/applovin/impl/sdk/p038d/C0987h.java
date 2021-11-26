package com.applovin.impl.sdk.p038d;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0967d;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.d.h */
public class C0987h {

    /* renamed from: a */
    private final C1062k f1976a;

    /* renamed from: b */
    private final Map<String, Long> f1977b = new HashMap();

    public C0987h(C1062k kVar) {
        if (kVar != null) {
            this.f1976a = kVar;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* renamed from: e */
    private void m1866e() {
        try {
            this.f1976a.mo9357a(C0967d.f1860o, mo9205c().toString());
        } catch (Throwable th) {
            this.f1976a.mo9411z().mo9585b("GlobalStatsManager", "Unable to save stats", th);
        }
    }

    /* renamed from: a */
    public long mo9199a(C0986g gVar) {
        return mo9200a(gVar, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo9200a(C0986g gVar, long j) {
        long longValue;
        synchronized (this.f1977b) {
            Long l = this.f1977b.get(gVar.mo9198a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue() + j;
            this.f1977b.put(gVar.mo9198a(), Long.valueOf(longValue));
        }
        m1866e();
        return longValue;
    }

    /* renamed from: a */
    public void mo9201a() {
        synchronized (this.f1977b) {
            this.f1977b.clear();
        }
        m1866e();
    }

    /* renamed from: b */
    public long mo9202b(C0986g gVar) {
        long longValue;
        synchronized (this.f1977b) {
            Long l = this.f1977b.get(gVar.mo9198a());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* renamed from: b */
    public void mo9203b() {
        synchronized (this.f1977b) {
            for (C0986g a : C0986g.m1864b()) {
                this.f1977b.remove(a.mo9198a());
            }
            m1866e();
        }
    }

    /* renamed from: b */
    public void mo9204b(C0986g gVar, long j) {
        synchronized (this.f1977b) {
            this.f1977b.put(gVar.mo9198a(), Long.valueOf(j));
        }
        m1866e();
    }

    /* renamed from: c */
    public JSONObject mo9205c() throws JSONException {
        JSONObject jSONObject;
        synchronized (this.f1977b) {
            jSONObject = new JSONObject();
            for (Map.Entry next : this.f1977b.entrySet()) {
                jSONObject.put((String) next.getKey(), next.getValue());
            }
        }
        return jSONObject;
    }

    /* renamed from: c */
    public void mo9206c(C0986g gVar) {
        synchronized (this.f1977b) {
            this.f1977b.remove(gVar.mo9198a());
        }
        m1866e();
    }

    /* renamed from: d */
    public void mo9207d() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.f1976a.mo9379b(C0967d.f1860o, "{}"));
            synchronized (this.f1977b) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.f1977b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f1976a.mo9411z().mo9585b("GlobalStatsManager", "Unable to load stats", th);
        }
    }
}
