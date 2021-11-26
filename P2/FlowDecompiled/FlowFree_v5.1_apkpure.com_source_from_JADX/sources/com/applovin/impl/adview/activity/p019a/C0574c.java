package com.applovin.impl.adview.activity.p019a;

import android.graphics.Point;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.C0564a;
import com.applovin.impl.adview.C0666m;
import com.applovin.impl.adview.C0715t;
import com.applovin.impl.adview.C0716u;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.p035a.C0934g;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1113b;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.impl.sdk.utils.C1163s;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.adview.activity.a.c */
public class C0574c extends C0572a {
    public C0574c(C0934g gVar, AppLovinFullscreenActivity appLovinFullscreenActivity, C1062k kVar) {
        super(gVar, appLovinFullscreenActivity, kVar);
    }

    /* renamed from: a */
    public void mo7964a(ImageView imageView, C0666m mVar, final C0716u uVar, C0564a aVar, ProgressBar progressBar, View view, AppLovinAdView appLovinAdView) {
        view.setLayoutParams(this.f313e);
        this.f312d.addView(view);
        appLovinAdView.setLayoutParams(this.f313e);
        this.f312d.addView(appLovinAdView);
        appLovinAdView.setVisibility(4);
        if (uVar != null) {
            C0715t B = this.f311c.mo8994B();
            double a = (double) B.mo8286a();
            Double.isNaN(a);
            double b = (double) B.mo8287b();
            Double.isNaN(b);
            Point a2 = C1119g.m2526a(this.f310b);
            double d = (double) a2.x;
            Double.isNaN(d);
            double d2 = (double) a2.y;
            Double.isNaN(d2);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (d * (a / 100.0d)), (int) (d2 * (b / 100.0d)), B.mo8289d());
            int dpToPx = AppLovinSdkUtils.dpToPx(this.f310b, B.mo8288c());
            layoutParams.setMargins(dpToPx, dpToPx, dpToPx, dpToPx);
            this.f312d.addView(uVar, layoutParams);
            if (B.mo8296i() > 0.0f) {
                uVar.setVisibility(4);
                long b2 = C1160r.m2738b(B.mo8296i());
                final long g = B.mo8293g();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        C1163s.m2766a((View) uVar, g, (Runnable) null);
                    }
                }, b2);
            }
            if (B.mo8297j() > 0.0f) {
                long b3 = C1160r.m2738b(B.mo8297j());
                final long h = B.mo8294h();
                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                    public void run() {
                        C1163s.m2771b(uVar, h, (Runnable) null);
                    }
                }, b3);
            }
        }
        if (mVar != null) {
            mo7962a(this.f311c.mo9013V(), (this.f311c.mo9033aa() ? 3 : 5) | 48, mVar);
        }
        if (imageView != null) {
            int dpToPx2 = AppLovinSdkUtils.dpToPx(this.f310b, ((Integer) this.f309a.mo9350a(C0965b.f1727cu)).intValue());
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dpToPx2, dpToPx2, ((Integer) this.f309a.mo9350a(C0965b.f1729cw)).intValue());
            int dpToPx3 = AppLovinSdkUtils.dpToPx(this.f310b, ((Integer) this.f309a.mo9350a(C0965b.f1728cv)).intValue());
            layoutParams2.setMargins(dpToPx3, dpToPx3, dpToPx3, dpToPx3);
            this.f312d.addView(imageView, layoutParams2);
        }
        if (aVar != null) {
            this.f312d.addView(aVar, this.f313e);
        }
        if (progressBar != null) {
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, 20, 80);
            layoutParams3.setMargins(0, 0, 0, ((Integer) this.f309a.mo9350a(C0965b.f1681cA)).intValue());
            this.f312d.addView(progressBar, layoutParams3);
        }
        this.f310b.setContentView(this.f312d);
    }

    /* renamed from: a */
    public void mo7965a(C0666m mVar, View view) {
        view.setVisibility(0);
        C1113b.m2506a(this.f312d, view);
        if (mVar != null) {
            mo7962a(this.f311c.mo9013V(), (this.f311c.mo9017Z() ? 3 : 5) | 48, mVar);
        }
    }
}
