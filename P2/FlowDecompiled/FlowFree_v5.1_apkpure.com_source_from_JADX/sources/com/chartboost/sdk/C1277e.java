package com.chartboost.sdk;

import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.chartboost.sdk.C1275d;
import com.chartboost.sdk.C1279f;
import com.chartboost.sdk.Events.ChartboostError;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Libraries.CBUtility;
import com.chartboost.sdk.Model.C1228a;
import com.chartboost.sdk.Model.C1230c;
import com.chartboost.sdk.Model.C1236h;
import com.chartboost.sdk.Model.CBError;
import com.chartboost.sdk.Tracking.C1260a;
import com.chartboost.sdk.Tracking.C1266e;
import com.chartboost.sdk.impl.C1286a;
import com.chartboost.sdk.impl.C1342m1;
import com.chartboost.sdk.impl.C1344n;
import com.chartboost.sdk.impl.C1371s1;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.e */
public class C1277e {

    /* renamed from: a */
    final C1342m1 f2989a;

    /* renamed from: b */
    private final C1344n f2990b;

    /* renamed from: c */
    private final AtomicReference<C1236h> f2991c;

    /* renamed from: d */
    private final Handler f2992d;

    /* renamed from: e */
    C1371s1 f2993e = null;

    /* renamed from: f */
    private int f2994f = -1;

    /* renamed from: com.chartboost.sdk.e$a */
    class C1278a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1230c f2995a;

        /* renamed from: b */
        final /* synthetic */ Activity f2996b;

        C1278a(C1230c cVar, Activity activity) {
            this.f2995a = cVar;
            this.f2996b = activity;
        }

