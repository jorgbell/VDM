package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.hf */
public final class C1826hf extends C1891jm {

    /* renamed from: a */
    public final Map<String, Map<String, String>> f4561a;

    public C1826hf(Map<String, Map<String, String>> map) {
        this.f4561a = new HashMap(map);
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        Map<String, Map<String, String>> map = this.f4561a;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                for (Map.Entry entry : ((Map) next.getValue()).entrySet()) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put((String) entry.getKey(), entry.getValue());
                    jSONObject2 = jSONObject3;
                }
                jSONObject.put((String) next.getKey(), jSONObject2);
            }
        }
        a.put("fl.session.property", jSONObject);
        return a;
    }
}
