package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.flurry.sdk.hv */
public final class C1843hv implements C1914o<C1534ay> {
    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        C1534ay ayVar = (C1534ay) obj;
        String str = ayVar.f3875a;
        String str2 = ayVar.f3876b;
        Map map = ayVar.f3877c;
        if (map == null) {
            map = new HashMap();
        }
        map.put("fl.origin.attribute.version", str2);
        if (map.size() > 10) {
            int size = map.size();
            C1648cy.m4331d("OriginAttributeFrame", "MaxOriginParams exceeded: ".concat(String.valueOf(size)));
            map.clear();
            map.put("fl.parameter.limit.exceeded", String.valueOf(size));
        }
        C1735fb.m4502a().mo11504a(new C1875iy(new C1876iz(str, map)));
        C1648cy.m4317a(4, "OriginAttributeObserver", "Origin attribute name: " + ayVar.f3875a + ". Origin attribute version: " + ayVar.f3876b + ". Origin attribute params: " + ayVar.f3877c);
    }
}
