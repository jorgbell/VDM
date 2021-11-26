package com.google.android.play.core.review;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2056ad;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.review.g */
class C2132g<T> extends C2056ad {

    /* renamed from: a */
    final C2058ag f5239a;

    /* renamed from: b */
    final C2172i<T> f5240b;

    /* renamed from: c */
    final /* synthetic */ C2134i f5241c;

    C2132g(C2134i iVar, C2058ag agVar, C2172i<T> iVar2) {
        this.f5241c = iVar;
        this.f5239a = agVar;
        this.f5240b = iVar2;
    }

    /* renamed from: b */
    public void mo22023b(Bundle bundle) throws RemoteException {
        this.f5241c.f5243a.mo22037b();
        this.f5239a.mo22027d("onGetLaunchReviewFlowInfo", new Object[0]);
    }
}
