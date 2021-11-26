package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.id */
public final class C1854id extends C1891jm {

    /* renamed from: a */
    public final int f4592a;

    public C1854id(int i) {
        this.f4592a = i < 0 ? 0 : i;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.app.orientation", this.f4592a);
        return a;
    }
}
