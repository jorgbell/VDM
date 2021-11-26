package com.applovin.impl.mediation.debugger.p028ui.testmode;

import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p037c.C0967d;
import com.applovin.impl.sdk.utils.C1123j;
import com.applovin.impl.sdk.utils.C1155o;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.mediation.debugger.ui.testmode.b */
public class C0860b {

    /* renamed from: a */
    private final C1062k f1187a;

    /* renamed from: b */
    private boolean f1188b;

    /* renamed from: c */
    private boolean f1189c;

    /* renamed from: d */
    private String f1190d;

    public C0860b(C1062k kVar) {
        this.f1187a = kVar;
        C0967d dVar = C0967d.f1844B;
        this.f1190d = (String) kVar.mo9379b(dVar, null);
        kVar.mo9383b(dVar);
        if (C1155o.m2673b(this.f1190d)) {
            this.f1189c = true;
        }
        C0967d dVar2 = C0967d.f1845C;
        this.f1188b = ((Boolean) kVar.mo9379b(dVar2, Boolean.FALSE)).booleanValue();
        kVar.mo9383b(dVar2);
    }

    /* renamed from: a */
    public void mo8726a(String str) {
        this.f1190d = str;
    }

    /* renamed from: a */
    public void mo8727a(JSONObject jSONObject) {
        if (!this.f1188b) {
            this.f1188b = C1123j.m2590a(this.f1187a.mo9343T().mo9436j().f2255b, C1123j.m2599b(jSONObject, "test_mode_idfas", new JSONArray(), this.f1187a)) || this.f1187a.mo9343T().mo9432f() || this.f1187a.mo9343T().mo9437k();
        }
    }

    /* renamed from: a */
    public void mo8728a(boolean z) {
        this.f1189c = z;
    }

    /* renamed from: a */
    public boolean mo8729a() {
        return this.f1188b;
    }

    /* renamed from: b */
    public void mo8730b(String str) {
        this.f1187a.mo9357a(C0967d.f1844B, str);
    }

    /* renamed from: b */
    public boolean mo8731b() {
        return this.f1189c;
    }

    /* renamed from: c */
    public String mo8732c() {
        return this.f1190d;
    }

    /* renamed from: d */
    public void mo8733d() {
        this.f1187a.mo9357a(C0967d.f1845C, Boolean.TRUE);
    }
}
