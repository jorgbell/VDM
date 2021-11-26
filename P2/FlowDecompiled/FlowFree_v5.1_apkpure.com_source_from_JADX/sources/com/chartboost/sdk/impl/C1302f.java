package com.chartboost.sdk.impl;

import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.C1231d;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1305g;

/* renamed from: com.chartboost.sdk.impl.f */
class C1302f implements C1231d {

    /* renamed from: a */
    private final C1305g f3084a;

    /* renamed from: b */
    private final C1312h f3085b;

    C1302f(C1305g gVar, C1312h hVar) {
        this.f3084a = gVar;
        this.f3085b = hVar;
    }

    /* renamed from: d */
    private boolean m3429d(C1230c cVar) {
        return m3430e(cVar);
    }

    /* renamed from: e */
    private boolean m3430e(C1230c cVar) {
        return (this.f3084a.f3106o.f3035a != 0 || cVar.f2735a == 1 || cVar.f2751q.f2709b == 1) ? false : true;
    }

    /* renamed from: f */
    private void m3431f(C1230c cVar) {
        if (m3429d(cVar)) {
            mo10114c(cVar);
        }
    }

    /* renamed from: a */
    public void mo10111a(C1230c cVar) {
        C1305g gVar = this.f3084a;
        gVar.getClass();
        C1312h hVar = this.f3085b;
        this.f3084a.f3092a.execute(new C1305g.C1307b(7, hVar.f3139b, hVar, (CBError.CBImpressionError) null));
    }

    /* renamed from: b */
    public void mo10113b(C1230c cVar) {
        cVar.f2736b = 1;
        if (this.f3084a.f3106o.mo10370a(this.f3085b.f3139b)) {
            this.f3084a.f3102k.mo10301b(cVar);
            m3431f(cVar);
            return;
        }
        C1305g gVar = this.f3084a;
        gVar.getClass();
        C1312h hVar = this.f3085b;
        this.f3084a.f3092a.execute(new C1305g.C1307b(7, hVar.f3139b, hVar, (CBError.CBImpressionError) null));
    }

    /* renamed from: c */
    public void mo10114c(C1230c cVar) {
        cVar.f2760z = true;
        C1305g gVar = this.f3084a;
        gVar.getClass();
        C1312h hVar = this.f3085b;
        this.f3084a.f3092a.execute(new C1305g.C1307b(5, hVar.f3139b, hVar, (CBError.CBImpressionError) null));
    }

    /* renamed from: a */
    public void mo10112a(C1230c cVar, CBError.CBImpressionError cBImpressionError) {
        String str;
        String str2;
        C1275d dVar = this.f3084a.f3102k;
        dVar.getClass();
        C1275d.C1276a aVar = new C1275d.C1276a(11);
        aVar.f2987c = cVar;
        C1414j.m3873e(aVar);
        C1305g gVar = this.f3084a;
        gVar.getClass();
        C1312h hVar = this.f3085b;
        this.f3084a.f3092a.execute(new C1305g.C1307b(6, hVar.f3139b, hVar, cBImpressionError));
        if (cVar != null) {
            str2 = cVar.f2747m;
            str = cVar.f2737c.f3036b;
        } else {
            str = "";
            str2 = str;
        }
        C1266e.m3223e(new C1260a("show_unexpected_dismiss_error", "", str, str2));
    }
}
