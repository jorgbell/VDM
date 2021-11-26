package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzafj extends zzhw implements zzafl {
    zzafj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    public final void zze(zzafi zzafi) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzafi);
        zzbj(1, zza);
    }
}
