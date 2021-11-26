package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.ab */
final class C1953ab extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ int f4798a;

    /* renamed from: b */
    final /* synthetic */ String f4799b;

    /* renamed from: c */
    final /* synthetic */ String f4800c;

    /* renamed from: d */
    final /* synthetic */ int f4801d;

    /* renamed from: e */
    final /* synthetic */ C2172i f4802e;

    /* renamed from: f */
    final /* synthetic */ C1963an f4803f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1953ab(C1963an anVar, C2172i iVar, int i, String str, String str2, int i2, C2172i iVar2) {
        super(iVar);
        this.f4803f = anVar;
        this.f4798a = i;
        this.f4799b = str;
        this.f4800c = str2;
        this.f4801d = i2;
        this.f4802e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            ((C2115t) this.f4803f.f4832e.mo22038c()).mo22099f(this.f4803f.f4830c, C1963an.m4907r(this.f4798a, this.f4799b, this.f4800c, this.f4801d), C1963an.m4900C(), new C1958ag(this.f4803f, this.f4802e, (char[]) null));
        } catch (RemoteException e) {
            C1963an.f4828a.mo22026c(e, "notifyChunkTransferred", new Object[0]);
        }
    }
}
