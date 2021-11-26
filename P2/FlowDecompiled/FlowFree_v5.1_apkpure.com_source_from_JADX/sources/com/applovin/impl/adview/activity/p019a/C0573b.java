package com.applovin.impl.adview.activity.p019a;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0666m;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;

/* renamed from: com.applovin.impl.adview.activity.a.b */
public class C0573b extends C0572a {
    public C0573b(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar) {
        super(gVar, appLovinFullscreenActivity, kVar);
    }

    /* renamed from: a */
    public void mo7963a(C0666m mVar, AppLovinAdView appLovinAdView) {
        this.f312d.addView(appLovinAdView);
        if (mVar != null) {
            mo7962a(this.f311c.mo9013V(), (this.f311c.mo9017Z() ? 3 : 5) | 48, mVar);
        }
        this.f310b.setContentView(this.f312d);
    }
}
