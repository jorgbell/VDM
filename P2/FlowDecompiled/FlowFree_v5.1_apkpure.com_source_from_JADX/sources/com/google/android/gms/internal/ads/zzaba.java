package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzaba extends zzhx implements zzabb {
    public zzaba() {
        super("com.google.android.gms.ads.internal.client.IAppEventListener");
    }

    public static zzabb zzd(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAppEventListener");
        if (queryLocalInterface instanceof zzabb) {
            return (zzabb) queryLocalInterface;
        }
        return new zzaaz(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb(parcel.readString(), parcel.readString());
        parcel2.writeNoException();
        return true;
    }
}
