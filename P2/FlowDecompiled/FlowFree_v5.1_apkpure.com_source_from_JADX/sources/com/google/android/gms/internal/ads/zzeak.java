package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeak extends zzhw implements IInterface {
    zzeak(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzeai zze(zzeag zzeag) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzeag);
        Parcel zzbi = zzbi(1, zza);
        zzeai zzeai = (zzeai) zzhy.zzc(zzbi, zzeai.CREATOR);
        zzbi.recycle();
        return zzeai;
    }

    public final void zzf(zzead zzead) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzead);
        zzbj(2, zza);
    }

    public final zzear zzg(zzeap zzeap) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzeap);
        Parcel zzbi = zzbi(3, zza);
        zzear zzear = (zzear) zzhy.zzc(zzbi, zzear.CREATOR);
        zzbi.recycle();
        return zzear;
    }
}
