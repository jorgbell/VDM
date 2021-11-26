package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.in */
public final class C1864in extends C1891jm {

    /* renamed from: a */
    public final boolean f4600a = true;

    /* renamed from: b */
    public final String f4601b;

    public C1864in(String str) {
        this.f4601b = str;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.background.enabled", this.f4600a);
        a.put("fl.sdk.version.code", this.f4601b);
        return a;
    }
}
