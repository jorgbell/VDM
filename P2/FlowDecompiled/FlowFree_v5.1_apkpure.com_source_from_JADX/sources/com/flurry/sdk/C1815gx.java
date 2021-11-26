package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.gx */
public final class C1815gx extends C1891jm {

    /* renamed from: a */
    public final int f4542a;

    public C1815gx(int i) {
        this.f4542a = i;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.error.count", this.f4542a);
        return a;
    }
}
