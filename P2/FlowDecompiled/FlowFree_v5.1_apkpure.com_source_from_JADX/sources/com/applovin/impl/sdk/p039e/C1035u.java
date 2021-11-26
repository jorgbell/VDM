package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p036b.C0962c;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.u */
public class C1035u extends C1036v {

    /* renamed from: a */
    private final C0934g f2106a;

    public C1035u(C0934g gVar, C1062k kVar) {
        super("TaskReportAppLovinReward", kVar);
        this.f2106a = gVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo8541a() {
        return "2.0/cr";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8542a(int i) {
        super.mo8542a(i);
        mo9216d("Failed to report reward for ad: " + this.f2106a + " - error code: " + i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo8543a(JSONObject jSONObject) {
        C1123j.m2584a(jSONObject, "zone_id", this.f2106a.getAdZone().mo8972a(), this.f1980b);
        C1123j.m2582a(jSONObject, "fire_percent", this.f2106a.mo9035ac(), this.f1980b);
        String clCode = this.f2106a.getClCode();
        if (!C1155o.m2673b(clCode)) {
            clCode = "NO_CLCODE";
        }
        C1123j.m2584a(jSONObject, "clcode", clCode, this.f1980b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0962c mo8544b() {
        return this.f2106a.mo9029aH();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo8545b(JSONObject jSONObject) {
        mo9211a("Reported reward successfully for ad: " + this.f2106a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo8546c() {
        mo9216d("No reward result was found for ad: " + this.f2106a);
    }
}
