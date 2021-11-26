package com.applovin.impl.sdk;

import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.mediation.p021a.C0737e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.s */
public class C1109s {

    /* renamed from: a */
    private final C1062k f2377a;

    /* renamed from: b */
    private final C1107r f2378b;

    /* renamed from: c */
    private final Map<String, C0733a> f2379c = new HashMap(4);

    /* renamed from: d */
    private final Object f2380d = new Object();

    C1109s(C1062k kVar) {
        this.f2377a = kVar;
        this.f2378b = kVar.mo9411z();
    }

    /* renamed from: a */
    public String mo9589a(String str) {
        String J;
        synchronized (this.f2380d) {
            C0733a aVar = this.f2379c.get(str);
            J = aVar != null ? aVar.mo8443J() : null;
        }
        return J;
    }

    /* renamed from: a */
    public void mo9590a(C0733a aVar) {
        synchronized (this.f2380d) {
            C1107r rVar = this.f2378b;
            rVar.mo9584b("MediationWaterfallWinnerTracker", "Tracking winning ad: " + aVar);
            this.f2379c.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* renamed from: b */
    public void mo9591b(C0733a aVar) {
        synchronized (this.f2380d) {
            String adUnitId = aVar.getAdUnitId();
            C0737e eVar = this.f2379c.get(adUnitId);
            if (aVar == eVar) {
                C1107r rVar = this.f2378b;
                rVar.mo9584b("MediationWaterfallWinnerTracker", "Clearing previous winning ad: " + eVar);
                this.f2379c.remove(adUnitId);
            } else {
                C1107r rVar2 = this.f2378b;
                rVar2.mo9584b("MediationWaterfallWinnerTracker", "Previous winner not cleared for ad: " + aVar + " , since it could have already been updated with a new ad: " + eVar);
            }
        }
    }
}
