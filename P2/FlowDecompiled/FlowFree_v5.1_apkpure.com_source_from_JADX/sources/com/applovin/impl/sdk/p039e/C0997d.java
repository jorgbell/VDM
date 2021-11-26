package com.applovin.impl.sdk.p039e;

import android.net.Uri;
import com.applovin.impl.mediation.p021a.C0733a;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.p035a.C0924a;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p038d.C0981d;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.e.d */
public class C0997d extends C0994c {

    /* renamed from: c */
    private final C0924a f1996c;

    /* renamed from: d */
    private boolean f1997d;

    /* renamed from: e */
    private boolean f1998e;

    public C0997d(C0924a aVar, C1062k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, kVar, appLovinAdLoadListener);
        this.f1996c = aVar;
    }

    /* renamed from: j */
    private void m1925j() {
        mo9211a("Caching HTML resources...");
        this.f1996c.mo8956a(mo9227a(this.f1996c.mo7824c(), this.f1996c.mo9000I(), (C0934g) this.f1996c));
        this.f1996c.mo9021a(true);
        mo9211a("Finish caching non-video resources for ad #" + this.f1996c.getAdIdNumber());
        C1107r z = this.f1980b.mo9411z();
        String e = mo9217e();
        z.mo9582a(e, "Ad updated with cachedHTML = " + this.f1996c.mo7824c());
    }

    /* renamed from: k */
    private void m1926k() {
        Uri e;
        if (!mo9231b() && (e = mo9233e(this.f1996c.mo8958h())) != null) {
            this.f1996c.mo8957f();
            this.f1996c.mo8955a(e);
        }
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ void mo8849a(C0733a aVar) {
        super.mo8849a(aVar);
    }

    /* renamed from: a */
    public void mo9240a(boolean z) {
        this.f1997d = z;
    }

    /* renamed from: b */
    public void mo9241b(boolean z) {
        this.f1998e = z;
    }

    public void run() {
        super.run();
        boolean e = this.f1996c.mo7826e();
        boolean z = this.f1998e;
        if (e || z) {
            mo9211a("Begin caching for streaming ad #" + this.f1996c.getAdIdNumber() + "...");
            mo9232c();
            if (e) {
                if (this.f1997d) {
                    mo9236i();
                }
                m1925j();
                if (!this.f1997d) {
                    mo9236i();
                }
                m1926k();
            } else {
                mo9236i();
                m1925j();
            }
        } else {
            mo9211a("Begin processing for non-streaming ad #" + this.f1996c.getAdIdNumber() + "...");
            mo9232c();
            m1925j();
            m1926k();
            mo9236i();
        }
        long currentTimeMillis = System.currentTimeMillis() - this.f1996c.getCreatedAtMillis();
        C0981d.m1831a(this.f1996c, this.f1980b);
        C0981d.m1830a(currentTimeMillis, (AppLovinAdBase) this.f1996c, this.f1980b);
        mo9229a((AppLovinAdBase) this.f1996c);
        mo9228a();
    }
}
