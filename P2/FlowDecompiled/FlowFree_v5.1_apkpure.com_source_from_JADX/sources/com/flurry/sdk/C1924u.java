package com.flurry.sdk;

import com.flurry.android.Consent;

/* renamed from: com.flurry.sdk.u */
public final class C1924u extends C1907m<Consent> {

    /* renamed from: a */
    public Consent f4758a = null;

    public C1924u() {
        super("ConsentProvider");
    }

    /* renamed from: a */
    public final void mo11575a(Consent consent) {
        this.f4758a = consent;
        notifyObservers(consent);
    }
}
