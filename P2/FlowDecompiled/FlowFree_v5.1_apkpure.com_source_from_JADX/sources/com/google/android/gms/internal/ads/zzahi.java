package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzahi extends zzhw implements zzahk {
    zzahi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    public final IObjectWrapper zzb() throws RemoteException {
        Parcel zzbi = zzbi(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final Uri zzc() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        Uri uri = (Uri) zzhy.zzc(zzbi, Uri.CREATOR);
        zzbi.recycle();
        return uri;
    }

    public final double zzd() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        double readDouble = zzbi.readDouble();
        zzbi.recycle();
        return readDouble;
    }

    public final int zze() throws RemoteException {
        Parcel zzbi = zzbi(4, zza());
        int readInt = zzbi.readInt();
        zzbi.recycle();
        return readInt;
    }

    public final int zzf() throws RemoteException {
        Parcel zzbi = zzbi(5, zza());
        int readInt = zzbi.readInt();
        zzbi.recycle();
        return readInt;
    }
}
