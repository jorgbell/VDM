package com.applovin.impl.mediation.ads;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.mediation.p021a.C0734b;
import com.applovin.impl.mediation.p023c.C0788c;
import com.applovin.impl.sdk.C0970d;
import com.applovin.impl.sdk.C1062k;
import com.applovin.impl.sdk.C1107r;
import com.applovin.impl.sdk.C1175w;
import com.applovin.impl.sdk.C1176x;
import com.applovin.impl.sdk.p037c.C0964a;
import com.applovin.impl.sdk.p039e.C1042y;
import com.applovin.impl.sdk.utils.C1113b;
import com.applovin.impl.sdk.utils.C1124k;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.impl.sdk.utils.C1163s;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.TimeUnit;

public class MaxAdViewImpl extends C0761a implements C0970d.C0972a, C1176x.C1179a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Activity f781a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final MaxAdView f782b;

    /* renamed from: c */
    private final View f783c;

    /* renamed from: d */
    private long f784d = Long.MAX_VALUE;

    /* renamed from: e */
    private C0734b f785e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f786f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final C0746a f787g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final C0748c f788h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final C0970d f789i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public final C1175w f790j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final C1176x f791k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public final Object f792l = new Object();
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C0734b f793m = null;

    /* renamed from: n */
    private boolean f794n;

    /* renamed from: o */
    private boolean f795o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f796p = false;

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$a */
    private class C0746a extends C0747b {
        private C0746a() {
            super();
        }

        public void onAdLoadFailed(String str, int i) {
            C1124k.m2614a(MaxAdViewImpl.this.adListener, str, i);
            MaxAdViewImpl.this.m977a(i);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f796p) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                C1107r rVar = maxAdViewImpl.logger;
                String str = maxAdViewImpl.tag;
                rVar.mo9584b(str, "Pre-cache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                MaxAdViewImpl.this.sdk.mo9327C().destroyAd(maxAd);
            } else if (maxAd instanceof C0734b) {
                C0734b bVar = (C0734b) maxAd;
                bVar.mo8468c(MaxAdViewImpl.this.f786f);
                MaxAdViewImpl.this.m981a(bVar);
                if (bVar.mo8422z()) {
                    long A = bVar.mo8409A();
                    C1107r z = MaxAdViewImpl.this.sdk.mo9411z();
                    String str2 = MaxAdViewImpl.this.tag;
                    z.mo9584b(str2, "Scheduling banner ad refresh " + A + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                    MaxAdViewImpl.this.f789i.mo9142a(A);
                }
                C1124k.m2611a(MaxAdViewImpl.this.adListener, maxAd);
            } else {
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                C1107r rVar2 = maxAdViewImpl2.logger;
                String str3 = maxAdViewImpl2.tag;
                rVar2.mo9588e(str3, "Not a MediatedAdViewAd received: " + maxAd);
                onAdLoadFailed(MaxAdViewImpl.this.adUnitId, -5201);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$b */
    private abstract class C0747b implements MaxAdListener, MaxAdViewAdListener {
        private C0747b() {
        }

        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f793m)) {
                C1124k.m2632d(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f793m)) {
                if (MaxAdViewImpl.this.f793m.mo8410B()) {
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                C1124k.m2636h(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdDisplayFailed(MaxAd maxAd, int i) {
            if (maxAd.equals(MaxAdViewImpl.this.f793m)) {
                C1124k.m2612a(MaxAdViewImpl.this.adListener, maxAd, i);
            }
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f793m)) {
                C1124k.m2626b(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f793m)) {
                if (MaxAdViewImpl.this.f793m.mo8410B()) {
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                C1124k.m2635g(MaxAdViewImpl.this.adListener, maxAd);
            }
        }

        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.f793m)) {
                C1124k.m2630c(MaxAdViewImpl.this.adListener, maxAd);
            }
        }
    }

    /* renamed from: com.applovin.impl.mediation.ads.MaxAdViewImpl$c */
    private class C0748c extends C0747b {
        private C0748c() {
            super();
        }

        public void onAdLoadFailed(String str, int i) {
            MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
            C1107r rVar = maxAdViewImpl.logger;
            String str2 = maxAdViewImpl.tag;
            rVar.mo9584b(str2, "Failed to pre-cache ad for refresh with error code " + i);
            MaxAdViewImpl.this.m977a(i);
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.f796p) {
                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                C1107r rVar = maxAdViewImpl.logger;
                String str = maxAdViewImpl.tag;
                rVar.mo9584b(str, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                MaxAdViewImpl.this.sdk.mo9327C().destroyAd(maxAd);
                return;
            }
            MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
            maxAdViewImpl2.logger.mo9584b(maxAdViewImpl2.tag, "Successfully pre-cached ad for refresh");
            MaxAdViewImpl.this.m991a(maxAd);
        }
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, C1062k kVar, Activity activity) {
        super(str, maxAdFormat, "MaxAdView", kVar);
        if (activity != null) {
            this.f781a = activity;
            this.f782b = maxAdView;
            this.f783c = view;
            this.f787g = new C0746a();
            this.f788h = new C0748c();
            this.f789i = new C0970d(kVar, this);
            this.f790j = new C1175w(maxAdView, kVar);
            this.f791k = new C1176x(maxAdView, kVar, this);
            C1107r rVar = this.logger;
            String str2 = this.tag;
            rVar.mo9584b(str2, "Created new MaxAdView (" + this + ")");
            return;
        }
        throw new IllegalArgumentException("No activity specified");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m976a() {
        C0734b bVar;
        MaxAdView maxAdView = this.f782b;
        if (maxAdView != null) {
            C1113b.m2506a(maxAdView, this.f783c);
        }
        this.f791k.mo9726a();
        synchronized (this.f792l) {
            bVar = this.f793m;
        }
        if (bVar != null) {
            this.sdk.mo9376ak().mo9441b(bVar);
            this.sdk.mo9327C().destroyAd(bVar);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m977a(int i) {
        if (this.sdk.mo9381b(C0964a.f1556o).contains(String.valueOf(i))) {
            C1107r z = this.sdk.mo9411z();
            String str = this.tag;
            z.mo9584b(str, "Ignoring banner ad refresh for error code '" + i + "'...");
            return;
        }
        this.f794n = true;
        long longValue = ((Long) this.sdk.mo9350a(C0964a.f1555n)).longValue();
        if (longValue >= 0) {
            C1107r z2 = this.sdk.mo9411z();
            String str2 = this.tag;
            z2.mo9584b(str2, "Scheduling failed banner ad refresh " + longValue + " milliseconds from now for '" + this.adUnitId + "'...");
            this.f789i.mo9142a(longValue);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m978a(long j) {
        if (C1160r.m2728a(j, ((Long) this.sdk.mo9350a(C0964a.f1565x)).longValue())) {
            C1107r rVar = this.logger;
            String str = this.tag;
            rVar.mo9584b(str, "Undesired flags matched - current: " + Long.toBinaryString(j) + ", undesired: " + Long.toBinaryString(j));
            this.logger.mo9584b(this.tag, "Waiting for refresh timer to manually fire request");
            this.f794n = true;
            return;
        }
        this.logger.mo9584b(this.tag, "No undesired viewability flags matched - scheduling viewability");
        this.f794n = false;
        m994b();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m979a(AnimatorListenerAdapter animatorListenerAdapter) {
        C0734b bVar = this.f793m;
        if (bVar == null || bVar.mo8414r() == null) {
            animatorListenerAdapter.onAnimationEnd((Animator) null);
            return;
        }
        View r = this.f793m.mo8414r();
        r.animate().alpha(0.0f).setDuration(((Long) this.sdk.mo9350a(C0964a.f1562u)).longValue()).setListener(animatorListenerAdapter).start();
    }

    /* renamed from: a */
    private void m980a(View view, C0734b bVar) {
        int p = bVar.mo8412p();
        int q = bVar.mo8413q();
        int i = -1;
        int dpToPx = p == -1 ? -1 : AppLovinSdkUtils.dpToPx(view.getContext(), p);
        if (q != -1) {
            i = AppLovinSdkUtils.dpToPx(view.getContext(), q);
        }
        int height = this.f782b.getHeight();
        int width = this.f782b.getWidth();
        if ((height > 0 && height < i) || (width > 0 && width < dpToPx)) {
            int pxToDp = AppLovinSdkUtils.pxToDp(view.getContext(), height);
            C1107r.m2483h("AppLovinSdk", "\n**************************************************\n`MaxAdView` size " + AppLovinSdkUtils.pxToDp(view.getContext(), width) + "x" + pxToDp + " dp smaller than required size: " + p + "x" + q + " dp\n**************************************************\n");
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(dpToPx, i);
        } else {
            layoutParams.width = dpToPx;
            layoutParams.height = i;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            this.logger.mo9584b(this.tag, "Pinning ad view to MAX ad view with width: " + dpToPx + " and height: " + i + ".");
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int addRule : C1163s.m2769a(this.f782b.getGravity(), 10, 14)) {
                layoutParams2.addRule(addRule);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m981a(final C0734b bVar) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                String str;
                C1107r rVar;
                String str2;
                final View r = bVar.mo8414r();
                if (r != null) {
                    final MaxAdView c = MaxAdViewImpl.this.f782b;
                    if (c != null) {
                        MaxAdViewImpl.this.m979a((AnimatorListenerAdapter) new AnimatorListenerAdapter() {
                            public void onAnimationEnd(Animator animator) {
                                super.onAnimationEnd(animator);
                                MaxAdViewImpl.this.m976a();
                                C07422 r4 = C07422.this;
                                MaxAdViewImpl.this.mo8514a(bVar);
                                MaxAdViewImpl.this.sdk.mo9376ak().mo9440a((Object) bVar);
                                if (bVar.mo8420x()) {
                                    MaxAdViewImpl.this.f791k.mo9727a(bVar);
                                }
                                C07422 r42 = C07422.this;
                                MaxAdViewImpl.this.m983a(bVar, r, c);
                                synchronized (MaxAdViewImpl.this.f792l) {
                                    C07422 r0 = C07422.this;
                                    C0734b unused = MaxAdViewImpl.this.f793m = bVar;
                                }
                                MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                                maxAdViewImpl.logger.mo9584b(maxAdViewImpl.tag, "Scheduling impression for ad manually...");
                                MaxAdViewImpl.this.sdk.mo9327C().processRawAdImpressionPostback(bVar);
                                AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                                    public void run() {
                                        long a = MaxAdViewImpl.this.f790j.mo9725a(bVar);
                                        if (!bVar.mo8420x()) {
                                            C07422 r2 = C07422.this;
                                            MaxAdViewImpl.this.m982a(bVar, a);
                                        }
                                        MaxAdViewImpl.this.m978a(a);
                                    }
                                }, bVar.mo8415s());
                            }
                        });
                        return;
                    }
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    rVar = maxAdViewImpl.logger;
                    str2 = maxAdViewImpl.tag;
                    str = "Max ad view does not have a parent View";
                } else {
                    MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                    rVar = maxAdViewImpl2.logger;
                    str2 = maxAdViewImpl2.tag;
                    str = "Max ad does not have a loaded ad view";
                }
                rVar.mo9588e(str2, str);
                MaxAdViewImpl.this.f787g.onAdDisplayFailed(bVar, -5201);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m982a(C0734b bVar, long j) {
        this.logger.mo9584b(this.tag, "Scheduling viewability impression for ad...");
        this.sdk.mo9327C().processViewabilityAdImpressionPostback(bVar, j);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m983a(C0734b bVar, View view, MaxAdView maxAdView) {
        view.setAlpha(0.0f);
        if (bVar.mo8411C() != Long.MAX_VALUE) {
            this.f783c.setBackgroundColor((int) bVar.mo8411C());
        } else {
            long j = this.f784d;
            if (j != Long.MAX_VALUE) {
                this.f783c.setBackgroundColor((int) j);
            } else {
                this.f783c.setBackgroundColor(0);
            }
        }
        maxAdView.addView(view);
        m980a(view, bVar);
        view.animate().alpha(1.0f).setDuration(((Long) this.sdk.mo9350a(C0964a.f1561t)).longValue()).start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m991a(MaxAd maxAd) {
        this.sdk.mo9376ak().mo9440a((Object) maxAd);
        if (this.f795o) {
            this.f795o = false;
            C1107r rVar = this.logger;
            String str = this.tag;
            rVar.mo9584b(str, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            this.f787g.onAdLoaded(maxAd);
            return;
        }
        this.f785e = (C0734b) maxAd;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m992a(final MaxAdListener maxAdListener) {
        if (m999d()) {
            C1107r.m2484i(this.tag, "Unable to load new ad; ad is already destroyed");
            C1124k.m2614a(this.adListener, this.adUnitId, -1);
            return;
        }
        AppLovinSdkUtils.runOnUiThread(true, new Runnable() {
            public void run() {
                if (MaxAdViewImpl.this.f793m != null) {
                    long a = MaxAdViewImpl.this.f790j.mo9725a(MaxAdViewImpl.this.f793m);
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.loadRequestBuilder.mo9553a("visible_ad_ad_unit_id", maxAdViewImpl.f793m.getAdUnitId()).mo9553a("viewability_flags", String.valueOf(a));
                } else {
                    MaxAdViewImpl.this.loadRequestBuilder.mo9552a("visible_ad_ad_unit_id").mo9552a("viewability_flags");
                }
                MaxAdViewImpl.this.loadRequestBuilder.mo9553a("viewport_width", String.valueOf(AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f782b.getContext(), MaxAdViewImpl.this.f782b.getWidth()))).mo9553a("viewport_height", String.valueOf(AppLovinSdkUtils.pxToDp(MaxAdViewImpl.this.f782b.getContext(), MaxAdViewImpl.this.f782b.getHeight())));
                MaxAdViewImpl maxAdViewImpl2 = MaxAdViewImpl.this;
                C1107r rVar = maxAdViewImpl2.logger;
                String str = maxAdViewImpl2.tag;
                rVar.mo9584b(str, "Loading banner ad for '" + MaxAdViewImpl.this.adUnitId + "' and notifying " + maxAdListener + "...");
                MediationServiceImpl C = MaxAdViewImpl.this.sdk.mo9327C();
                MaxAdViewImpl maxAdViewImpl3 = MaxAdViewImpl.this;
                C.loadAd(maxAdViewImpl3.adUnitId, maxAdViewImpl3.adFormat, maxAdViewImpl3.loadRequestBuilder.mo9554a(), MaxAdViewImpl.this.f781a, maxAdListener);
            }
        });
    }

    /* renamed from: b */
    private void m994b() {
        if (m997c()) {
            long longValue = ((Long) this.sdk.mo9350a(C0964a.f1566y)).longValue();
            C1107r rVar = this.logger;
            String str = this.tag;
            rVar.mo9584b(str, "Scheduling refresh precache request in " + TimeUnit.MICROSECONDS.toSeconds(longValue) + " seconds...");
            this.sdk.mo9340Q().mo9267a(new C1042y(this.sdk, new Runnable() {
                public void run() {
                    MaxAdViewImpl maxAdViewImpl = MaxAdViewImpl.this;
                    maxAdViewImpl.m992a((MaxAdListener) maxAdViewImpl.f788h);
                }
            }), C0788c.m1108a(this.adFormat), longValue);
        }
    }

    /* renamed from: c */
    private boolean m997c() {
        return ((Long) this.sdk.mo9350a(C0964a.f1566y)).longValue() > 0;
    }

    /* renamed from: d */
    private boolean m999d() {
        boolean z;
        synchronized (this.f792l) {
            z = this.f796p;
        }
        return z;
    }

    public void destroy() {
        m976a();
        if (this.f785e != null) {
            this.sdk.mo9376ak().mo9441b(this.f785e);
            this.sdk.mo9327C().destroyAd(this.f785e);
        }
        synchronized (this.f792l) {
            this.f796p = true;
        }
        this.f789i.mo9145c();
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public String getPlacement() {
        return this.f786f;
    }

    public void loadAd() {
        C1107r rVar = this.logger;
        String str = this.tag;
        rVar.mo9584b(str, "" + this + " Loading ad for " + this.adUnitId + "...");
        if (m999d()) {
            C1107r.m2484i(this.tag, "Unable to load new ad; ad is already destroyed");
            C1124k.m2614a(this.adListener, this.adUnitId, -1);
        } else if (!((Boolean) this.sdk.mo9350a(C0964a.f1567z)).booleanValue() || !this.f789i.mo9143a()) {
            m992a((MaxAdListener) this.f787g);
        } else {
            String str2 = this.tag;
            C1107r.m2484i(str2, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.f789i.mo9144b()) + " seconds.");
        }
    }

    public void onAdRefresh() {
        String str;
        String str2;
        C1107r rVar;
        this.f795o = false;
        if (this.f785e != null) {
            C1107r rVar2 = this.logger;
            String str3 = this.tag;
            rVar2.mo9584b(str3, "Refreshing for cached ad: " + this.f785e.getAdUnitId() + "...");
            this.f787g.onAdLoaded(this.f785e);
            this.f785e = null;
            return;
        }
        if (!m997c()) {
            rVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network...";
        } else if (this.f794n) {
            rVar = this.logger;
            str2 = this.tag;
            str = "Refreshing ad from network due to viewability requirements not met for refresh request...";
        } else {
            this.logger.mo9588e(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            this.f795o = true;
            return;
        }
        rVar.mo9584b(str2, str);
        loadAd();
    }

    public void onLogVisibilityImpression() {
        m982a(this.f793m, this.f790j.mo9725a(this.f793m));
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.mo9350a(C0964a.f1560s)).booleanValue() && this.f789i.mo9143a()) {
            if (C1163s.m2767a(i)) {
                this.logger.mo9584b(this.tag, "Ad view visible");
                this.f789i.mo9149g();
                return;
            }
            this.logger.mo9584b(this.tag, "Ad view hidden");
            this.f789i.mo9148f();
        }
    }

    public void setPlacement(String str) {
        this.f786f = str;
    }

    public void setPublisherBackgroundColor(int i) {
        this.f784d = (long) i;
    }

    public void startAutoRefresh() {
        this.f789i.mo9147e();
        C1107r rVar = this.logger;
        String str = this.tag;
        rVar.mo9584b(str, "Resumed auto-refresh with remaining time: " + this.f789i.mo9144b());
    }

    public void stopAutoRefresh() {
        if (this.f793m != null) {
            C1107r rVar = this.logger;
            String str = this.tag;
            rVar.mo9584b(str, "Pausing auto-refresh with remaining time: " + this.f789i.mo9144b());
            this.f789i.mo9146d();
            return;
        }
        C1107r.m2483h(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
    }

    public String toString() {
        return "MaxAdView{adUnitId='" + this.adUnitId + '\'' + ", adListener=" + this.adListener + ", isDestroyed=" + m999d() + '}';
    }
}
