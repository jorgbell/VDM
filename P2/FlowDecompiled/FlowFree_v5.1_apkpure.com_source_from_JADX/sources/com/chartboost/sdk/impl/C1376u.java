package com.chartboost.sdk.impl;

import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.impl.u */
public class C1376u extends C1386w {

    /* renamed from: e */
    private WeakReference<C1372t> f3385e;

    public C1376u(WeakReference<C1372t> weakReference, double d) {
        super(d);
        this.f3385e = weakReference;
    }

    /* renamed from: a */
    public void mo10599a() {
        C1372t tVar;
        WeakReference<C1372t> weakReference = this.f3385e;
        if (weakReference != null && (tVar = (C1372t) weakReference.get()) != null) {
            tVar.mo9952b();
        }
    }

    /* renamed from: i */
    public void mo10600i() {
        WeakReference<C1372t> weakReference = this.f3385e;
        if (weakReference != null) {
            weakReference.clear();
            this.f3385e = null;
        }
        super.mo10600i();
    }
}
