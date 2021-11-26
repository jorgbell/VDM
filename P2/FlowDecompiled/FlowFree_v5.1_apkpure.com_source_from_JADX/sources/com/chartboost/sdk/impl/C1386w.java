package com.chartboost.sdk.impl;

import android.os.Handler;
import com.chartboost.sdk.Libraries.CBLogging;

/* renamed from: com.chartboost.sdk.impl.w */
abstract class C1386w implements C1379v {

    /* renamed from: a */
    private Handler f3435a;

    /* renamed from: b */
    private double f3436b = 0.0d;

    /* renamed from: c */
    private double f3437c;

    /* renamed from: d */
    private Runnable f3438d = new Runnable() {
        public final void run() {
            C1386w.this.mo10662d();
        }
    };

    C1386w(double d) {
        this.f3437c = d;
    }

    /* renamed from: b */
    private void m3799b() {
        if (this.f3435a == null) {
            this.f3435a = new Handler();
        }
    }

    /* renamed from: f */
    private void m3800f() {
        m3799b();
        Runnable runnable = this.f3438d;
        if (runnable != null) {
            this.f3435a.postDelayed(runnable, 1000);
        }
    }

    /* renamed from: j */
    private void m3801j() {
        Runnable runnable;
        Handler handler = this.f3435a;
        if (handler != null && (runnable = this.f3438d) != null) {
            handler.removeCallbacks(runnable);
            this.f3435a = null;
        }
    }

    /* renamed from: c */
    public Double mo10661c() {
        return Double.valueOf(this.f3436b);
    }

    /* renamed from: d */
    public void mo10662d() {
        double d = this.f3436b + 1.0d;
        this.f3436b = d;
        if (d >= this.f3437c) {
            mo10599a();
        } else {
            m3800f();
        }
    }

    /* renamed from: e */
    public void mo10663e() {
        m3801j();
    }

    /* renamed from: g */
    public void mo10664g() {
        if (this.f3436b > 0.0d) {
            CBLogging.m2903a("BannerTimer", "Resume timer at: " + this.f3436b + " sec");
            mo10665h();
        }
    }

    /* renamed from: h */
    public void mo10665h() {
        m3800f();
    }

    /* renamed from: i */
    public void mo10600i() {
        m3801j();
        this.f3436b = 0.0d;
    }
}
