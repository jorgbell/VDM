package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzavs extends zzhw implements zzavu {
    zzavs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    public final void zze(zzawc zzawc, zzavy zzavy) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzawc);
        zzhy.zzf(zza, zzavy);
        zzbj(4, zza);
    }

    public final void zzf(zzawc zzawc, zzavy zzavy) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzawc);
        zzhy.zzf(zza, zzavy);
        zzbj(5, zza);
    }

    public final void zzg(zzawc zzawc, zzavy zzavy) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzawc);
        zzhy.zzf(zza, zzavy);
        zzbj(6, zza);
    }

    public final void zzh(String str, zzavy zzavy) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzhy.zzf(zza, zzavy);
        zzbj(7, zza);
    }
}
