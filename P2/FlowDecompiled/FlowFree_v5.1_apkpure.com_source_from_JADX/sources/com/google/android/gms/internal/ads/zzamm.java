package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzamm extends zzhx implements zzamn {
    public zzamm() {
        super("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    public static zzamn zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
        if (queryLocalInterface instanceof zzamn) {
            return (zzamn) queryLocalInterface;
        }
        return new zzaml(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 2) {
            zze();
        } else if (i != 3) {
            return false;
        } else {
            zzf(parcel.readString());
        }
        parcel2.writeNoException();
        return true;
    }
}
