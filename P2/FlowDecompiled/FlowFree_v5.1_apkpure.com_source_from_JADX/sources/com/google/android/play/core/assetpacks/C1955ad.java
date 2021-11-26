package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.ad */
final class C1955ad extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ int f4809a;

    /* renamed from: b */
    final /* synthetic */ C2172i f4810b;

    /* renamed from: c */
    final /* synthetic */ C1963an f4811c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1955ad(C1963an anVar, C2172i iVar, int i, C2172i iVar2) {
        super(iVar);
        this.f4811c = anVar;
        this.f4809a = i;
        this.f4810b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            ((C2115t) this.f4811c.f4832e.mo22038c()).mo22101h(this.f4811c.f4830c, C1963an.m4899B(this.f4809a), C1963an.m4900C(), new C1958ag(this.f4811c, this.f4810b, (int[]) null));
        } catch (RemoteException e) {
            C1963an.f4828a.mo22026c(e, "notifySessionFailed", new Object[0]);
        }
    }
}
