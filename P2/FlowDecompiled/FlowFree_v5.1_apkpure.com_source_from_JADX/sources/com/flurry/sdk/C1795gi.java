package com.flurry.sdk;

import com.flurry.sdk.C1796gj;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.flurry.sdk.gi */
public final class C1795gi extends C1892jn {
    private C1795gi(C1894jp jpVar) {
        super(jpVar);
    }

    /* renamed from: a */
    public final C1893jo mo11542a() {
        return C1893jo.VARIANT_IDS;
    }

    /* renamed from: a */
    public static void m4646a(List<C1628cj> list) {
        if (list == null || list.size() == 0) {
            C1648cy.m4331d("VariantIdsFrame", "Variant list is empty, do not send the frame.");
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (C1628cj next : list) {
            arrayList.add(new C1796gj.C1797a((long) next.f4117b, next.f4118c));
        }
        C1735fb.m4502a().mo11504a(new C1795gi(new C1796gj(arrayList)));
    }
}
