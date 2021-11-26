package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.il */
public final class C1862il extends C1891jm {

    /* renamed from: a */
    public final Map<String, String> f4598a;

    public C1862il(Map<String, String> map) {
        this.f4598a = new HashMap(map);
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.device.properties", C1701ea.m4452a(this.f4598a));
        return a;
    }
}
