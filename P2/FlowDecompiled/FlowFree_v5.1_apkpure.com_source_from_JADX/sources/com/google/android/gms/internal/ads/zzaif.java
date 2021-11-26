package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaif extends zzhw implements zzaih {
    zzaif(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    public final void zze(zzahx zzahx) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzahx);
        zzbj(1, zza);
    }
}
