package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzaqg extends zzhx implements zzaqh {
    public zzaqg() {
        super("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    public static zzaqh zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
        if (queryLocalInterface instanceof zzaqh) {
            return (zzaqh) queryLocalInterface;
        }
        return new zzaqf(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zze();
                break;
            case 2:
                zzf();
                break;
            case 3:
                zzg(parcel.readInt());
                break;
            case 4:
                zzh();
                break;
            case 5:
                zzi();
                break;
            case 6:
                zzj();
                break;
            case 7:
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationResponseMetadata");
                    if (queryLocalInterface instanceof zzaql) {
                        zzaql zzaql = (zzaql) queryLocalInterface;
                        break;
                    }
                }
                break;
            case 8:
                zzk();
                break;
            case 9:
                zzl(parcel.readString(), parcel.readString());
                break;
            case 10:
                zzahz.zzb(parcel.readStrongBinder());
                parcel.readString();
                break;
            case 11:
                zzn();
                break;
            case 12:
                parcel.readString();
                break;
            case 13:
                zzo();
                break;
            case 14:
                zzp((zzaxe) zzhy.zzc(parcel, zzaxe.CREATOR));
                break;
            case 15:
                zzq();
                break;
            case 16:
                zzr(zzaxh.zzb(parcel.readStrongBinder()));
                break;
            case 17:
                zzs(parcel.readInt());
                break;
            case 18:
                zzt();
                break;
            case 19:
                Bundle bundle = (Bundle) zzhy.zzc(parcel, Bundle.CREATOR);
                break;
            case 20:
                zzu();
                break;
            case 21:
                zzv(parcel.readString());
                break;
            case 22:
                zzw(parcel.readInt(), parcel.readString());
                break;
            case 23:
                zzx((zzym) zzhy.zzc(parcel, zzym.CREATOR));
                break;
            case 24:
                zzy((zzym) zzhy.zzc(parcel, zzym.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
