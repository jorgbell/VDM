package com.flurry.sdk;

import com.flurry.android.Consent;

/* renamed from: com.flurry.sdk.hm */
public final class C1834hm implements C1914o<Consent> {
    /* renamed from: a */
    public final /* synthetic */ void mo11263a(Object obj) {
        Consent consent = (Consent) obj;
        if (consent == null) {
            C1648cy.m4331d("ConsentFrame", "Consent is null, do not send the frame.");
            return;
        }
        C1735fb.m4502a().mo11504a(new C1859ii(new C1860ij(consent.isGdprScope(), consent.getConsentStrings())));
    }
}
