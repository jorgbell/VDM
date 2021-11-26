package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzauj extends zzhw implements zzaul {
    zzauj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void zze() throws RemoteException {
        zzbj(10, zza());
    }

    public final void zzf() throws RemoteException {
        zzbj(14, zza());
    }

    public final boolean zzg() throws RemoteException {
        Parcel zzbi = zzbi(11, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final void zzh(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, bundle);
        zzbj(1, zza);
    }

    public final void zzi() throws RemoteException {
        zzbj(2, zza());
    }

    public final void zzj() throws RemoteException {
        zzbj(3, zza());
    }

    public final void zzk() throws RemoteException {
        zzbj(4, zza());
    }

    public final void zzl() throws RemoteException {
        zzbj(5, zza());
    }

    public final void zzm(int i, int i2, Intent intent) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i);
        zza.writeInt(i2);
        zzhy.zzd(zza, intent);
        zzbj(12, zza);
    }

    public final void zzn(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(13, zza);
    }

    public final void zzo(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, bundle);
        Parcel zzbi = zzbi(6, zza);
        if (zzbi.readInt() != 0) {
            bundle.readFromParcel(zzbi);
        }
        zzbi.recycle();
    }

    public final void zzp() throws RemoteException {
        zzbj(7, zza());
    }

    public final void zzq() throws RemoteException {
        zzbj(8, zza());
    }

    public final void zzs() throws RemoteException {
        zzbj(9, zza());
    }
}
