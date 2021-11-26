package com.chartboost.sdk.impl;

import android.content.SharedPreferences;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Privacy.model.Custom;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import com.chartboost.sdk.Privacy.model.GDPR;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.x0 */
public class C1407x0 {

    /* renamed from: a */
    private HashMap<String, DataUseConsent> f3485a = new HashMap<>();

    /* renamed from: b */
    private SharedPreferences f3486b;

    public C1407x0(SharedPreferences sharedPreferences) {
        this.f3486b = sharedPreferences;
        m3831c();
    }

    /* renamed from: c */
    private void m3831c() {
        String string;
        SharedPreferences sharedPreferences = this.f3486b;
        if (sharedPreferences != null && (string = sharedPreferences.getString("privacy_standards", "")) != null && !string.isEmpty()) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string2 = jSONObject.getString("privacyStandard");
                    String string3 = jSONObject.getString("consent");
                    DataUseConsent dataUseConsent = null;
                    if (GDPR.GDPR_STANDARD.equals(string2)) {
                        GDPR.GDPR_CONSENT gdpr_consent = GDPR.GDPR_CONSENT.BEHAVIORAL;
                        if (gdpr_consent.getValue().equals(string3)) {
                            dataUseConsent = new GDPR(gdpr_consent);
                        } else {
                            GDPR.GDPR_CONSENT gdpr_consent2 = GDPR.GDPR_CONSENT.NON_BEHAVIORAL;
                            if (gdpr_consent2.getValue().equals(string3)) {
                                dataUseConsent = new GDPR(gdpr_consent2);
                            }
                        }
                    } else {
                        dataUseConsent = new Custom(jSONObject.getString("privacyStandard"), jSONObject.getString("consent"));
                    }
                    if (dataUseConsent != null) {
                        this.f3485a.put(dataUseConsent.getPrivacyStandard(), dataUseConsent);
                    } else {
                        C1266e.m3223e(new C1260a("consent_persisted_data_reading_error", string2, "", ""));
                        CBLogging.m2903a("Chartboost", "Failed to load consent: " + string2);
                    }
                }
            } catch (JSONException e) {
                C1266e.m3223e(new C1260a("consent_decoding_error", e.getMessage(), "", ""));
                e.printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private void m3832d() {
        if (this.f3486b != null) {
            JSONArray jSONArray = new JSONArray();
            for (DataUseConsent json : this.f3485a.values()) {
                jSONArray.put(json.toJson());
            }
            m3830a(this.f3486b, jSONArray);
        }
    }

    /* renamed from: a */
    public DataUseConsent mo10698a() {
        return this.f3485a.get(GDPR.GDPR_STANDARD);
    }

    /* renamed from: b */
    public HashMap<String, DataUseConsent> mo10701b() {
        return this.f3485a;
    }

    /* renamed from: a */
    public void mo10700a(DataUseConsent dataUseConsent) {
        CBLogging.m2903a("Chartboost", "Added privacy standard: " + dataUseConsent.getPrivacyStandard() + " with consent: " + dataUseConsent.getConsent());
        this.f3485a.put(dataUseConsent.getPrivacyStandard(), dataUseConsent);
        m3832d();
    }

    /* renamed from: a */
    public DataUseConsent mo10699a(String str) {
        DataUseConsent remove = this.f3485a.remove(str);
        m3832d();
        return remove;
    }

    /* renamed from: a */
    private void m3830a(SharedPreferences sharedPreferences, JSONArray jSONArray) {
        if (sharedPreferences != null && jSONArray != null) {
            sharedPreferences.edit().putString("privacy_standards", jSONArray.toString()).apply();
        }
    }
}
