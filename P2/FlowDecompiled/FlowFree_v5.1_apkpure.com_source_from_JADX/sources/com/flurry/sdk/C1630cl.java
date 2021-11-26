package com.flurry.sdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/* renamed from: com.flurry.sdk.cl */
public final class C1630cl {
    /* renamed from: a */
    public static void m4270a(C1629ck ckVar) {
        if (ckVar.mo11407e() != 0) {
            ArrayList<C1628cj> arrayList = new ArrayList<>(ckVar.mo11403b());
            Collections.sort(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (C1628cj cjVar : arrayList) {
                arrayList2.add(Integer.toString(cjVar.f4117b));
            }
        }
    }

    /* renamed from: a */
    public static void m4269a(int i, long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("exp_code", String.valueOf(i));
        hashMap.put("exp_ms", String.valueOf(j));
        if (str != null) {
            hashMap.put("exp_det", str);
        }
        if (C1648cy.m4327c() <= 2) {
            C1648cy.m4317a(2, "AnalyticsImpl", String.format("YWA event: %1$s {%2$s}", new Object[]{"expsdk_data", hashMap.toString()}));
        }
    }
}
