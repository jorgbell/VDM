package com.google.android.play.core.review;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.play.core.internal.C2058ag;
import com.google.android.play.core.tasks.C2172i;

/* renamed from: com.google.android.play.core.review.h */
final class C2133h extends C2132g<ReviewInfo> {
    C2133h(C2134i iVar, C2172i iVar2) {
        super(iVar, new C2058ag("OnRequestInstallCallback"), iVar2);
    }

    /* renamed from: b */
    public final void mo22023b(Bundle bundle) throws RemoteException {
        super.mo22023b(bundle);
        this.f5240b.mo22196e(ReviewInfo.m5347b((PendingIntent) bundle.get("confirmation_intent")));
    }
}
