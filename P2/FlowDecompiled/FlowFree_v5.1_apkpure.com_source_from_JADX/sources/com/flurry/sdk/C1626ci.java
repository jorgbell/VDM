package com.flurry.sdk;

import com.flurry.sdk.C1601bx;

/* renamed from: com.flurry.sdk.ci */
public final class C1626ci extends C1601bx {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C1914o<C1501ak> f4114a = new C1914o<C1501ak>() {
        /* renamed from: a */
        public final /* synthetic */ void mo11263a(Object obj) {
            C1913n.m4811a().f4728g.unsubscribe(C1626ci.this.f4114a);
            C1626ci.this.mo11359d();
        }
    };

    public C1626ci(C1634cp cpVar, C1601bx.C1604a aVar, C1616ca caVar, C1629ck ckVar) {
        super(cpVar, aVar, caVar, ckVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo11357b() {
        if (C1913n.m4811a().f4728g.mo11270c()) {
            mo11359d();
            return;
        }
        C1648cy.m4319a("StreamingConfigFetcher", "Waiting for ID provider.");
        C1913n.m4811a().f4728g.subscribe(this.f4114a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public final String mo11358c() {
        return C1913n.m4811a().f4729h.f3706a;
    }
}
