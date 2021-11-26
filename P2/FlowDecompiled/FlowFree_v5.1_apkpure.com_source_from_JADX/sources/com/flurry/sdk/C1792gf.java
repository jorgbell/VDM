package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gf */
public final class C1792gf extends C1891jm {

    /* renamed from: a */
    public final Long f4479a;

    public C1792gf(Long l) {
        this.f4479a = l;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        if (this.f4479a.longValue() != Long.MIN_VALUE) {
            a.put("fl.demo.birthdate", this.f4479a);
        }
        return a;
    }
}
