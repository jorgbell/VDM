package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzacc extends zzhx implements zzacd {
    public zzacc() {
        super("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public static zzacd zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOnPaidEventListener");
        if (queryLocalInterface instanceof zzacd) {
            return (zzacd) queryLocalInterface;
        }
        return new zzacb(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zze((zzyz) zzhy.zzc(parcel, zzyz.CREATOR));
        parcel2.writeNoException();
        return true;
    }
}
