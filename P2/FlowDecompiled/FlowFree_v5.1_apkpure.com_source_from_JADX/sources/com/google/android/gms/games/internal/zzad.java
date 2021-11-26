package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.games.zza;
import com.google.android.gms.internal.games.zzd;
import com.google.android.gms.internal.games.zzfi;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public abstract class zzad extends zza implements zzaa {
    public zzad() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        zzfi zzaf = zzaf();
        parcel2.writeNoException();
        zzd.zzb(parcel2, zzaf);
        return true;
    }
}
