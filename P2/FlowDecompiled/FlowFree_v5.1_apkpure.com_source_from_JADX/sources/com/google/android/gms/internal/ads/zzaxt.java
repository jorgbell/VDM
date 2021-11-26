package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxt extends zzhw implements IInterface {
    zzaxt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzaxi zzaxi, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaxi);
        zza.writeString(str);
        zza.writeString(str2);
        zzbj(2, zza);
    }
}
