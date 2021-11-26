package com.google.android.play.core.review;

import android.os.RemoteException;
import com.google.android.play.core.common.PlayCoreVersion;
import com.google.android.play.core.internal.C2059ah;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.review.f */
final class C2131f extends C2059ah {

    /* renamed from: a */
    final /* synthetic */ C2172i f5237a;

    /* renamed from: b */
    final /* synthetic */ C2134i f5238b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C2131f(C2134i iVar, C2172i iVar2, C2172i iVar3) {
        super(iVar2);
        this.f5238b = iVar;
        this.f5237a = iVar3;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo21844a() {
        try {
            this.f5238b.f5243a.mo22038c().mo22021c(this.f5238b.f5244c, PlayCoreVersion.m5131b("review"), new C2133h(this.f5238b, this.f5237a));
        } catch (RemoteException e) {
            C2134i.f5242b.mo22026c(e, "error requesting in-app review for %s", this.f5238b.f5244c);
            this.f5237a.mo22195d(new RuntimeException(e));
        }
    }
}
