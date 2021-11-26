package com.flurry.sdk;

/* renamed from: com.flurry.sdk.hw */
public final class C1844hw implements C1914o<C1537ba> {
    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        C1537ba baVar = (C1537ba) obj;
        if (baVar == null) {
            C1648cy.m4317a(2, "ReportingFrame", "Reporting data is null, do not send the frame.");
            return;
        }
        C1735fb.m4502a().mo11504a(new C1816gy(new C1817gz(baVar)));
    }
}
