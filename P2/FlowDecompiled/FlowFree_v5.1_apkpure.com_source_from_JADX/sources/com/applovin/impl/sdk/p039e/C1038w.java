package com.applovin.impl.sdk.p039e;

import com.applovin.impl.p018a.C0542c;
import com.applovin.impl.p018a.C0543d;
import com.applovin.impl.p018a.C0549i;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.network.C1085b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1155o;
import com.applovin.impl.sdk.utils.C1166t;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.e.w */
class C1038w extends C0989a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0542c f2108a;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AppLovinAdLoadListener f2109c;

    C1038w(C0542c cVar, AppLovinAdLoadListener appLovinAdLoadListener, C1062k kVar) {
        super("TaskResolveVastWrapper", kVar);
        this.f2109c = appLovinAdLoadListener;
        this.f2108a = cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2037a(int i) {
        mo9216d("Failed to resolve VAST wrapper due to error code " + i);
        if (i == -103) {
            AppLovinAdLoadListener appLovinAdLoadListener = this.f2109c;
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.failedToReceiveAd(i);
                return;
            }
            return;
        }
        C0549i.m288a(this.f2108a, this.f2109c, i == -102 ? C0543d.TIMED_OUT : C0543d.GENERAL_WRAPPER_ERROR, i, this.f1980b);
    }

    public void run() {
        String a = C0549i.m284a(this.f2108a);
        if (C1155o.m2673b(a)) {
            mo9211a("Resolving VAST ad with depth " + this.f2108a.mo7861a() + " at " + a);
            try {
                this.f1980b.mo9340Q().mo9265a((C0989a) new C1033t<C1166t>(C1085b.m2299a(this.f1980b).mo9481a(a).mo9487b("GET").mo9480a(C1166t.f2500a).mo9479a(((Integer) this.f1980b.mo9350a(C0965b.f1816ei)).intValue()).mo9486b(((Integer) this.f1980b.mo9350a(C0965b.f1817ej)).intValue()).mo9492c(false).mo9485a(), this.f1980b) {
                    /* renamed from: a */
                    public void mo8530a(int i) {
                        mo9216d("Unable to resolve VAST wrapper. Server returned " + i);
                        C1038w.this.m2037a(i);
                    }

                    /* renamed from: a */
                    public void mo8531a(C1166t tVar, int i) {
                        this.f1980b.mo9340Q().mo9265a((C0989a) C1027q.m2004a(tVar, C1038w.this.f2108a, C1038w.this.f2109c, C1038w.this.f1980b));
                    }
                });
            } catch (Throwable th) {
                mo9212a("Unable to resolve VAST wrapper", th);
            }
        } else {
            mo9216d("Resolving VAST failed. Could not find resolution URL");
            m2037a(-1);
        }
    }
}
