package com.applovin.impl.sdk;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Animation;
import com.applovin.impl.mediation.p021a.C0734b;
import com.applovin.impl.sdk.utils.C1119g;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.w */
public class C1175w {

    /* renamed from: a */
    private final C1062k f2525a;

    /* renamed from: b */
    private final C1107r f2526b;

    /* renamed from: c */
    private final MaxAdView f2527c;

    public C1175w(MaxAdView maxAdView, C1062k kVar) {
        this.f2525a = kVar;
        this.f2526b = kVar.mo9411z();
        this.f2527c = maxAdView;
    }

    /* renamed from: a */
    public long mo9725a(C0734b bVar) {
        long j;
        this.f2526b.mo9584b("ViewabilityTracker", "Checking visibility...");
        if (!this.f2527c.isShown()) {
            this.f2526b.mo9588e("ViewabilityTracker", "View is hidden");
            j = 2;
        } else {
            j = 0;
        }
        if (this.f2527c.getAlpha() < bVar.mo8418v()) {
            this.f2526b.mo9588e("ViewabilityTracker", "View is transparent");
            j |= 4;
        }
        Animation animation = this.f2527c.getAnimation();
        if (animation != null && animation.hasStarted() && !animation.hasEnded()) {
            this.f2526b.mo9588e("ViewabilityTracker", "View is animating");
            j |= 8;
        }
        if (this.f2527c.getParent() == null) {
            this.f2526b.mo9588e("ViewabilityTracker", "No parent view found");
            j |= 16;
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.f2527c.getContext(), this.f2527c.getWidth());
        if (pxToDp < bVar.mo8416t()) {
            C1107r rVar = this.f2526b;
            rVar.mo9588e("ViewabilityTracker", "View has width (" + pxToDp + ") below threshold");
            j |= 32;
        }
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.f2527c.getContext(), this.f2527c.getHeight());
        if (pxToDp2 < bVar.mo8417u()) {
            C1107r rVar2 = this.f2526b;
            rVar2.mo9588e("ViewabilityTracker", "View has height (" + pxToDp2 + ") below threshold");
            j |= 64;
        }
        Point a = C1119g.m2526a(this.f2527c.getContext());
        Rect rect = new Rect(0, 0, a.x, a.y);
        int[] iArr = {-1, -1};
        this.f2527c.getLocationOnScreen(iArr);
        Rect rect2 = new Rect(iArr[0], iArr[1], iArr[0] + this.f2527c.getWidth(), iArr[1] + this.f2527c.getHeight());
        if (!Rect.intersects(rect, rect2)) {
            C1107r rVar3 = this.f2526b;
            rVar3.mo9588e("ViewabilityTracker", "Rect (" + rect2 + ") outside of screen's bounds (" + rect + ")");
            j |= 128;
        }
        Activity a2 = this.f2525a.mo9370ae().mo8944a();
        if (a2 != null && !C1160r.m2731a((View) this.f2527c, a2)) {
            this.f2526b.mo9588e("ViewabilityTracker", "View is not in top activity's view hierarchy");
            j |= 256;
        }
        C1107r rVar4 = this.f2526b;
        rVar4.mo9584b("ViewabilityTracker", "Returning flags: " + Long.toBinaryString(j));
        return j;
    }
}
