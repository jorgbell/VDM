package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaaf extends zzhw implements zzaah {
    zzaaf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdListener");
    }

    public final void zzb() throws RemoteException {
        zzbj(1, zza());
    }

    public final void zzc(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbj(2, zza);
    }

    public final void zzd(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(8, zza);
    }

    public final void zze() throws RemoteException {
        zzbj(3, zza());
    }

    public final void zzf() throws RemoteException {
        zzbj(4, zza());
    }

    public final void zzg() throws RemoteException {
        zzbj(5, zza());
    }

    public final void zzh() throws RemoteException {
        zzbj(6, zza());
    }

    public final void zzi() throws RemoteException {
        zzbj(7, zza());
    }
}
