package com.flurry.sdk;

import com.flurry.sdk.C1736fc;

/* renamed from: com.flurry.sdk.hx */
final class C1845hx implements C1914o<C1483ad> {
    C1845hx() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        C1483ad adVar = (C1483ad) obj;
        if (adVar == null) {
            C1648cy.m4317a(2, "SessionInfoFrame", "Session info data is null, do not send the frame.");
        } else {
            C1564bl.m4094a();
            int i = C1736fc.C1737a.AGENT_REPORT_TYPE_MAIN_DEVICE.f4354d;
            C1503am amVar = adVar.f3733d;
            if (amVar != null && amVar.f3780a) {
                i = C1736fc.C1737a.AGENT_REPORT_TYPE_INSTANT_APP.f4354d;
            }
            C1735fb.m4502a().mo11504a(new C1886ji(new C1887jj(adVar.f3730a, i, adVar.f3731b, adVar.f3732c)));
        }
        C1648cy.m4317a(4, "SessionInfoObserver", "SessionInfoData".concat(String.valueOf(adVar)));
    }
}
