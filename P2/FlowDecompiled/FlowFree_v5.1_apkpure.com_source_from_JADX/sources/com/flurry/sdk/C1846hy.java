package com.flurry.sdk;

/* renamed from: com.flurry.sdk.hy */
public final class C1846hy implements C1914o<C1552bf> {
    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        C1552bf bfVar = (C1552bf) obj;
        C1648cy.m4317a(3, "SessionPropertyObserver", "Log session property frame");
        if (bfVar == null) {
            C1648cy.m4317a(2, "SessionPropertiesFrame", "Session property data is null, do not send the frame.");
            return;
        }
        C1735fb.m4502a().mo11504a(new C1825he(new C1826hf(C1825he.m4683a(bfVar))));
    }
}
