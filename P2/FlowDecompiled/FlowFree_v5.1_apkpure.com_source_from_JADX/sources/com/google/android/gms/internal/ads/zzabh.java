package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzabh extends zzhx implements zzabi {
    public zzabh() {
        super("com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zzym) zzhy.zzc(parcel, zzym.CREATOR));
        } else if (i == 2) {
            zzc();
        } else if (i == 3) {
            zzd();
        } else if (i != 4) {
            return false;
        } else {
            zze();
        }
        parcel2.writeNoException();
        return true;
    }
}
