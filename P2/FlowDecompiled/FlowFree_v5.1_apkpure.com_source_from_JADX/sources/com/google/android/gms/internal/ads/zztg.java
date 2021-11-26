package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zztg extends zzhw implements zzti {
    zztg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenFullScreenContentCallback");
    }

    public final void zzc() throws RemoteException {
        zzbj(1, zza());
    }

    public final void zzd() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zze(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(3, zza);
    }

    public final void zzf() throws RemoteException {
        zzbj(4, zza());
    }
}
