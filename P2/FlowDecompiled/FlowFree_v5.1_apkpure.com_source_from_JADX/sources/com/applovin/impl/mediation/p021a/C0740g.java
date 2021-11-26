package com.applovin.impl.mediation.p021a;

import com.applovin.impl.sdk.C1062k;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.a.g */
public class C0740g extends C0737e {
    public C0740g(JSONObject jSONObject, JSONObject jSONObject2, C1062k kVar) {
        super(jSONObject, jSONObject2, kVar);
    }

    /* renamed from: a */
    public boolean mo8385a() {
        return mo8464b("only_collect_signal_when_initialized", Boolean.FALSE).booleanValue();
    }

    public String toString() {
        return "SignalProviderSpec{adObject=" + mo8441H() + '}';
    }
}
