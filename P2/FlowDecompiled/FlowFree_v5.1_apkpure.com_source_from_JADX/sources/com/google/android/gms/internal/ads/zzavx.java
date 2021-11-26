package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzaq;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzavx extends zzhx implements zzavy {
    public zzavx() {
        super("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zze((ParcelFileDescriptor) zzhy.zzc(parcel, ParcelFileDescriptor.CREATOR));
        } else if (i != 2) {
            return false;
        } else {
            zzf((zzaq) zzhy.zzc(parcel, zzaq.CREATOR));
        }
        parcel2.writeNoException();
        return true;
    }
}
