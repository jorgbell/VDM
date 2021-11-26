package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaqo extends zzhw implements zzaqq {
    zzaqo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    public final float zzA() throws RemoteException {
        Parcel zzbi = zzbi(24, zza());
        float readFloat = zzbi.readFloat();
        zzbi.recycle();
        return readFloat;
    }

    public final float zzB() throws RemoteException {
        Parcel zzbi = zzbi(25, zza());
        float readFloat = zzbi.readFloat();
        zzbi.recycle();
        return readFloat;
    }

    public final String zze() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final List zzf() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        ArrayList zzg = zzhy.zzg(zzbi);
        zzbi.recycle();
        return zzg;
    }

    public final String zzg() throws RemoteException {
        Parcel zzbi = zzbi(4, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final zzahk zzh() throws RemoteException {
        Parcel zzbi = zzbi(5, zza());
        zzahk zzg = zzahj.zzg(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzg;
    }

    public final String zzi() throws RemoteException {
        Parcel zzbi = zzbi(6, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final String zzj() throws RemoteException {
        Parcel zzbi = zzbi(7, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final double zzk() throws RemoteException {
        Parcel zzbi = zzbi(8, zza());
        double readDouble = zzbi.readDouble();
        zzbi.recycle();
        return readDouble;
    }

    public final String zzl() throws RemoteException {
        Parcel zzbi = zzbi(9, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final String zzm() throws RemoteException {
        Parcel zzbi = zzbi(10, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final zzacj zzn() throws RemoteException {
        Parcel zzbi = zzbi(11, zza());
        zzacj zzb = zzaci.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final zzahc zzo() throws RemoteException {
        Parcel zzbi = zzbi(12, zza());
        zzahc zzj = zzahb.zzj(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzj;
    }

    public final IObjectWrapper zzp() throws RemoteException {
        Parcel zzbi = zzbi(13, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzq() throws RemoteException {
        Parcel zzbi = zzbi(14, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final IObjectWrapper zzr() throws RemoteException {
        Parcel zzbi = zzbi(15, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final Bundle zzs() throws RemoteException {
        Parcel zzbi = zzbi(16, zza());
        Bundle bundle = (Bundle) zzhy.zzc(zzbi, Bundle.CREATOR);
        zzbi.recycle();
        return bundle;
    }

    public final boolean zzt() throws RemoteException {
        Parcel zzbi = zzbi(17, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final boolean zzu() throws RemoteException {
        Parcel zzbi = zzbi(18, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final void zzv() throws RemoteException {
        zzbj(19, zza());
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(20, zza);
    }

    public final void zzx(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, iObjectWrapper2);
        zzhy.zzf(zza, iObjectWrapper3);
        zzbj(21, zza);
    }

    public final void zzy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(22, zza);
    }

    public final float zzz() throws RemoteException {
        Parcel zzbi = zzbi(23, zza());
        float readFloat = zzbi.readFloat();
        zzbi.recycle();
        return readFloat;
    }
}
