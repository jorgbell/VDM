package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.ak */
final class C2062ak extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ C2068aq f5154a;

    C2062ak(C2068aq aqVar) {
        this.f5154a = aqVar;
    }

    /* renamed from: a */
    public final void mo21844a() {
        if (this.f5154a.f5170l != null) {
            this.f5154a.f5161c.mo22027d("Unbind from service.", new Object[0]);
            this.f5154a.f5160b.unbindService(this.f5154a.f5169k);
            this.f5154a.f5164f = false;
            this.f5154a.f5170l = null;
            this.f5154a.f5169k = null;
        }
    }
}
