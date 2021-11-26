package com.flurry.sdk;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.ij */
public final class C1860ij extends C1891jm {

    /* renamed from: a */
    public boolean f4596a;

    /* renamed from: b */
    public Map<String, String> f4597b;

    public C1860ij(boolean z, Map<String, String> map) {
        this.f4596a = z;
        this.f4597b = map;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        a.put("fl.consent.isGdprScope", this.f4596a);
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.f4597b.entrySet()) {
            jSONObject.put((String) next.getKey(), next.getValue());
        }
        a.put("fl.consent.strings", jSONObject);
        return a;
    }
}
