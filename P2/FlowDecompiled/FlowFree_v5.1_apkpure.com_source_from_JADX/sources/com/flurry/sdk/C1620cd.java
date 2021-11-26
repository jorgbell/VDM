package com.flurry.sdk;

import com.flurry.sdk.C1601bx;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.flurry.sdk.cd */
public final class C1620cd {
    /* renamed from: a */
    public static List<C1601bx> m4229a(C1634cp cpVar, C1601bx.C1604a aVar, C1616ca caVar, C1629ck ckVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new C1626ci(cpVar, aVar, caVar, ckVar));
        return arrayList;
    }

    /* renamed from: a */
    public static JSONArray m4230a() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry next : C1913n.m4811a().f4728g.mo11264a().mo11283a().entrySet()) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", next.getValue());
            jSONObject.put("type", ((C1502al) next.getKey()).f3778g);
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }
}
