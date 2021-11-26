package com.flurry.sdk;

import com.flurry.android.Consent;
import java.util.Map;

/* renamed from: com.flurry.sdk.ef */
public abstract class C1707ef extends Consent {

    /* renamed from: a */
    private boolean f4301a;

    public C1707ef(boolean z, boolean z2, Map<String, String> map) {
        this.f4301a = z;
        this.isGdprScope = z2;
        this.consentStrings = map;
    }

    public boolean isLICNEnabled() {
        return this.f4301a;
    }

    public boolean equals(Object obj) {
        return super.equals(obj) && this.f4301a == ((C1707ef) obj).isLICNEnabled();
    }

    public int hashCode() {
        return (super.hashCode() * 31) + (this.f4301a ? 1 : 0);
    }
}
