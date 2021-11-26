package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zztu extends zzhw implements IInterface {
    zztu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final zztp zze(zzts zzts) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzts);
        Parcel zzbi = zzbi(1, zza);
        zztp zztp = (zztp) zzhy.zzc(zzbi, zztp.CREATOR);
        zzbi.recycle();
        return zztp;
    }

    public final zztp zzf(zzts zzts) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzts);
        Parcel zzbi = zzbi(2, zza);
        zztp zztp = (zztp) zzhy.zzc(zzbi, zztp.CREATOR);
        zzbi.recycle();
        return zztp;
    }

    public final long zzg(zzts zzts) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzts);
        Parcel zzbi = zzbi(3, zza);
        long readLong = zzbi.readLong();
        zzbi.recycle();
        return readLong;
    }
}
