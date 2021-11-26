package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzaxr extends zzhx implements zzaxs {
    public zzaxr() {
        super("com.google.android.gms.ads.internal.rewarded.client.IRewardedAdLoadCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze();
        } else if (i == 2) {
            zzf(parcel.readInt());
        } else if (i != 3) {
            return false;
        } else {
            zzg((zzym) zzhy.zzc(parcel, zzym.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
