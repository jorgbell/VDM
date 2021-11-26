package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzavt extends zzhx implements zzavu {
    public zzavt() {
        super("com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        zzavy zzavy = null;
        if (i == 1) {
            zzavo zzavo = (zzavo) zzhy.zzc(parcel, zzavo.CREATOR);
            parcel2.writeNoException();
            zzhy.zze(parcel2, (Parcelable) null);
        } else if (i == 2) {
            zzavo zzavo2 = (zzavo) zzhy.zzc(parcel, zzavo.CREATOR);
            IBinder readStrongBinder = parcel.readStrongBinder();
            if (readStrongBinder != null) {
                IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.request.IAdResponseListener");
                if (queryLocalInterface instanceof zzavv) {
                    zzavv zzavv = (zzavv) queryLocalInterface;
                }
            }
            parcel2.writeNoException();
        } else if (i == 4) {
            zzawc zzawc = (zzawc) zzhy.zzc(parcel, zzawc.CREATOR);
            IBinder readStrongBinder2 = parcel.readStrongBinder();
            if (readStrongBinder2 != null) {
                IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface2 instanceof zzavy) {
                    zzavy = (zzavy) queryLocalInterface2;
                } else {
                    zzavy = new zzavw(readStrongBinder2);
                }
            }
            zze(zzawc, zzavy);
            parcel2.writeNoException();
        } else if (i == 5) {
            zzawc zzawc2 = (zzawc) zzhy.zzc(parcel, zzawc.CREATOR);
            IBinder readStrongBinder3 = parcel.readStrongBinder();
            if (readStrongBinder3 != null) {
                IInterface queryLocalInterface3 = readStrongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface3 instanceof zzavy) {
                    zzavy = (zzavy) queryLocalInterface3;
                } else {
                    zzavy = new zzavw(readStrongBinder3);
                }
            }
            zzf(zzawc2, zzavy);
            parcel2.writeNoException();
        } else if (i == 6) {
            zzawc zzawc3 = (zzawc) zzhy.zzc(parcel, zzawc.CREATOR);
            IBinder readStrongBinder4 = parcel.readStrongBinder();
            if (readStrongBinder4 != null) {
                IInterface queryLocalInterface4 = readStrongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface4 instanceof zzavy) {
                    zzavy = (zzavy) queryLocalInterface4;
                } else {
                    zzavy = new zzavw(readStrongBinder4);
                }
            }
            zzg(zzawc3, zzavy);
            parcel2.writeNoException();
        } else if (i != 7) {
            return false;
        } else {
            String readString = parcel.readString();
            IBinder readStrongBinder5 = parcel.readStrongBinder();
            if (readStrongBinder5 != null) {
                IInterface queryLocalInterface5 = readStrongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.request.INonagonStreamingResponseListener");
                if (queryLocalInterface5 instanceof zzavy) {
                    zzavy = (zzavy) queryLocalInterface5;
                } else {
                    zzavy = new zzavw(readStrongBinder5);
                }
            }
            zzh(readString, zzavy);
            parcel2.writeNoException();
        }
        return true;
    }
}
