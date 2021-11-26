package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;

/* renamed from: com.google.android.play.core.internal.an */
final class C2065an extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ IBinder f5155a;

    /* renamed from: b */
    final /* synthetic */ C2067ap f5156b;

    C2065an(C2067ap apVar, IBinder iBinder) {
        this.f5156b = apVar;
        this.f5155a = iBinder;
    }

    /* renamed from: a */
    public final void mo21844a() {
        C2068aq aqVar = this.f5156b.f5158a;
        aqVar.f5170l = (IInterface) aqVar.f5166h.mo22016a(this.f5155a);
        C2068aq.m5165j(this.f5156b.f5158a);
        this.f5156b.f5158a.f5164f = false;
        for (Runnable run : this.f5156b.f5158a.f5163e) {
            run.run();
        }
        this.f5156b.f5158a.f5163e.clear();
    }
}
