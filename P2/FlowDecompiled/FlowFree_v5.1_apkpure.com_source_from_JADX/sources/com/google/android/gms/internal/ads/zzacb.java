package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzacb extends zzhw implements zzacd {
    zzacb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IOnPaidEventListener");
    }

    public final void zze(zzyz zzyz) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzyz);
        zzbj(1, zza);
    }
}
