package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Privacy.model.CCPA;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Privacy.model.GDPR;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.chartboost.sdk.impl.a1 */
public class C1289a1 {

    /* renamed from: a */
    private C1407x0 f3049a;

    public C1289a1(C1407x0 x0Var) {
        this.f3049a = x0Var;
    }

    /* renamed from: b */
    private HashSet<String> m3378b(C1236h.C1238b bVar) {
        if (bVar != null) {
            return bVar.mo10136a();
        }
        return null;
    }

    /* renamed from: a */
    public List<DataUseConsent> mo10377a(C1236h.C1238b bVar) {
        HashMap<String, DataUseConsent> b = this.f3049a.mo10701b();
        List<DataUseConsent> a = m3376a(b);
        ArrayList arrayList = new ArrayList();
        HashSet<String> b2 = m3378b(bVar);
        if (b2 != null) {
            for (DataUseConsent next : a) {
                if (m3377a(b2, next)) {
                    arrayList.add(next);
                }
            }
        } else if (b.containsKey(CCPA.CCPA_STANDARD)) {
            arrayList.add(b.get(CCPA.CCPA_STANDARD));
        }
        return arrayList;
    }

    /* renamed from: a */
    private boolean m3377a(HashSet<String> hashSet, DataUseConsent dataUseConsent) {
        if (hashSet.contains(dataUseConsent.getPrivacyStandard())) {
            return true;
        }
        CBLogging.m2909e("Chartboost", "DataUseConsent " + dataUseConsent.getPrivacyStandard() + " is not whitelisted.");
        return false;
    }

    /* renamed from: a */
    private List<DataUseConsent> m3376a(HashMap<String, DataUseConsent> hashMap) {
        HashMap hashMap2 = new HashMap(hashMap);
        hashMap2.remove(GDPR.GDPR_STANDARD);
        return new ArrayList(hashMap2.values());
    }
}
