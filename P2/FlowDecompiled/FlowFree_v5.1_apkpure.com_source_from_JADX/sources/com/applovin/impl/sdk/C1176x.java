package com.applovin.impl.sdk;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewTreeObserver;
import com.applovin.impl.mediation.p021a.C0734b;
import com.applovin.impl.sdk.p037c.C0965b;
import com.applovin.impl.sdk.utils.C1160r;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.sdk.x */
public class C1176x {

    /* renamed from: a */
    private final C1062k f2528a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C1107r f2529b;

    /* renamed from: c */
    private final Object f2530c = new Object();

    /* renamed from: d */
    private final Rect f2531d = new Rect();

    /* renamed from: e */
    private final Handler f2532e;

    /* renamed from: f */
    private final Runnable f2533f;

    /* renamed from: g */
    private final ViewTreeObserver.OnPreDrawListener f2534g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final WeakReference<MaxAdView> f2535h;

    /* renamed from: i */
    private WeakReference<ViewTreeObserver> f2536i = new WeakReference<>((Object) null);
    /* access modifiers changed from: private */

    /* renamed from: j */
    public WeakReference<View> f2537j = new WeakReference<>((Object) null);

    /* renamed from: k */
    private int f2538k;

    /* renamed from: l */
    private long f2539l;

    /* renamed from: m */
    private long f2540m = Long.MIN_VALUE;

    /* renamed from: com.applovin.impl.sdk.x$a */
    public interface C1179a {
        void onLogVisibilityImpression();
    }

    public C1176x(MaxAdView maxAdView, C1062k kVar, C1179a aVar) {
        this.f2528a = kVar;
        this.f2529b = kVar.mo9411z();
        this.f2532e = new Handler(Looper.getMainLooper());
        this.f2535h = new WeakReference<>(maxAdView);
        final WeakReference weakReference = new WeakReference(aVar);
        this.f2533f = new Runnable() {
            public void run() {
                MaxAdView maxAdView = (MaxAdView) C1176x.this.f2535h.get();
                View view = (View) C1176x.this.f2537j.get();
                if (maxAdView != null && view != null) {
                    if (C1176x.this.m2808b(maxAdView, view)) {
                        C1176x.this.f2529b.mo9584b("VisibilityTracker", "View met visibility requirements. Logging visibility impression..");
                        C1176x.this.mo9726a();
                        C1179a aVar = (C1179a) weakReference.get();
                        if (aVar != null) {
                            aVar.onLogVisibilityImpression();
                            return;
                        }
                        return;
                    }
                    C1176x.this.m2807b();
                }
            }
        };
        this.f2534g = new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                C1176x.this.m2807b();
                C1176x.this.m2810c();
                return true;
            }
        };
    }

    /* renamed from: a */
    private void m2803a(View view) {
        View a = C1160r.m2704a((View) this.f2535h.get());
        if (a == null) {
            a = C1160r.m2704a(view);
        }
        if (a == null) {
            this.f2529b.mo9584b("VisibilityTracker", "Unable to set view tree observer due to no root view.");
            return;
        }
        ViewTreeObserver viewTreeObserver = a.getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            this.f2529b.mo9587d("VisibilityTracker", "Unable to set view tree observer since the view tree observer is not alive.");
            return;
        }
        this.f2536i = new WeakReference<>(viewTreeObserver);
        viewTreeObserver.addOnPreDrawListener(this.f2534g);
    }

    /* renamed from: a */
    private boolean m2804a(View view, View view2) {
        return view2 != null && view2.getVisibility() == 0 && view.getParent() != null && view2.getWidth() > 0 && view2.getHeight() > 0 && view2.getGlobalVisibleRect(this.f2531d) && ((long) (AppLovinSdkUtils.pxToDp(view2.getContext(), this.f2531d.width()) * AppLovinSdkUtils.pxToDp(view2.getContext(), this.f2531d.height()))) >= ((long) this.f2538k);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2807b() {
        this.f2532e.postDelayed(this.f2533f, ((Long) this.f2528a.mo9350a(C0965b.f1639bK)).longValue());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m2808b(View view, View view2) {
        if (!m2804a(view, view2)) {
            return false;
        }
        if (this.f2540m == Long.MIN_VALUE) {
            this.f2540m = SystemClock.uptimeMillis();
        }
        return SystemClock.uptimeMillis() - this.f2540m >= this.f2539l;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2810c() {
        ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.f2536i.get();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnPreDrawListener(this.f2534g);
        }
        this.f2536i.clear();
    }

    /* renamed from: a */
    public void mo9726a() {
        synchronized (this.f2530c) {
            this.f2532e.removeMessages(0);
            m2810c();
            this.f2540m = Long.MIN_VALUE;
            this.f2537j.clear();
        }
    }

    /* renamed from: a */
    public void mo9727a(C0734b bVar) {
        synchronized (this.f2530c) {
            this.f2529b.mo9584b("VisibilityTracker", "Tracking Visibility...");
            mo9726a();
            this.f2537j = new WeakReference<>(bVar.mo8414r());
            this.f2538k = bVar.mo8419w();
            this.f2539l = bVar.mo8421y();
            m2803a((View) this.f2537j.get());
        }
    }
}
