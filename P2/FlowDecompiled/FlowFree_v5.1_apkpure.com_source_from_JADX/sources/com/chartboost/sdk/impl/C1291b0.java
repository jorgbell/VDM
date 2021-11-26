package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C1229b;
import com.mopub.common.AdType;
import com.mopub.common.DataKeys;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.b0 */
public class C1291b0 {
    /* renamed from: a */
    private static C1229b m3380a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return new C1229b(AdType.HTML, str.substring(str.lastIndexOf(47) + 1), str);
    }

    /* renamed from: b */
    public static C1300e0 m3384b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            return new C1300e0();
        }
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject2.optJSONArray("seatbid");
        C1297d0 d0Var = new C1297d0();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                if (jSONObject3 != null) {
                    String optString = jSONObject3.optString("seat");
                    JSONArray optJSONArray2 = jSONObject3.optJSONArray("bid");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        int length2 = optJSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject4 = optJSONArray2.getJSONObject(i2);
                            if (jSONObject4 != null) {
                                JSONObject optJSONObject = jSONObject4.optJSONObject("ext").optJSONObject("bidder");
                                if (optJSONObject == null) {
                                    optJSONObject = jSONObject4.getJSONObject("ext");
                                }
                                if (optJSONObject != null) {
                                    d0Var = m3382a(optJSONObject);
                                    C1229b a = m3380a(d0Var.mo10388e());
                                    if (a != null) {
                                        arrayList.add(a);
                                    }
                                }
                                arrayList2.add(m3381a(jSONObject4, d0Var));
                            }
                        }
                    }
                    arrayList3.add(new C1303f0(optString, arrayList2));
                }
            }
        }
        return m3383a(jSONObject2, arrayList3, arrayList);
    }

    /* renamed from: a */
    private static C1297d0 m3382a(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("imptrackers");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i, ""));
            }
        }
        return new C1297d0(jSONObject.optString("crtype", ""), jSONObject.optString("adId", ""), jSONObject.optString("cgn", ""), jSONObject.getString("template"), arrayList);
    }

    /* renamed from: a */
    private static C1294c0 m3381a(JSONObject jSONObject, C1297d0 d0Var) throws JSONException {
        return new C1294c0(jSONObject.getString("id"), jSONObject.getString("impid"), Double.valueOf(jSONObject.getDouble("price")), jSONObject.optString("burl", ""), jSONObject.optString("crid", ""), jSONObject.optString(DataKeys.ADM_KEY, ""), d0Var);
    }

    /* renamed from: a */
    private static C1300e0 m3383a(JSONObject jSONObject, ArrayList<C1303f0> arrayList, ArrayList<C1229b> arrayList2) throws JSONException {
        return new C1300e0(jSONObject.getString("id"), jSONObject.optString("nbr", ""), jSONObject.optString("cur", "USD"), jSONObject.optString("bidid", ""), arrayList, arrayList2);
    }
}
