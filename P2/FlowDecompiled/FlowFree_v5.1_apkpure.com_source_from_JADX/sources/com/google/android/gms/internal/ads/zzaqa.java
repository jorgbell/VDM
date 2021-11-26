package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzaqa extends zzhx implements zzaqb {
    public zzaqa() {
        super("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    public static zzaqb zzg(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        if (queryLocalInterface instanceof zzaqb) {
            return (zzaqb) queryLocalInterface;
        }
        return new zzapz(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzaqe zzb = zzb(parcel.readString());
            parcel2.writeNoException();
            zzhy.zzf(parcel2, zzb);
        } else if (i == 2) {
            boolean zzc = zzc(parcel.readString());
            parcel2.writeNoException();
            zzhy.zzb(parcel2, zzc);
        } else if (i == 3) {
            zzasi zzf = zzf(parcel.readString());
            parcel2.writeNoException();
            zzhy.zzf(parcel2, zzf);
        } else if (i != 4) {
            return false;
        } else {
            boolean zzd = zzd(parcel.readString());
            parcel2.writeNoException();
            zzhy.zzb(parcel2, zzd);
        }
        return true;
    }
}
