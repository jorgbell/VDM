package com.applovin.impl.mediation.p021a;

import com.applovin.impl.mediation.C0870i;
import com.applovin.impl.sdk.C1062k;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.d */
public class C0736d extends C0733a {
    private C0736d(C0736d dVar, C0870i iVar) {
        super(dVar.mo8441H(), dVar.mo8440G(), iVar, dVar.f771b);
    }

    public C0736d(JSONObject jSONObject, JSONObject jSONObject2, C1062k kVar) {
        super(jSONObject, jSONObject2, (C0870i) null, kVar);
    }

    /* renamed from: a */
    public C0733a mo8384a(C0870i iVar) {
        return new C0736d(this, iVar);
    }
}