        public void run() {
            C1230c cVar = this.f2995a;
            cVar.f2736b = 4;
            C1228a aVar = cVar.f2751q;
            int i = 1;
            if (aVar.f2709b == 1) {
                i = 6;
            }
            Integer a = C1342m1.m3626a(aVar.f2723p);
            if (a != null) {
                i = a.intValue();
            }
            C1275d dVar = this.f2995a.f2742h;
            dVar.getClass();
            C1275d.C1276a aVar2 = new C1275d.C1276a(13);
            C1230c cVar2 = this.f2995a;
            aVar2.f2987c = cVar2;
            aVar2.f2986b = this.f2996b;
            C1277e.this.f2989a.mo10512a(i, cVar2, (Runnable) aVar2);
        }
    }

    public C1277e(C1342m1 m1Var, C1344n nVar, AtomicReference<C1236h> atomicReference, Handler handler) {
        this.f2989a = m1Var;
        this.f2990b = nVar;
        this.f2991c = atomicReference;
        this.f2992d = handler;
    }

    /* renamed from: c */
    private void m3302c(C1230c cVar) {
        int i;
        C1371s1 s1Var = this.f2993e;
        if (s1Var == null || s1Var.mo10604d() == cVar) {
            int i2 = 1;
            boolean z = cVar.f2736b != 2;
            cVar.f2736b = 2;
            Activity e = cVar.f2742h.mo10306e();
            CBError.CBImpressionError cBImpressionError = e == null ? CBError.CBImpressionError.NO_HOST_ACTIVITY : null;
            if (cBImpressionError == null) {
                cBImpressionError = cVar.mo10083a((RelativeLayout) null);
            }
            if (cBImpressionError != null) {
                CBLogging.m2905b("CBViewController", "Unable to create the view while trying th display the impression");
                cVar.mo10085a(cBImpressionError);
                return;
            }
            if (this.f2993e == null) {
                C1371s1 s1Var2 = (C1371s1) C1284h.m3343a().mo10361a(new C1371s1(e, cVar));
                this.f2993e = s1Var2;
                e.addContentView(s1Var2, new FrameLayout.LayoutParams(-1, -1));
            }
            CBUtility.m2914a(e, cVar.f2751q.f2709b, this.f2991c.get());
            if (this.f2994f == -1 && ((i = cVar.f2735a) == 1 || i == 2)) {
                this.f2994f = e.getWindow().getDecorView().getSystemUiVisibility();
                Chartboost.setActivityAttrs(e);
            }
            this.f2993e.mo10606f();
            CBLogging.m2907c("CBViewController", "Displaying the impression");
            C1371s1 s1Var3 = this.f2993e;
            cVar.f2759y = s1Var3;
            if (z) {
                if (cVar.f2751q.f2709b == 0) {
                    s1Var3.mo10602b().mo10529a(this.f2989a, cVar.f2751q);
                }
                C1228a aVar = cVar.f2751q;
                if (aVar.f2709b == 1) {
                    i2 = 6;
                }
                Integer a = C1342m1.m3626a(aVar.f2723p);
                if (a != null) {
                    i2 = a.intValue();
                }
                cVar.mo10099o();
                C1275d dVar = cVar.f2742h;
                dVar.getClass();
                C1275d.C1276a aVar2 = new C1275d.C1276a(12);
                aVar2.f2987c = cVar;
                this.f2989a.mo10513a(i2, cVar, (Runnable) aVar2, this);
                this.f2990b.mo10518a();
                return;
            }
            return;
        }
        C1266e.m3223e(new C1260a("show_ad_already_visible_error", "", cVar.mo10092e().mo10365a(), cVar.mo10094g()));
        CBLogging.m2905b("CBViewController", "Impression already visible");
        cVar.mo10085a(CBError.CBImpressionError.IMPRESSION_ALREADY_VISIBLE);
    }

    /* renamed from: a */
    public void mo10319a(C1230c cVar) {
        CBLogging.m2907c("CBViewController", "Dismissing impression");
        C1278a aVar = new C1278a(cVar, cVar.f2742h.mo10306e());
        if (cVar.f2731A) {
            cVar.mo10086a((Runnable) aVar);
        } else {
            aVar.run();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10322b(C1230c cVar) {
        if (cVar.f2736b != 0) {
            m3302c(cVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo10323d(C1230c cVar) {
        RelativeLayout f = cVar.mo10093f();
        CBError.CBImpressionError a = cVar.mo10083a(f);
        C1279f.C1281b j = cVar.mo10096j();
        if (f == null || j == null) {
            cVar.mo10085a(CBError.CBImpressionError.ERROR_DISPLAYING_VIEW);
        } else if (a != null) {
            cVar.mo10085a(a);
        } else {
            cVar.f2736b = 2;
            f.addView(j);
            this.f2990b.mo10518a();
        }
    }

    /* renamed from: e */
    public void mo10324e(C1230c cVar) {
        CBLogging.m2907c("CBViewController", "Removing impression");
        cVar.f2736b = 5;
        cVar.mo10088b();
        String str = null;
        this.f2993e = null;
        this.f2990b.mo10523c();
        C1228a aVar = cVar.f2751q;
        if (aVar != null) {
            str = aVar.f2716i;
        }
        Handler handler = this.f2992d;
        C1286a aVar2 = cVar.f2737c;
        aVar2.getClass();
        handler.post(new C1286a.C1287a(3, cVar.f2747m, (CBError.CBImpressionError) null, (ChartboostError) null, true, str));
        if (cVar.mo10082I()) {
            Handler handler2 = this.f2992d;
            C1286a aVar3 = cVar.f2737c;
            aVar3.getClass();
            handler2.post(new C1286a.C1287a(2, cVar.f2747m, (CBError.CBImpressionError) null, (ChartboostError) null, true, str));
        }
        mo10321a(cVar.f2742h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo10325f(C1230c cVar) {
        CBLogging.m2907c("CBViewController", "Removing impression silently");
        cVar.mo10084a();
        try {
            ((ViewGroup) this.f2993e.getParent()).removeView(this.f2993e);
        } catch (Exception e) {
            CBLogging.m2904a("CBViewController", "Exception removing impression silently", e);
        }
        this.f2993e = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10320a(C1230c cVar, Activity activity) {
        C1275d dVar = cVar.f2742h;
        dVar.getClass();
        C1275d.C1276a aVar = new C1275d.C1276a(14);
        aVar.f2987c = cVar;
        this.f2992d.post(aVar);
        cVar.mo10104t();
        CBUtility.m2919b(activity, cVar.f2751q.f2709b, this.f2991c.get());
        if (this.f2994f != -1) {
            int i = cVar.f2735a;
            if (i == 1 || i == 2) {
                activity.getWindow().getDecorView().setSystemUiVisibility(this.f2994f);
                this.f2994f = -1;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10321a(C1275d dVar) {
        CBLogging.m2907c("CBViewController", "Attempting to close impression activity");
        Activity e = dVar.mo10306e();
        if (e != null && (e instanceof CBImpressionActivity)) {
            CBLogging.m2907c("CBViewController", "Closing impression activity");
            dVar.mo10296a();
            e.finish();
        }
    }

    /* renamed from: a */
    public C1371s1 mo10318a() {
        return this.f2993e;
    }
}
