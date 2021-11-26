package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzace extends zzhw implements zzacg {
    zzace(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public final String zze() throws RemoteException {
        Parcel zzbi = zzbi(1, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final String zzf() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final List<zzzb> zzg() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        ArrayList<zzzb> createTypedArrayList = zzbi.createTypedArrayList(zzzb.CREATOR);
        zzbi.recycle();
        return createTypedArrayList;
    }
}
