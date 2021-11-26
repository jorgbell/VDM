package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.p039e.C1020o;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.e.r */
class C1031r extends C0989a {

    /* renamed from: a */
    private final JSONObject f2092a;

    /* renamed from: c */
    private final JSONObject f2093c;

    /* renamed from: d */
    private final AppLovinAdLoadListener f2094d;

    /* renamed from: e */
    private final C0925b f2095e;

    C1031r(JSONObject jSONObject, JSONObject jSONObject2, C0925b bVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        super("TaskRenderAppLovinAd", kVar);
        this.f2092a = jSONObject;
        this.f2093c = jSONObject2;
        this.f2095e = bVar;
        this.f2094d = appLovinAdLoadListener;
    }

    public void run() {
        mo9211a("Rendering ad...");
        C0924a aVar = new C0924a(this.f2092a, this.f2093c, this.f2095e, this.f1980b);
        boolean booleanValue = C1123j.m2568a(this.f2092a, "gs_load_immediately", Boolean.FALSE, this.f1980b).booleanValue();
        boolean booleanValue2 = C1123j.m2568a(this.f2092a, "vs_load_immediately", Boolean.TRUE, this.f1980b).booleanValue();
        C0997d dVar = new C0997d(aVar, this.f1980b, this.f2094d);
        dVar.mo9240a(booleanValue2);
        dVar.mo9241b(booleanValue);
        C1020o.C1022a aVar2 = C1020o.C1022a.CACHING_OTHER;
        if (((Boolean) this.f1980b.mo9350a(C0965b.f1657bc)).booleanValue()) {
            AppLovinAdSize size = aVar.getSize();
            AppLovinAdSize appLovinAdSize = AppLovinAdSize.INTERSTITIAL;
            if (size == appLovinAdSize && aVar.getType() == AppLovinAdType.REGULAR) {
                aVar2 = C1020o.C1022a.CACHING_INTERSTITIAL;
            } else if (aVar.getSize() == appLovinAdSize && aVar.getType() == AppLovinAdType.INCENTIVIZED) {
                aVar2 = C1020o.C1022a.CACHING_INCENTIVIZED;
            }
        }
        this.f1980b.mo9340Q().mo9266a((C0989a) dVar, aVar2);
    }
}
