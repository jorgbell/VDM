package com.applovin.impl.adview.activity.p019a;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0666m;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;

/* renamed from: com.applovin.impl.adview.activity.a.a */
abstract class C0572a {

    /* renamed from: a */
    final C1062k f309a;

    /* renamed from: b */
    final AppLovinFullscreenActivity f310b;

    /* renamed from: c */
    final C0934g f311c;

    /* renamed from: d */
    final ViewGroup f312d;

    /* renamed from: e */
    final FrameLayout.LayoutParams f313e;

    C0572a(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        this.f313e = layoutParams;
        this.f311c = gVar;
        this.f309a = kVar;
        this.f310b = appLovinFullscreenActivity;
        FrameLayout frameLayout = new FrameLayout(appLovinFullscreenActivity);
        this.f312d = frameLayout;
        frameLayout.setBackgroundColor(-16777216);
        frameLayout.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo7962a(C0934g.C0938c cVar, int i, C0666m mVar) {
        mVar.mo8215a(cVar.f1463a, cVar.f1467e, cVar.f1466d, i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(mVar.getLayoutParams());
        int i2 = cVar.f1465c;
        layoutParams.setMargins(i2, cVar.f1464b, i2, 0);
        layoutParams.gravity = i;
        this.f312d.addView(mVar, layoutParams);
    }
}
