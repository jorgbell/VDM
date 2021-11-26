package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.iz */
public final class C1876iz extends C1891jm {

    /* renamed from: a */
    public final String f4613a;

    /* renamed from: b */
    public final Map<String, String> f4614b;

    public C1876iz(String str, Map<String, String> map) {
        this.f4613a = str;
        this.f4614b = map == null ? new HashMap<>() : map;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        JSONObject a2 = C1701ea.m4452a(this.f4614b);
        a.put("fl.origin.attribute.name", this.f4613a);
        a.put("fl.origin.attribute.parameters", a2);
        return a;
    }
}
