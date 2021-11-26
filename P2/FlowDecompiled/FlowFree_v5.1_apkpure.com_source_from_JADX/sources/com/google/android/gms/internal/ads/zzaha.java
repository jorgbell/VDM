package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaha extends zzhw implements zzahc {
    zzaha(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    public final String zzb() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final List<zzahk> zzc() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        ArrayList zzg = zzhy.zzg(zzbi);
        zzbi.recycle();
        return zzg;
    }
}
