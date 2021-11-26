package com.chartboost.sdk.impl;

import com.chartboost.sdk.C1414j;
import com.chartboost.sdk.Libraries.CBLogging;
import com.chartboost.sdk.Model.C1236h;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.impl.q */
public class C1363q {

    /* renamed from: a */
    private C1369s f3352a = null;

    /* renamed from: b */
    private C1376u f3353b = null;

    /* renamed from: c */
    private WeakReference<C1366r> f3354c;

    /* renamed from: d */
    private WeakReference<C1372t> f3355d;

    /* renamed from: e */
    private boolean f3356e = true;

    /* renamed from: c */
    private void m3690c() {
        WeakReference<C1372t> weakReference = this.f3355d;
        if (weakReference != null) {
            weakReference.clear();
            this.f3355d = null;
        }
    }

    /* renamed from: e */
    private C1236h.C1237a m3691e() {
        C1236h j;
        C1414j b = C1414j.m3867b();
        if (b == null || (j = b.mo10717j()) == null) {
            return null;
        }
        return j.mo10129a();
    }

    /* renamed from: a */
    public void mo10579a(C1366r rVar) {
        m3689b();
        this.f3354c = new WeakReference<>(rVar);
    }

    /* renamed from: b */
    public C1376u mo10582b(WeakReference<C1372t> weakReference, double d) {
        return new C1376u(weakReference, d);
    }

    /* renamed from: d */
    public boolean mo10583d() {
        return this.f3356e;
    }

    /* renamed from: f */
    public double mo10584f() {
        C1236h.C1237a e = m3691e();
        if (e != null) {
            return e.mo10133a();
        }
        return 30.0d;
    }

    /* renamed from: g */
    public double mo10585g() {
        C1236h.C1237a e = m3691e();
        if (e != null) {
            return e.mo10134b();
        }
        return 30.0d;
    }

    /* renamed from: h */
    public void mo10586h() {
        if (this.f3352a != null) {
            CBLogging.m2903a("BannerAutoRefreshManager", "Auto-refreshed is paused at: " + this.f3352a.mo10661c());
            this.f3352a.mo10663e();
        }
    }

    /* renamed from: i */
    public void mo10587i() {
        C1376u uVar = this.f3353b;
        if (uVar != null) {
            uVar.mo10663e();
        }
    }

    /* renamed from: j */
    public void mo10588j() {
        mo10592n();
        if (this.f3352a == null && this.f3356e && this.f3354c != null) {
            CBLogging.m2903a("BannerAutoRefreshManager", "Register auto refresh start");
            C1369s a = mo10577a(this.f3354c, mo10584f());
            this.f3352a = a;
            a.mo10665h();
        }
    }

    /* renamed from: k */
    public void mo10589k() {
        mo10593o();
        if (this.f3353b == null && this.f3356e && this.f3355d != null) {
            CBLogging.m2903a("BannerAutoRefreshManager", "Register timeout start");
            C1376u b = mo10582b(this.f3355d, mo10585g());
            this.f3353b = b;
            b.mo10665h();
        }
    }

    /* renamed from: l */
    public void mo10590l() {
        if (this.f3352a != null) {
            CBLogging.m2903a("BannerAutoRefreshManager", "Auto-refreshed is resumed at: " + this.f3352a.mo10661c());
            this.f3352a.mo10664g();
            return;
        }
        mo10588j();
    }

    /* renamed from: m */
    public void mo10591m() {
        if (this.f3353b != null) {
            CBLogging.m2903a("BannerAutoRefreshManager", "Timeout banner is resumed at: " + this.f3353b.mo10661c());
            this.f3353b.mo10664g();
        }
    }

    /* renamed from: n */
    public void mo10592n() {
        C1369s sVar = this.f3352a;
        if (sVar != null) {
            sVar.mo10600i();
            this.f3352a = null;
        }
    }

    /* renamed from: o */
    public void mo10593o() {
        C1376u uVar = this.f3353b;
        if (uVar != null) {
            uVar.mo10600i();
            this.f3353b = null;
        }
    }

    /* renamed from: b */
    private void m3689b() {
        WeakReference<C1366r> weakReference = this.f3354c;
        if (weakReference != null) {
            weakReference.clear();
            this.f3354c = null;
        }
    }

    /* renamed from: a */
    public void mo10580a(C1372t tVar) {
        m3690c();
        this.f3355d = new WeakReference<>(tVar);
    }

    /* renamed from: a */
    public C1369s mo10577a(WeakReference<C1366r> weakReference, double d) {
        return new C1369s(weakReference, d);
    }

    /* renamed from: a */
    public void mo10581a(boolean z) {
        this.f3356e = z;
        if (z) {
            mo10591m();
            mo10590l();
            return;
        }
        mo10587i();
        mo10586h();
    }

    /* renamed from: a */
    public void mo10578a() {
        m3689b();
        m3690c();
    }
}
