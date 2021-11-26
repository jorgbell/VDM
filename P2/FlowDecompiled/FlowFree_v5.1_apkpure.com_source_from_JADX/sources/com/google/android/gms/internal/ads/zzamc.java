package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzamc extends zzhw implements IInterface {
    zzamc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzalw zzalw, zzamb zzamb) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzalw);
        zzhy.zzf(zza, zzamb);
        zzbk(2, zza);
    }
}
