package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaal extends zzhw implements zzaan {
    zzaal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoader");
    }

    public final void zze(zzys zzys) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zzbj(1, zza);
    }
}
