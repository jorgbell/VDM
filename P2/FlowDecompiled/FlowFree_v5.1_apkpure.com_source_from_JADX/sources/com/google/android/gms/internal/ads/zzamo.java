package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzamo extends zzhw implements zzamq {
    zzamo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IInitializationCallback");
    }

    public final void zzb(List<zzamj> list) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzbj(1, zza);
    }
}
