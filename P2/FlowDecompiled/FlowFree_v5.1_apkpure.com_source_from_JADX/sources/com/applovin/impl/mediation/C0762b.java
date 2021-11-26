package com.applovin.impl.mediation;

import com.applovin.impl.mediation.C0731a;
import com.applovin.impl.mediation.C0783c;
import com.applovin.impl.mediation.p021a.C0735c;
import com.applovin.impl.sdk.C1062k;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.mediation.b */
public class C0762b implements C0731a.C0732a, C0783c.C0785a {

    /* renamed from: a */
    private final C0731a f843a;

    /* renamed from: b */
    private final C0783c f844b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final MaxAdListener f845c;

    public C0762b(C1062k kVar, MaxAdListener maxAdListener) {
        this.f845c = maxAdListener;
        this.f843a = new C0731a(kVar);
        this.f844b = new C0783c(kVar, this);
    }

    /* renamed from: a */
    public void mo8383a(final C0735c cVar) {
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
            public void run() {
                C0762b.this.f845c.onAdHidden(cVar);
            }
        }, cVar.mo8432s());
    }

    /* renamed from: a */
    public void mo8519a(MaxAd maxAd) {
        this.f844b.mo8549a();
        this.f843a.mo8381a();
    }

    /* renamed from: b */
    public void mo8520b(C0735c cVar) {
        long q = cVar.mo8430q();
        if (q >= 0) {
            this.f844b.mo8550a(cVar, q);
        }
        if (cVar.mo8431r()) {
            this.f843a.mo8382a(cVar, this);
        }
    }

    /* renamed from: c */
    public void mo8521c(C0735c cVar) {
        this.f845c.onAdHidden(cVar);
    }
}
