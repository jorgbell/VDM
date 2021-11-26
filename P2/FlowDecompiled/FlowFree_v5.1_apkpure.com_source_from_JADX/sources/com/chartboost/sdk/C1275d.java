package com.chartboost.sdk;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.chartboost.sdk.Chartboost;
import com.chartboost.sdk.Libraries.C1225k;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Networking.C1248h;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1317h1;
import com.chartboost.sdk.impl.C1371s1;

/* renamed from: com.chartboost.sdk.d */
public class C1275d {

    /* renamed from: a */
    private final C1414j f2977a;

    /* renamed from: b */
    private final Handler f2978b;

    /* renamed from: c */
    public final C1277e f2979c;

    /* renamed from: d */
    CBImpressionActivity f2980d = null;

    /* renamed from: e */
    C1230c f2981e = null;

    /* renamed from: f */
    private boolean f2982f = false;

    /* renamed from: g */
    private C1225k f2983g;

    /* renamed from: h */
    private Context f2984h;

    /* renamed from: com.chartboost.sdk.d$a */
    public class C1276a implements Runnable {

        /* renamed from: a */
        public final int f2985a;

        /* renamed from: b */
        Activity f2986b = null;

        /* renamed from: c */
        public C1230c f2987c = null;

        public C1276a(int i) {
            this.f2985a = i;
        }

        public void run() {
            try {
                switch (this.f2985a) {
                    case 7:
                        C1275d.this.mo10303c();
                        return;
                    case 9:
                        C1275d.this.mo10308e(this.f2987c);
                        return;
                    case 10:
                        if (this.f2987c.mo10110z()) {
                            this.f2987c.mo10097k().mo10348m();
                            return;
                        }
                        return;
                    case 11:
                        C1277e d = C1275d.this.mo10304d();
                        C1230c cVar = this.f2987c;
                        if (cVar.f2736b == 2 && d != null) {
                            d.mo10319a(cVar);
                            return;
                        }
                        return;
                    case 12:
                        this.f2987c.mo10100p();
                        return;
                    case 13:
                        C1275d.this.f2979c.mo10320a(this.f2987c, this.f2986b);
                        return;
                    case 14:
                        C1275d.this.f2979c.mo10324e(this.f2987c);
                        return;
                    default:
                        return;
                }
            } catch (Exception e) {
                CBLogging.m2905b("CBUIManager", "run (" + this.f2985a + "): " + e.toString());
            }
        }
    }

    public C1275d(Context context, C1248h hVar, C1414j jVar, Handler handler, C1277e eVar) {
        this.f2984h = context;
        this.f2977a = jVar;
        this.f2978b = handler;
        this.f2979c = eVar;
    }

