package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1081a;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.x */
public abstract class C1040x extends C0989a {
    protected C1040x(String str, C1062k kVar) {
        super(str, kVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract String mo8541a();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8542a(int i) {
        C1120h.m2540a(i, this.f1980b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo8543a(JSONObject jSONObject);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo9293a(JSONObject jSONObject, final C1081a.C1084c<JSONObject> cVar) {
        C10411 r0 = new C1033t<JSONObject>(C1085b.m2299a(this.f1980b).mo9481a(C1120h.m2537a(mo8541a(), this.f1980b)).mo9491c(C1120h.m2547b(mo8541a(), this.f1980b)).mo9482a(C1120h.m2550e(this.f1980b)).mo9487b("POST").mo9483a(jSONObject).mo9493d(((Boolean) this.f1980b.mo9350a(C0965b.f1829ev)).booleanValue()).mo9480a(new JSONObject()).mo9479a(mo9220h()).mo9485a(), this.f1980b) {
            /* renamed from: a */
            public void mo8530a(int i) {
                cVar.mo8530a(i);
            }

            /* renamed from: a */
            public void mo8531a(JSONObject jSONObject, int i) {
                cVar.mo8531a(jSONObject, i);
            }
        };
        r0.mo9285a(C0965b.f1590aO);
        r0.mo9287b(C0965b.f1591aP);
        this.f1980b.mo9340Q().mo9265a((C0989a) r0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public abstract int mo9220h();

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public JSONObject mo9294i() {
        JSONObject jSONObject = new JSONObject();
        String m = this.f1980b.mo9397m();
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1773do)).booleanValue() && C1155o.m2673b(m)) {
            C1123j.m2584a(jSONObject, "cuid", m, this.f1980b);
        }
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1775dq)).booleanValue()) {
            C1123j.m2584a(jSONObject, "compass_random_token", this.f1980b.mo9398n(), this.f1980b);
        }
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1777ds)).booleanValue()) {
            C1123j.m2584a(jSONObject, "applovin_random_token", this.f1980b.mo9399o(), this.f1980b);
        }
        mo8543a(jSONObject);
        return jSONObject;
    }
}
