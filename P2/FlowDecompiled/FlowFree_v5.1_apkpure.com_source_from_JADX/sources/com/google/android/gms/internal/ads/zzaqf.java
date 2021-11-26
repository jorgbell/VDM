package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaqf extends zzhw implements zzaqh {
    zzaqf(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public final void zze() throws RemoteException {
        zzbj(1, zza());
    }

    public final void zzf() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zzg(int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zzbj(3, zza);
    }

    public final void zzh() throws RemoteException {
        zzbj(4, zza());
    }

    public final void zzi() throws RemoteException {
        zzbj(5, zza());
    }

    public final void zzj() throws RemoteException {
        zzbj(6, zza());
    }

    public final void zzk() throws RemoteException {
        zzbj(8, zza());
    }

    public final void zzl(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbj(9, zza);
    }

    public final void zzm(zzaia zzaia, String str) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaia);
        zza.writeString(str);
        zzbj(10, zza);
    }

    public final void zzn() throws RemoteException {
        zzbj(11, zza());
    }

    public final void zzo() throws RemoteException {
        zzbj(13, zza());
    }

    public final void zzp(zzaxe zzaxe) throws RemoteException {
        throw null;
    }

    public final void zzq() throws RemoteException {
        zzbj(15, zza());
    }

    public final void zzr(zzaxi zzaxi) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaxi);
        zzbj(16, zza);
    }

    public final void zzs(int i) throws RemoteException {
        throw null;
    }

    public final void zzt() throws RemoteException {
        zzbj(18, zza());
    }

    public final void zzu() throws RemoteException {
        zzbj(20, zza());
    }

    public final void zzv(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbj(21, zza);
    }

    public final void zzw(int i, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeString(str);
        zzbj(22, zza);
    }

    public final void zzx(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(23, zza);
    }

    public final void zzy(zzym zzym) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzym);
        zzbj(24, zza);
    }
}
