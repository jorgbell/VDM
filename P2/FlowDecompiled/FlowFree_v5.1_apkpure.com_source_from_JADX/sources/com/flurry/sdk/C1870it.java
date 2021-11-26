package com.flurry.sdk;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.it */
public final class C1870it extends C1891jm {

    /* renamed from: a */
    public final String f4605a;

    /* renamed from: b */
    public final List<String> f4606b;

    public C1870it(String str, List<String> list) {
        this.f4605a = str;
        this.f4606b = list;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        JSONArray jSONArray = new JSONArray();
        for (String put : this.f4606b) {
            jSONArray.put(put);
        }
        a.put("fl.launch.options.key", this.f4605a);
        a.put("fl.launch.options.values", jSONArray);
        return a;
    }
}
