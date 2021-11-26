package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.jm */
public abstract class C1891jm implements C1894jp {

    /* renamed from: o */
    protected int f4648o = 1;

    /* renamed from: a */
    public JSONObject mo11543a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("fl.frame.version", this.f4648o);
        return jSONObject;
    }
}
