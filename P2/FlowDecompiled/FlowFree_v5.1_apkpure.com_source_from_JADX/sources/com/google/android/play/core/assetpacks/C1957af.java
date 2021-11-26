package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.af */
final class C1957af extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ C2172i f4818a;

    /* renamed from: b */
    final /* synthetic */ C1963an f4819b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1957af(C1963an anVar, C2172i iVar, C2172i iVar2) {
        super(iVar);
        this.f4819b = anVar;
        this.f4818a = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            ((C2115t) this.f4819b.f4833f.mo22038c()).mo22102i(this.f4819b.f4830c, C1963an.m4900C(), new C1961aj(this.f4819b, this.f4818a));
        } catch (RemoteException e) {
            C1963an.f4828a.mo22026c(e, "keepAlive", new Object[0]);
        }
    }
}
