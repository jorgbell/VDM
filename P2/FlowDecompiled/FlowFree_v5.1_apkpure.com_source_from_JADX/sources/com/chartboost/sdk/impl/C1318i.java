package com.chartboost.sdk.impl;

import com.chartboost.sdk.C1418k;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C1264c;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1357p0;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.i */
public class C1318i implements C1357p0.C1358a {

    /* renamed from: a */
    private final C1305g f3173a;

    /* renamed from: b */
    private final String f3174b;

    public C1318i(C1305g gVar, String str) {
        this.f3173a = gVar;
        this.f3174b = str;
    }

    /* renamed from: a */
    public void mo10427a(C1357p0 p0Var, JSONObject jSONObject) {
        C1305g gVar = this.f3173a;
        if (gVar.f3106o.f3041g || C1418k.f3544n) {
            synchronized (gVar) {
                C1305g gVar2 = this.f3173a;
                if (gVar2.f3106o.f3035a != 3) {
                    gVar2.mo10419d(this.f3174b);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo10426a(C1357p0 p0Var, CBError cBError) {
        C1305g gVar = this.f3173a;
        if (gVar.f3106o.f3041g) {
            synchronized (gVar) {
                this.f3173a.mo10419d(this.f3174b);
            }
        }
        C1266e.m3223e(new C1264c("show_request_error", cBError.getErrorDesc(), this.f3173a.f3106o.f3036b, this.f3174b));
    }
}
