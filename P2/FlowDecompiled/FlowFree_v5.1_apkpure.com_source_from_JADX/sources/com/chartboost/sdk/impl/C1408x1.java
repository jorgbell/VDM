package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.CBLogging;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.x1 */
public class C1408x1 {

    /* renamed from: com.chartboost.sdk.impl.x1$a */
    interface C1409a {
        /* renamed from: a */
        void mo10611a(JSONObject jSONObject);
    }

    /* renamed from: a */
    public void mo10702a(String str, C1409a aVar) {
        if (m3837a(str)) {
            CBLogging.m2905b("Chartboost", "CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource");
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("message", "CORS policy: No 'Access-Control-Allow-Origin' header is present on the requested resource");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (aVar != null) {
                aVar.mo10611a(jSONObject);
            }
        }
    }

    /* renamed from: a */
    private boolean m3837a(String str) {
        return str != null && !str.isEmpty() && str.contains("Access-Control-Allow-Origin") && str.contains("'null'");
    }
}
