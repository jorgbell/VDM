package com.google.android.play.core.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.j */
public class C2110j implements IInterface {

    /* renamed from: a */
    private final IBinder f5214a;

    /* renamed from: b */
    private final String f5215b;

    protected C2110j(IBinder iBinder, String str) {
        this.f5214a = iBinder;
        this.f5215b = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final Parcel mo22092a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f5215b);
        return obtain;
    }

    public final IBinder asBinder() {
        return this.f5214a;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final void mo22094b(int i, Parcel parcel) throws RemoteException {
        try {
            this.f5214a.transact(i, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
