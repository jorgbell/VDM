package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzbac extends zzhx implements zzbad {
    public zzbac() {
        super("com.google.android.gms.ads.internal.signals.ISignalCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb(parcel.readString(), parcel.readString());
        } else if (i == 2) {
            zzc(parcel.readString());
        } else if (i != 3) {
            return false;
        } else {
            zzd(parcel.readString(), parcel.readString(), (Bundle) zzhy.zzc(parcel, Bundle.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
