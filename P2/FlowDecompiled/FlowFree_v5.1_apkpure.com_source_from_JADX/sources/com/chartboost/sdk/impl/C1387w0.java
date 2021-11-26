package com.chartboost.sdk.impl;

import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Privacy.model.DataUseConsent;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.chartboost.sdk.impl.w0 */
public class C1387w0 {

    /* renamed from: a */
    private C1292b1 f3439a;

    /* renamed from: b */
    private C1411y0 f3440b;

    /* renamed from: c */
    private C1295c1 f3441c;

    /* renamed from: d */
    private C1413z0 f3442d;

    /* renamed from: e */
    private C1289a1 f3443e;

    /* renamed from: f */
    private C1298d1 f3444f;

    /* renamed from: g */
    private C1236h.C1238b f3445g;

    public C1387w0(C1292b1 b1Var, C1411y0 y0Var, C1295c1 c1Var, C1413z0 z0Var, C1289a1 a1Var, C1298d1 d1Var) {
        this.f3439a = b1Var;
        this.f3440b = y0Var;
        this.f3441c = c1Var;
        this.f3442d = z0Var;
        this.f3443e = a1Var;
        this.f3444f = d1Var;
        m3808e();
    }

    /* renamed from: e */
    private void m3808e() {
        C1298d1 d1Var = this.f3444f;
        if (d1Var != null) {
            d1Var.mo10390a();
        }
    }

    /* renamed from: a */
    public void mo10668a(C1236h.C1238b bVar) {
        this.f3445g = bVar;
    }

    /* renamed from: b */
    public DataUseConsent mo10671b(String str) {
        C1295c1 c1Var = this.f3441c;
        if (c1Var != null) {
            return c1Var.mo10383a(str);
        }
        return null;
    }

    /* renamed from: c */
    public JSONObject mo10672c() {
        List<DataUseConsent> d = mo10673d();
        C1413z0 z0Var = this.f3442d;
        if (z0Var == null || d == null) {
            return null;
        }
        return z0Var.mo10705a(d);
    }

    /* renamed from: d */
    public List<DataUseConsent> mo10673d() {
        C1236h.C1238b bVar;
        C1289a1 a1Var = this.f3443e;
        if (a1Var == null || (bVar = this.f3445g) == null) {
            return null;
        }
        return a1Var.mo10377a(bVar);
    }

    /* renamed from: a */
    public void mo10669a(DataUseConsent dataUseConsent) {
        C1292b1 b1Var = this.f3439a;
        if (b1Var != null) {
            b1Var.mo10378a(dataUseConsent);
        }
    }

    /* renamed from: b */
    public int mo10670b() {
        return this.f3444f.mo10392c();
    }

    /* renamed from: a */
    public DataUseConsent mo10667a(String str) {
        C1411y0 y0Var = this.f3440b;
        if (y0Var != null) {
            return y0Var.mo10704a(str);
        }
        return null;
    }

    /* renamed from: a */
    public int mo10666a() {
        return this.f3444f.mo10391b();
    }
}
