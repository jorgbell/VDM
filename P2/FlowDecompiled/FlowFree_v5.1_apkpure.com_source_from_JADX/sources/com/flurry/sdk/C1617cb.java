package com.flurry.sdk;

import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.cb */
public final class C1617cb {
    /* renamed from: a */
    public static List<C1628cj> m4227a(JSONObject jSONObject) {
        JSONArray optJSONArray = jSONObject.optJSONArray("variants");
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject != null) {
                arrayList.add(m4228b(optJSONObject));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private static C1628cj m4228b(JSONObject jSONObject) {
        String optString;
        C1628cj cjVar = new C1628cj(C1623cg.m4237a(jSONObject.optString("document", C1623cg.f4101a.toString())));
        cjVar.f4117b = jSONObject.optInt("id");
        cjVar.f4118c = jSONObject.optInt(MediationMetaData.KEY_VERSION);
        cjVar.f4119d = jSONObject;
        JSONArray optJSONArray = jSONObject.optJSONArray("items");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (optString = optJSONObject.optString(MediationMetaData.KEY_NAME, (String) null)) == null)) {
                    cjVar.f4120e.put(optString, new C1605by(optJSONObject));
                }
            }
        }
        return cjVar;
    }
}