    /* renamed from: c */
    private void m3279c(C1230c cVar) {
        this.f2979c.mo10323d(cVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10297a(CBImpressionActivity cBImpressionActivity) {
        C1317h1.m3506a("CBUIManager.setImpressionActivity", (Object) cBImpressionActivity);
        if (this.f2980d == null) {
            this.f2980d = cBImpressionActivity;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C1225k mo10300b(Activity activity) {
        C1225k kVar = this.f2983g;
        if (kVar == null || kVar.f2694a != activity.hashCode()) {
            this.f2983g = new C1225k(activity);
        }
        return this.f2983g;
    }

    /* renamed from: d */
    public C1277e mo10304d() {
        if (mo10306e() == null) {
            return null;
        }
        return this.f2979c;
    }

    /* renamed from: e */
    public Activity mo10306e() {
        return this.f2980d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public C1230c mo10309f() {
        C1371s1 s1Var;
        C1277e d = mo10304d();
        if (d == null) {
            s1Var = null;
        } else {
            s1Var = d.mo10318a();
        }
        if (s1Var == null || !s1Var.mo10605e()) {
            return null;
        }
        return s1Var.mo10604d();
    }

    /* renamed from: g */
    public boolean mo10310g() {
        return mo10309f() != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo10311h() {
        C1317h1.m3505a("CBUIManager.onBackPressedCallback");
        if (!C1274c.m3270a() || !this.f2982f) {
            return false;
        }
        this.f2982f = false;
        mo10312i();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public boolean mo10312i() {
        C1317h1.m3505a("CBUIManager.onBackPressedImpl");
        return m3278b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public void mo10313j() {
        C1317h1.m3505a("CBUIManager.onCreateImpl");
        mo10316m();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public void mo10314k() {
        C1317h1.m3507a("CBUIManager.onPauseImpl", (String) null);
        C1230c f = mo10309f();
        if (f != null) {
            f.mo10105u();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: l */
    public void mo10315l() {
        C1317h1.m3507a("CBUIManager.onResumeImpl", (String) null);
        C1230c f = mo10309f();
        if (f != null) {
            f.mo10108x();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m */
    public void mo10316m() {
        C1317h1.m3505a("CBUIManager.onStop");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo10302c(Activity activity) {
        C1230c cVar;
        C1317h1.m3506a("CBUIManager.onDestroyImpl", (Object) activity);
        C1230c f = mo10309f();
        if (f == null && activity == this.f2980d && (cVar = this.f2981e) != null) {
            f = cVar;
        }
        C1277e d = mo10304d();
        if (!(d == null || f == null)) {
            d.mo10324e(f);
        }
        this.f2981e = null;
    }

    /* renamed from: e */
    public void mo10308e(C1230c cVar) {
        Intent intent = new Intent(this.f2984h, CBImpressionActivity.class);
        intent.putExtra("isChartboost", true);
        intent.addFlags(268435456);
        try {
            this.f2984h.startActivity(intent);
            this.f2982f = true;
        } catch (ActivityNotFoundException unused) {
            CBLogging.m2905b("CBUIManager", "Please add CBImpressionActivity in AndroidManifest.xml following README.md instructions.");
            this.f2981e = null;
            cVar.mo10085a(CBError.CBImpressionError.ACTIVITY_MISSING_IN_MANIFEST);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10296a() {
        C1317h1.m3505a("CBUIManager.clearImpressionActivity");
        this.f2980d = null;
    }

    /* renamed from: b */
    public void mo10301b(C1230c cVar) {
        C1317h1.m3506a("CBUIManager.queueDisplayView", (Object) cVar);
        if (cVar.mo10095i().booleanValue()) {
            m3279c(cVar);
        } else {
            m3280d(cVar);
        }
    }

    /* renamed from: a */
    private boolean m3276a(Activity activity) {
        return this.f2980d == activity;
    }

    /* renamed from: d */
    private void m3280d(C1230c cVar) {
        if (mo10310g()) {
            cVar.mo10085a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        } else if (this.f2980d != null) {
            this.f2979c.mo10322b(cVar);
        } else {
            C1230c cVar2 = this.f2981e;
            if (cVar2 == null || cVar2 == cVar) {
                this.f2981e = cVar;
                C1272a aVar = C1418k.f3534d;
                if (aVar != null) {
                    int i = cVar.f2735a;
                    if (i == 1 || i == 2) {
                        aVar.willDisplayVideo(cVar.f2747m);
                    } else if (i == 0) {
                        aVar.willDisplayInterstitial(cVar.f2747m);
                    }
                }
                if (C1418k.f3535e != null) {
                    C1276a aVar2 = new C1276a(9);
                    aVar2.f2987c = cVar;
                    this.f2978b.postDelayed(aVar2, (long) 1);
                    return;
                }
                mo10308e(cVar);
                return;
            }
            cVar.mo10085a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
        }
    }

    /* renamed from: a */
    private boolean m3277a(C1225k kVar) {
        if (kVar == null) {
            return this.f2980d == null;
        }
        return kVar.mo10068a(this.f2980d);
    }

    /* renamed from: b */
    private boolean m3278b() {
        C1317h1.m3505a("CBUIManager.closeImpressionImpl");
        C1230c f = mo10309f();
        if (f == null || f.f2736b != 2) {
            return false;
        }
        if (f.mo10101q()) {
            return true;
        }
        C1414j.m3873e(new C1276a(7));
        return true;
    }

    /* renamed from: a */
    public void mo10298a(C1230c cVar) {
        int i = cVar.f2736b;
        if (i == 2) {
            C1277e d = mo10304d();
            if (d != null) {
                d.mo10319a(cVar);
            }
        } else if (cVar.f2751q.f2709b == 1 && i == 1) {
            C1277e d2 = mo10304d();
            if (d2 != null) {
                d2.mo10324e(cVar);
            }
            C1266e.m3223e(new C1260a("show_close_before_template_show_error", "", cVar.f2737c.f3036b, cVar.f2747m));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo10307e(Activity activity) {
        C1225k b = mo10300b(activity);
        C1317h1.m3506a("CBUIManager.onStopImpl", (Object) b);
        C1230c f = mo10309f();
        if (f != null && f.f2751q.f2709b == 0) {
            C1277e d = mo10304d();
            if (m3277a(b) && d != null) {
                d.mo10325f(f);
                this.f2981e = f;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo10303c() {
        C1230c f = mo10309f();
        if (f == null) {
            return false;
        }
        f.f2734D = true;
        mo10298a(f);
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000b, code lost:
        if (r1 != 3) goto L_0x0049;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo10299a(android.app.Activity r4, com.chartboost.sdk.Model.C1230c r5) {
        /*
            r3 = this;
            r0 = 1
            if (r5 == 0) goto L_0x0049
            int r1 = r5.f2736b
            if (r1 == r0) goto L_0x0046
            r2 = 2
            if (r1 == r2) goto L_0x000e
            r4 = 3
            if (r1 == r4) goto L_0x0046
            goto L_0x0049
        L_0x000e:
            boolean r1 = r5.mo10078E()
            if (r1 != 0) goto L_0x0049
            com.chartboost.sdk.Chartboost$CBFramework r1 = com.chartboost.sdk.C1418k.f3535e
            if (r1 == 0) goto L_0x0024
            boolean r1 = r1.doesWrapperUseCustomBackgroundingBehavior()
            if (r1 == 0) goto L_0x0024
            boolean r4 = r4 instanceof com.chartboost.sdk.CBImpressionActivity
            if (r4 != 0) goto L_0x0024
            r4 = 0
            return r4
        L_0x0024:
            com.chartboost.sdk.e r4 = r3.mo10304d()
            if (r4 == 0) goto L_0x0049
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error onActivityStart "
            r1.append(r2)
            int r2 = r5.f2736b
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "CBUIManager"
            com.chartboost.sdk.Libraries.CBLogging.m2905b(r2, r1)
            r4.mo10324e(r5)
            goto L_0x0049
        L_0x0046:
            r3.mo10301b((com.chartboost.sdk.Model.C1230c) r5)
        L_0x0049:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.chartboost.sdk.C1275d.mo10299a(android.app.Activity, com.chartboost.sdk.Model.c):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10305d(Activity activity) {
        C1317h1.m3506a("CBUIManager.onStartImpl", (Object) activity);
        boolean z = activity instanceof CBImpressionActivity;
        if (z) {
            mo10297a((CBImpressionActivity) activity);
        }
        Chartboost.CBFramework cBFramework = C1418k.f3535e;
        boolean z2 = cBFramework != null && cBFramework.doesWrapperUseCustomBackgroundingBehavior();
        if (activity == null) {
            return;
        }
        if (z2 || m3276a(activity)) {
            if (z) {
                this.f2982f = false;
            }
            if (mo10299a(activity, this.f2981e)) {
                this.f2981e = null;
            }
            this.f2977a.mo10707a(activity);
            C1230c f = mo10309f();
            if (f != null) {
                f.mo10109y();
            }
        }
    }
}
