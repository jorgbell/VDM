package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaic extends zzhw implements zzaie {
    zzaic(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    public final void zze(zzahv zzahv) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzahv);
        zzbj(1, zza);
    }
}
