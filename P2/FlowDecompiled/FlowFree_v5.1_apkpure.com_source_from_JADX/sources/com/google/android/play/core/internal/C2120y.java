package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.y */
public final class C2120y extends C2110j implements C2121z {
    C2120y(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    /* renamed from: c */
    public final void mo22104c(Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel a = mo22092a();
        C2112l.m5294b(a, bundle);
        C2112l.m5294b(a, bundle2);
        mo22094b(2, a);
    }

    /* renamed from: d */
    public final void mo22105d(Bundle bundle) throws RemoteException {
        Parcel a = mo22092a();
        C2112l.m5294b(a, bundle);
        mo22094b(3, a);
    }

    /* renamed from: e */
    public final void mo22106e(Bundle bundle) throws RemoteException {
        Parcel a = mo22092a();
        C2112l.m5294b(a, bundle);
        mo22094b(4, a);
    }
}
