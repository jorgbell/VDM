package com.applovin.impl.sdk.p039e;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0925b;
import com.applovin.impl.sdk.p035a.C0928d;
import com.applovin.impl.sdk.utils.C1117e;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.e.i */
public class C1008i extends C1009j {

    /* renamed from: a */
    private final List<String> f2012a;

    public C1008i(List<String> list, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        super(C0928d.m1540a(m1951a(list), kVar), appLovinAdLoadListener, "TaskFetchMultizoneAd", kVar);
        this.f2012a = Collections.unmodifiableList(list);
    }

    /* renamed from: a */
    private static String m1951a(List<String> list) {
        if (list != null && !list.isEmpty()) {
            return list.get(0);
        }
        throw new IllegalArgumentException("No zone identifiers specified");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map<String, String> mo9251a() {
        HashMap hashMap = new HashMap(1);
        List<String> list = this.f2012a;
        hashMap.put("zone_ids", C1117e.m2517a((Collection<String>) list, list.size()));
        return hashMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0925b mo9252b() {
        return C0925b.APPLOVIN_MULTIZONE;
    }
}
