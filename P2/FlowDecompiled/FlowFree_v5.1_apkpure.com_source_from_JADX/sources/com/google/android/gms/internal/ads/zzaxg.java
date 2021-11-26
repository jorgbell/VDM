package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxg extends zzhw implements zzaxi {
    zzaxg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    public final String zze() throws RemoteException {
        Parcel zzbi = zzbi(1, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final int zzf() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        int readInt = zzbi.readInt();
        zzbi.recycle();
        return readInt;
    }
}
