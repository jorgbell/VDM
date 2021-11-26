package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzamp extends zzhx implements zzamq {
    public zzamp() {
        super("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public static zzamq zzc(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IInitializationCallback");
        if (queryLocalInterface instanceof zzamq) {
            return (zzamq) queryLocalInterface;
        }
        return new zzamo(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb(parcel.createTypedArrayList(zzamj.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
