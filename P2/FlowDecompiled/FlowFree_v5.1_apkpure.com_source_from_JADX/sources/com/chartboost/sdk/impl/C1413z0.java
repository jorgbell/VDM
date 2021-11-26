package com.chartboost.sdk.impl;

import com.chartboost.sdk.Privacy.model.DataUseConsent;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.z0 */
public class C1413z0 {
    /* renamed from: a */
    public JSONObject mo10705a(List<DataUseConsent> list) {
        JSONObject jSONObject = new JSONObject();
        for (DataUseConsent next : list) {
            try {
                jSONObject.put(next.getPrivacyStandard(), next.getConsent());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }
}
