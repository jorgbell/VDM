package com.applovin.impl.mediation.debugger.p024a.p025a;

import com.applovin.impl.mediation.debugger.p024a.p026b.C0801b;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.utils.C1123j;
import com.unity3d.ads.metadata.MediationMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.c */
public class C0798c {

    /* renamed from: a */
    private final String f936a;

    /* renamed from: b */
    private final boolean f937b;

    /* renamed from: c */
    private final List<C0797b> f938c;

    /* renamed from: d */
    private final List<C0797b> f939d;

    C0798c(JSONObject jSONObject, Map<String, C0801b> map, C1062k kVar) {
        this.f936a = C1123j.m2594b(jSONObject, MediationMetaData.KEY_NAME, "", kVar);
        this.f937b = C1123j.m2568a(jSONObject, "default", Boolean.FALSE, kVar).booleanValue();
        this.f938c = m1152a("bidders", jSONObject, map, kVar);
        this.f939d = m1152a("waterfall", jSONObject, map, kVar);
    }

    /* renamed from: a */
    private List<C0797b> m1152a(String str, JSONObject jSONObject, Map<String, C0801b> map, C1062k kVar) {
        ArrayList arrayList = new ArrayList();
        JSONArray b = C1123j.m2599b(jSONObject, str, new JSONArray(), kVar);
        for (int i = 0; i < b.length(); i++) {
            JSONObject a = C1123j.m2581a(b, i, (JSONObject) null, kVar);
            if (a != null) {
                String b2 = C1123j.m2594b(a, "adapter_class", "", kVar);
                C0801b bVar = map.get(b2);
                if (bVar == null) {
                    C1107r z = kVar.mo9411z();
                    z.mo9588e("AdUnitWaterfall", "Failed to retrieve network info for adapter class: " + b2);
                } else {
                    arrayList.add(new C0797b(a, bVar, kVar));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public List<C0797b> mo8578a() {
        return this.f938c;
    }

    /* renamed from: b */
    public List<C0797b> mo8579b() {
        return this.f939d;
    }

    /* renamed from: c */
    public boolean mo8580c() {
        return this.f937b;
    }
}
