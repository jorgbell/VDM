package com.applovin.impl.mediation.p023c;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.utils.C1120h;
import com.applovin.impl.sdk.utils.C1123j;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.c.b */
public class C0787b extends C1120h {

    /* renamed from: a */
    private static final String[] f906a = {"ads", "settings", "auto_init_adapters", "test_mode_idfas", "test_mode_auto_init_adapters"};

    /* renamed from: b */
    private static final String[] f907b = {"ads", "settings", "signal_providers"};

    /* renamed from: a */
    public static String m1102a(C1062k kVar) {
        return C1120h.m2538a((String) kVar.mo9350a(C0964a.f1544c), "1.0/mediate", kVar);
    }

    /* renamed from: a */
    public static void m1103a(JSONObject jSONObject, C1062k kVar) {
        if (C1123j.m2591a(jSONObject, "signal_providers")) {
            JSONObject d = C1123j.m2605d(jSONObject);
            C1123j.m2589a(d, f906a);
            kVar.mo9357a(C0967d.f1869x, d.toString());
        }
    }

    /* renamed from: b */
    public static String m1104b(C1062k kVar) {
        return C1120h.m2538a((String) kVar.mo9350a(C0964a.f1545d), "1.0/mediate", kVar);
    }

    /* renamed from: b */
    public static void m1105b(JSONObject jSONObject, C1062k kVar) {
        if (jSONObject.length() != 0) {
            if (C1123j.m2591a(jSONObject, "auto_init_adapters") || C1123j.m2591a(jSONObject, "test_mode_auto_init_adapters")) {
                JSONObject d = C1123j.m2605d(jSONObject);
                C1123j.m2589a(d, f907b);
                kVar.mo9357a(C0967d.f1870y, d.toString());
                return;
            }
            kVar.mo9383b(C0967d.f1870y);
        }
    }

    /* renamed from: c */
    public static String m1106c(C1062k kVar) {
        return C1120h.m2538a((String) kVar.mo9350a(C0964a.f1544c), "1.0/mediate_debug", kVar);
    }

    /* renamed from: d */
    public static String m1107d(C1062k kVar) {
        return C1120h.m2538a((String) kVar.mo9350a(C0964a.f1545d), "1.0/mediate_debug", kVar);
    }
}
