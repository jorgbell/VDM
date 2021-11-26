package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.hd */
public final class C1824hd extends C1891jm {

    /* renamed from: a */
    public final String f4559a;

    /* renamed from: b */
    public final String f4560b;

    public C1824hd(String str, String str2) {
        this.f4559a = str == null ? "" : str;
        this.f4560b = str2 == null ? "" : str2;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.session.property.param.name", this.f4559a);
        a.put("fl.session.property.param.value", this.f4560b);
        return a;
    }
}
