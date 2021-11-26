package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.assetpacks.ae */
final class C1956ae extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ int f4812a;

    /* renamed from: b */
    final /* synthetic */ String f4813b;

    /* renamed from: c */
    final /* synthetic */ String f4814c;

    /* renamed from: d */
    final /* synthetic */ int f4815d;

    /* renamed from: e */
    final /* synthetic */ C2172i f4816e;

    /* renamed from: f */
    final /* synthetic */ C1963an f4817f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1956ae(C1963an anVar, C2172i iVar, int i, String str, String str2, int i2, C2172i iVar2) {
        super(iVar);
        this.f4817f = anVar;
        this.f4812a = i;
        this.f4813b = str;
        this.f4814c = str2;
        this.f4815d = i2;
        this.f4816e = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            ((C2115t) this.f4817f.f4832e.mo22038c()).mo22103j(this.f4817f.f4830c, C1963an.m4907r(this.f4812a, this.f4813b, this.f4814c, this.f4815d), C1963an.m4900C(), new C1959ah(this.f4817f, this.f4816e));
        } catch (RemoteException e) {
            C1963an.f4828a.mo22025b("getChunkFileDescriptor(%s, %s, %d, session=%d)", this.f4813b, this.f4814c, Integer.valueOf(this.f4815d), Integer.valueOf(this.f4812a));
            this.f4816e.mo22195d(new RuntimeException(e));
        }
    }
}
