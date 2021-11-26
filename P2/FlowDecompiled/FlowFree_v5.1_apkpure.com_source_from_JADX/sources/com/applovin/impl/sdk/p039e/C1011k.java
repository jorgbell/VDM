package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p035a.C0926c;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.e.k */
public class C1011k extends C1009j {

    /* renamed from: a */
    private final C0926c f2017a;

    public C1011k(C0926c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        super(C0928d.m1540a("adtoken_zone", kVar), appLovinAdLoadListener, "TaskFetchTokenAd", kVar);
        this.f2017a = cVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo9251a() {
        HashMap hashMap = new HashMap(2);
        hashMap.put("adtoken", this.f2017a.mo8964a());
        hashMap.put("adtoken_prefix", this.f2017a.mo8966c());
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0925b mo9252b() {
        return C0925b.REGULAR_AD_TOKEN;
    }
}
