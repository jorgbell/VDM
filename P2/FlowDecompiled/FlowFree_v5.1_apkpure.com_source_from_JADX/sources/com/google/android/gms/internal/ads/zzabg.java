package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzabg extends zzhw implements zzabi {
    zzabg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IFullScreenContentCallback");
    }

    public final void zzb(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(1, zza);
    }

    public final void zzc() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zzd() throws RemoteException {
        zzbj(3, zza());
    }

    public final void zze() throws RemoteException {
        zzbj(4, zza());
    }
}
