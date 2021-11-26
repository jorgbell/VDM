package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.p037c.C0965b;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.aa */
public abstract class C0990aa extends C1040x {
    protected C0990aa(String str, C1062k kVar) {
        super(str, kVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m1886b(JSONObject jSONObject) {
        C0962c c = m1887c(jSONObject);
        if (c != null) {
            mo8547a(c);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        r3 = java.util.Collections.emptyMap();
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0020 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.impl.sdk.p036b.C0962c m1887c(org.json.JSONObject r3) {
        /*
            r2 = this;
            org.json.JSONObject r0 = com.applovin.impl.sdk.utils.C1120h.m2539a((org.json.JSONObject) r3)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.k r1 = r2.f1980b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.C1120h.m2549d(r0, r1)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.k r1 = r2.f1980b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.C1120h.m2548c(r3, r1)     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.k r1 = r2.f1980b     // Catch:{ JSONException -> 0x0032 }
            com.applovin.impl.sdk.utils.C1120h.m2551e(r3, r1)     // Catch:{ JSONException -> 0x0032 }
            java.lang.String r3 = "params"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0020 }
            org.json.JSONObject r3 = (org.json.JSONObject) r3     // Catch:{ all -> 0x0020 }
            java.util.Map r3 = com.applovin.impl.sdk.utils.C1123j.m2577a((org.json.JSONObject) r3)     // Catch:{ all -> 0x0020 }
            goto L_0x0024
        L_0x0020:
            java.util.Map r3 = java.util.Collections.emptyMap()     // Catch:{ JSONException -> 0x0032 }
        L_0x0024:
            java.lang.String r1 = "result"
            java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x002b }
            goto L_0x002d
        L_0x002b:
            java.lang.String r0 = "network_timeout"
        L_0x002d:
            com.applovin.impl.sdk.b.c r3 = com.applovin.impl.sdk.p036b.C0962c.m1735a(r0, r3)     // Catch:{ JSONException -> 0x0032 }
            return r3
        L_0x0032:
            r3 = move-exception
            java.lang.String r0 = "Unable to parse API response"
            r2.mo9212a(r0, r3)
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.p039e.C0990aa.m1887c(org.json.JSONObject):com.applovin.impl.sdk.b.c");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8547a(C0962c cVar);

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract boolean mo8548b();

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public int mo9220h() {
        return ((Integer) this.f1980b.mo9350a(C0965b.f1666bl)).intValue();
    }

    public void run() {
        mo9293a(mo9294i(), new C1081a.C1084c<JSONObject>() {
            /* renamed from: a */
            public void mo8530a(int i) {
                if (!C0990aa.this.mo8548b()) {
                    C0990aa.this.mo8542a(i);
                }
            }

            /* renamed from: a */
            public void mo8531a(JSONObject jSONObject, int i) {
                if (!C0990aa.this.mo8548b()) {
                    C0990aa.this.m1886b(jSONObject);
                }
            }
        });
    }
}
