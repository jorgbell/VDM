package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.C1217e;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.g1 */
public class C1311g1 {
    /* renamed from: a */
    public JSONObject mo10433a(C1301e1 e1Var) {
        if (e1Var == null) {
            return new JSONObject();
        }
        return C1217e.m2937a(C1217e.m2935a("carrier-name", (Object) e1Var.mo10407d()), C1217e.m2935a("mobile-country-code", (Object) e1Var.mo10404a()), C1217e.m2935a("mobile-network-code", (Object) e1Var.mo10405b()), C1217e.m2935a("iso-country-code", (Object) e1Var.mo10406c()), C1217e.m2935a("phone-type", (Object) Integer.valueOf(e1Var.mo10408e())));
    }
}
