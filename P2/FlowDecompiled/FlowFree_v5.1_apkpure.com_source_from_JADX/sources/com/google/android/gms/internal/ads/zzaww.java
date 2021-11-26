package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaww extends zzhw implements zzawy {
    zzaww(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdListener");
    }

    public final void zze() throws RemoteException {
        zzbj(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zzg() throws RemoteException {
        zzbj(3, zza());
    }

    public final void zzh() throws RemoteException {
        zzbj(4, zza());
    }

    public final void zzi(zzaws zzaws) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaws);
        zzbj(5, zza);
    }

    public final void zzj() throws RemoteException {
        zzbj(6, zza());
    }

    public final void zzk(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbj(7, zza);
    }

    public final void zzl() throws RemoteException {
        zzbj(8, zza());
    }
}
