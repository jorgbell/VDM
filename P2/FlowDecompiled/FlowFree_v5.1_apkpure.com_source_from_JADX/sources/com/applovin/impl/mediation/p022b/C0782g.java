package com.applovin.impl.mediation.p022b;

import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.p039e.C0990aa;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.g */
public class C0782g extends C0990aa {

    /* renamed from: a */
    private final C0735c f897a;

    public C0782g(C0735c cVar, C1062k kVar) {
        super("TaskValidateMaxReward", kVar);
        this.f897a = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8541a() {
        return "2.0/mvr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8542a(int i) {
        super.mo8542a(i);
        this.f897a.mo8429a(C0962c.m1734a((i < 400 || i >= 500) ? "network_timeout" : "rejected"));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8547a(C0962c cVar) {
        this.f897a.mo8429a(cVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8543a(JSONObject jSONObject) {
        C1123j.m2584a(jSONObject, "ad_unit_id", this.f897a.getAdUnitId(), this.f1980b);
        C1123j.m2584a(jSONObject, "placement", this.f897a.getPlacement(), this.f1980b);
        C1123j.m2584a(jSONObject, "ad_format", this.f897a.getFormat().getLabel(), this.f1980b);
        String x = this.f897a.mo8437x();
        if (!C1155o.m2673b(x)) {
            x = "NO_MCODE";
        }
        C1123j.m2584a(jSONObject, "mcode", x, this.f1980b);
        String w = this.f897a.mo8436w();
        if (!C1155o.m2673b(w)) {
            w = "NO_BCODE";
        }
        C1123j.m2584a(jSONObject, "bcode", w, this.f1980b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo8548b() {
        return this.f897a.mo8438y();
    }
}
