package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

public final class zzep extends zza implements zzeo {
    zzep(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IDriveService");
    }

    public final void zza(zzad zzad) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, (Parcelable) zzad);
        zzb(16, zza);
    }
}
