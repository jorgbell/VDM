package com.chartboost.sdk.Model;

import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Model.i */
public class C1239i {

    /* renamed from: a */
    private boolean f2837a;

    /* renamed from: b */
    private String f2838b;

    /* renamed from: c */
    private int f2839c;

    /* renamed from: d */
    private int f2840d;

    public C1239i(boolean z, String str, int i, int i2) {
        this.f2837a = z;
        this.f2838b = str;
        this.f2839c = i;
        this.f2840d = i2;
    }

    /* renamed from: a */
    public String mo10137a() {
        return this.f2838b;
    }

    /* renamed from: b */
    public int mo10138b() {
        return this.f2839c;
    }

    /* renamed from: c */
    public int mo10139c() {
        return this.f2840d;
    }

    /* renamed from: d */
    public boolean mo10140d() {
        return this.f2837a;
    }

    /* renamed from: a */
    public static C1239i m3076a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("tracking");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        return new C1239i(optJSONObject.optBoolean("enabled", false), optJSONObject.optString("endpoint", "https://ssp-events.chartboost.com/track/sdk"), optJSONObject.optInt("eventLimit", 10), optJSONObject.optInt("windowDuration", 60));
    }
}
