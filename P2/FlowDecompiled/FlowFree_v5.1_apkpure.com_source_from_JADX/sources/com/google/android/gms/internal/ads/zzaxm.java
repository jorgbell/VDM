package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaxm extends zzhw implements zzaxo {
    zzaxm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdCallback");
    }

    public final void zze() throws RemoteException {
        zzbj(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zzg(zzaxi zzaxi) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaxi);
        zzbj(3, zza);
    }

    public final void zzh(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbj(4, zza);
    }

    public final void zzi(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbj(6, zza());
    }
}
