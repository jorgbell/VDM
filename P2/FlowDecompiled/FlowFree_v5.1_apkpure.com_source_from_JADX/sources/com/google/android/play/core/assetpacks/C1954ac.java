package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.ac */
final class C1954ac extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ int f4804a;

    /* renamed from: b */
    final /* synthetic */ String f4805b;

    /* renamed from: c */
    final /* synthetic */ C2172i f4806c;

    /* renamed from: d */
    final /* synthetic */ int f4807d;

    /* renamed from: e */
    final /* synthetic */ C1963an f4808e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1954ac(C1963an anVar, C2172i iVar, int i, String str, C2172i iVar2, int i2) {
        super(iVar);
        this.f4808e = anVar;
        this.f4804a = i;
        this.f4805b = str;
        this.f4806c = iVar2;
        this.f4807d = i2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            ((C2115t) this.f4808e.f4832e.mo22038c()).mo22100g(this.f4808e.f4830c, C1963an.m4898A(this.f4804a, this.f4805b), C1963an.m4900C(), new C1962ak(this.f4808e, this.f4806c, this.f4804a, this.f4805b, this.f4807d));
        } catch (RemoteException e) {
            C1963an.f4828a.mo22026c(e, "notifyModuleCompleted", new Object[0]);
        }
    }
}
