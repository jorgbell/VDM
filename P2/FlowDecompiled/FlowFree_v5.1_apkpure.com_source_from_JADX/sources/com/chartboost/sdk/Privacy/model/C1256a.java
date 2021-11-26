package com.chartboost.sdk.Privacy.model;

import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.Privacy.model.a */
abstract class C1256a implements DataUseConsent {

    /* renamed from: a */
    String f2894a;

    /* renamed from: b */
    String f2895b;

    C1256a() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10181a(String str) {
        try {
            C1266e.m3223e(new C1260a("consent_creation_error", str, "", ""));
            throw new Exception(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getConsent() {
        return this.f2895b;
    }

    public String getPrivacyStandard() {
        return this.f2894a;
    }

    public abstract boolean isValidConsent(String str);

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("privacyStandard", this.f2894a);
            jSONObject.put("consent", this.f2895b);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
