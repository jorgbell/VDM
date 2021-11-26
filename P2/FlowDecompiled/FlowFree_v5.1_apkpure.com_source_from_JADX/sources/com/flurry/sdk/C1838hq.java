package com.flurry.sdk;

/* renamed from: com.flurry.sdk.hq */
final class C1838hq implements C1914o<C1511aq> {
    C1838hq() {
    }

    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        C1511aq aqVar = (C1511aq) obj;
        String str = aqVar.f3807a;
        String str2 = aqVar.f3808b;
        if ((str == null || str.isEmpty()) && (str2 == null || str2.isEmpty())) {
            C1648cy.m4317a(2, "LocaleFrame", "Locale is empty, do not send the frame.");
        } else {
            C1735fb.m4502a().mo11504a(new C1810gs(new C1811gt(str, str2)));
        }
        C1648cy.m4317a(4, "LocaleObserver", "Locale language: " + aqVar.f3807a + ". Locale country: " + aqVar.f3808b);
    }
}
