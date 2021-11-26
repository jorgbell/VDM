package com.chartboost.sdk;

import com.chartboost.sdk.Banner.C1205a;
import com.chartboost.sdk.Banner.C1206b;
import com.chartboost.sdk.Model.C1236h;
import java.util.HashMap;

/* renamed from: com.chartboost.sdk.b */
public class C1273b {

    /* renamed from: a */
    private HashMap<String, C1205a> f2976a = new HashMap<>();

    /* renamed from: a */
    public void mo10289a(String str, C1205a aVar) {
        this.f2976a.put(str, aVar);
    }

    /* renamed from: b */
    public void mo10292b(String str, String str2) {
        C1206b bVar = this.f2976a.get(str);
        if (bVar != null) {
            bVar.mo9942c(str2);
        }
    }

    /* renamed from: c */
    public void mo10295c(String str, String str2) {
        C1206b bVar = this.f2976a.get(str);
        if (bVar != null) {
            bVar.mo9941b(str2);
        }
    }

    /* renamed from: a */
    public C1205a mo10288a(String str) {
        return this.f2976a.get(str);
    }

    /* renamed from: a */
    public void mo10290a(String str, String str2) {
        C1206b bVar = this.f2976a.get(str);
        if (bVar != null) {
            bVar.mo9938a(str2);
        }
    }

    /* renamed from: b */
    public boolean mo10294b(String str) {
        C1206b bVar = this.f2976a.get(str);
        if (bVar != null) {
            return bVar.mo9940a();
        }
        return false;
    }

    /* renamed from: a */
    public void mo10291a(String str, String str2, String str3) {
        C1206b bVar = this.f2976a.get(str);
        if (bVar != null) {
            bVar.mo9939a(str2, str3);
        }
    }

    /* renamed from: b */
    public boolean mo10293b() {
        C1236h.C1237a a = m3260a();
        if (a != null) {
            return a.mo10135c();
        }
        return true;
    }

    /* renamed from: a */
    private C1236h.C1237a m3260a() {
        C1236h j;
        C1414j b = C1414j.m3867b();
        if (b == null || (j = b.mo10717j()) == null) {
            return null;
        }
        return j.mo10129a();
    }
}
