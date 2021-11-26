package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzais extends zzhw implements zzaiu {
    zzais(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    public final void zze(zzajd zzajd) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzajd);
        zzbj(1, zza);
    }
}
