package com.chartboost.sdk.Libraries;

import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Libraries.e */
public class C1217e {

    /* renamed from: com.chartboost.sdk.Libraries.e$a */
    public static class C1218a {

        /* renamed from: a */
        final String f2675a;

        /* renamed from: b */
        final Object f2676b;

        public C1218a(String str, Object obj) {
            this.f2675a = str;
            this.f2676b = obj;
        }
    }

    /* renamed from: a */
    public static JSONObject m2936a(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            if (jSONObject == null) {
                break;
            }
            jSONObject = jSONObject.optJSONObject(str);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static void m2938a(JSONObject jSONObject, String str, Object obj) {
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            CBLogging.m2905b("CBJSON", "put (" + str + ")" + e.toString());
        }
    }

    /* renamed from: a */
    public static JSONObject m2937a(C1218a... aVarArr) {
        JSONObject jSONObject = new JSONObject();
        for (C1218a aVar : aVarArr) {
            m2938a(jSONObject, aVar.f2675a, aVar.f2676b);
        }
        return jSONObject;
    }

    /* renamed from: a */
    public static C1218a m2935a(String str, Object obj) {
        return new C1218a(str, obj);
    }
}
