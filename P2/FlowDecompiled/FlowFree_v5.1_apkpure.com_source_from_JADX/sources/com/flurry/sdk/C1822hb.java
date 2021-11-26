package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.hb */
public final class C1822hb extends C1891jm {

    /* renamed from: a */
    public final String f4557a;

    /* renamed from: b */
    public final String f4558b;

    public C1822hb(String str, String str2) {
        this.f4557a = str == null ? "" : str;
        this.f4558b = str2 == null ? "" : str2;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.session.deeplink", this.f4558b);
        a.put("fl.session.origin.name", this.f4557a);
        return a;
    }
}
