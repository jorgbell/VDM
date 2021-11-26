package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.aa */
public final class C2053aa extends C2110j implements C2055ac {
    C2053aa(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    /* renamed from: c */
    public final void mo22021c(String str, Bundle bundle, C2057ae aeVar) throws RemoteException {
        Parcel a = mo22092a();
        a.writeString(str);
        C2112l.m5294b(a, bundle);
        C2112l.m5295c(a, aeVar);
        mo22094b(2, a);
    }
}
