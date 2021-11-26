package com.applovin.impl.mediation.debugger.p024a.p025a;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.utils.C1123j;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.a.a.d */
public class C0799d {

    /* renamed from: a */
    private final String f940a;

    /* renamed from: b */
    private final String f941b;

    public C0799d(JSONObject jSONObject, C1062k kVar) {
        this.f940a = C1123j.m2594b(jSONObject, "id", "", kVar);
        this.f941b = C1123j.m2594b(jSONObject, "price", (String) null, kVar);
    }

    /* renamed from: a */
    public String mo8581a() {
        return this.f940a;
    }

    /* renamed from: b */
    public String mo8582b() {
        return this.f941b;
    }
}
