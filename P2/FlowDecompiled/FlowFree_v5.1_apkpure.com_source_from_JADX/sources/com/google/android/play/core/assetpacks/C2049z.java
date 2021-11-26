package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.tasks.C2172i;
import java.util.Map;

/* renamed from: com.google.android.play.core.assetpacks.z */
final class C2049z extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ Map f5141a;

    /* renamed from: b */
    final /* synthetic */ C2172i f5142b;

    /* renamed from: c */
    final /* synthetic */ C1963an f5143c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2049z(C1963an anVar, C2172i iVar, Map map, C2172i iVar2) {
        super(iVar);
        this.f5143c = anVar;
        this.f5141a = map;
        this.f5142b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            ((C2115t) this.f5143c.f4832e.mo22038c()).mo22098e(this.f5143c.f4830c, C1963an.m4903m(this.f5141a), new C1960ai(this.f5143c, this.f5142b));
        } catch (RemoteException e) {
            C1963an.f4828a.mo22026c(e, "syncPacks", new Object[0]);
            this.f5142b.mo22195d(new RuntimeException(e));
        }
    }
}
