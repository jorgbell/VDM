package com.applovin.impl.mediation.p022b;

import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.p039e.C1036v;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.b.f */
public class C0781f extends C1036v {

    /* renamed from: a */
    private final C0735c f896a;

    public C0781f(C0735c cVar, C1062k kVar) {
        super("TaskReportMaxReward", kVar);
        this.f896a = cVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8541a() {
        return "2.0/mcr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8542a(int i) {
        super.mo8542a(i);
        mo9211a("Failed to report reward for mediated ad: " + this.f896a + " - error code: " + i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8543a(JSONObject jSONObject) {
        C1123j.m2584a(jSONObject, "ad_unit_id", this.f896a.getAdUnitId(), this.f1980b);
        C1123j.m2584a(jSONObject, "placement", this.f896a.getPlacement(), this.f1980b);
        String x = this.f896a.mo8437x();
        if (!C1155o.m2673b(x)) {
            x = "NO_MCODE";
        }
        C1123j.m2584a(jSONObject, "mcode", x, this.f1980b);
        String w = this.f896a.mo8436w();
        if (!C1155o.m2673b(w)) {
            w = "NO_BCODE";
        }
        C1123j.m2584a(jSONObject, "bcode", w, this.f1980b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0962c mo8544b() {
        return this.f896a.mo8423A();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8545b(JSONObject jSONObject) {
        mo9211a("Reported reward successfully for mediated ad: " + this.f896a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8546c() {
        mo9216d("No reward result was found for mediated ad: " + this.f896a);
    }
}
