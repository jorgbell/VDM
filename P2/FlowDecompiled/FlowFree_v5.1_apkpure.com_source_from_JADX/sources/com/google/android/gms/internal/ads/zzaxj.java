package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxj extends zzhw implements zzaxl {
    zzaxj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    public final void zzb(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(5, zza);
    }

    public final void zzc(zzys zzys, zzaxs zzaxs) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, zzaxs);
        zzbj(1, zza);
    }

    public final void zze(zzaxo zzaxo) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaxo);
        zzbj(2, zza);
    }
}
