package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.jd */
public final class C1881jd extends C1891jm {

    /* renamed from: a */
    public final Map<String, List<String>> f4617a;

    public C1881jd(Map<String, List<String>> map) {
        this.f4617a = map == null ? new HashMap<>() : map;
    }

    /* renamed from: a */
    public final JSONObject mo11543a() throws JSONException {
        JSONObject a = super.mo11543a();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : this.f4617a.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (String str : (List) next.getValue()) {
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put((String) next.getKey(), jSONArray);
            }
        }
        if (jSONObject.length() > 0) {
            a.put("fl.referrer.map", jSONObject);
        }
        return a;
    }
}
