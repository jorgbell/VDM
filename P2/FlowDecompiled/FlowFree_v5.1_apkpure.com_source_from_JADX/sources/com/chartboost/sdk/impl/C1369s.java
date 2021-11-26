package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.CBLogging;
import java.lang.ref.WeakReference;

/* renamed from: com.chartboost.sdk.impl.s */
public class C1369s extends C1386w {

    /* renamed from: e */
    private WeakReference<C1366r> f3370e;

    public C1369s(WeakReference<C1366r> weakReference, double d) {
        super(d);
        this.f3370e = weakReference;
    }

    /* renamed from: a */
    public void mo10599a() {
        WeakReference<C1366r> weakReference = this.f3370e;
        if (weakReference != null) {
            C1366r rVar = (C1366r) weakReference.get();
            if (rVar != null) {
                rVar.mo9946a();
            } else {
                CBLogging.m2903a("BannerRefreshTimer", "Refresh callback is disposed");
            }
        }
    }

    /* renamed from: i */
    public void mo10600i() {
        WeakReference<C1366r> weakReference = this.f3370e;
        if (weakReference != null) {
            weakReference.clear();
            this.f3370e = null;
        }
        super.mo10600i();
    }
}
