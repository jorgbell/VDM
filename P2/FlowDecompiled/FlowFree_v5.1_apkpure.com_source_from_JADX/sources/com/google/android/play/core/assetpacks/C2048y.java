package com.google.android.play.core.assetpacks;

import android.os.RemoteException;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.internal.C2115t;
import com.google.android.play.core.tasks.C2172i;
import java.util.List;

/* renamed from: com.google.android.play.core.assetpacks.y */
final class C2048y extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ List f5138a;

    /* renamed from: b */
    final /* synthetic */ C2172i f5139b;

    /* renamed from: c */
    final /* synthetic */ C1963an f5140c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2048y(C1963an anVar, C2172i iVar, List list, C2172i iVar2) {
        super(iVar);
        this.f5140c = anVar;
        this.f5138a = list;
        this.f5139b = iVar2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            ((C2115t) this.f5140c.f4832e.mo22038c()).mo22097d(this.f5140c.f4830c, C1963an.m4901k(this.f5138a), C1963an.m4900C(), new C1958ag(this.f5140c, this.f5139b, (byte[]) null));
        } catch (RemoteException e) {
            C1963an.f4828a.mo22026c(e, "cancelDownloads(%s)", this.f5138a);
        }
    }
}
