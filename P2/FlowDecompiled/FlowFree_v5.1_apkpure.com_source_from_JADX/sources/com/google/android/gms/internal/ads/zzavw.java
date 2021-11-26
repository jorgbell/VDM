package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaq;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzavw extends zzhw implements zzavy {
    zzavw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    public final void zze(ParcelFileDescriptor parcelFileDescriptor) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, parcelFileDescriptor);
        zzbj(1, zza);
    }

    public final void zzf(zzaq zzaq) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzaq);
        zzbj(2, zza);
    }
}
