package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zztc extends zzhw implements zzte {
    zztc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    public final void zzb(zztb zztb) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zztb);
        zzbj(1, zza);
    }

    public final void zzc(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbj(2, zza);
    }

    public final void zzd(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(3, zza);
    }
}
