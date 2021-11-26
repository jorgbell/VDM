package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.jf */
public final class C1883jf extends C1891jm {

    /* renamed from: a */
    public final Map<C1502al, String> f4618a;

    /* renamed from: b */
    public final boolean f4619b;

    public C1883jf(Map<C1502al, String> map, boolean z) {
        this.f4618a = new HashMap(map);
        this.f4619b = z;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.f4618a.entrySet()) {
            jSONObject.put(((C1502al) next.getKey()).name(), next.getValue());
        }
        a.put("fl.reported.id", jSONObject);
        a.put("fl.ad.tracking", this.f4619b);
        return a;
    }
}
