package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzabd extends zzhx implements zzabe {
    public zzabd() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzaau zzb = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzyx) zzhy.zzc(parcel, zzyx.CREATOR), parcel.readString(), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzb);
                return true;
            case 2:
                zzaau zzc = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzyx) zzhy.zzc(parcel, zzyx.CREATOR), parcel.readString(), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzc);
                return true;
            case 3:
                zzaaq zzd = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzd);
                return true;
            case 4:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, (IInterface) null);
                return true;
            case 5:
                zzaho zze = zze(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zze);
                return true;
            case 6:
                zzawv zzf = zzf(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzf);
                return true;
            case 7:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, (IInterface) null);
                return true;
            case 8:
                zzaul zzg = zzg(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzg);
                return true;
            case 9:
                zzabl zzh = zzh(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzh);
                return true;
            case 10:
                zzaau zzi = zzi(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzyx) zzhy.zzc(parcel, zzyx.CREATOR), parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzi);
                return true;
            case 11:
                zzahs zzj = zzj(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzj);
                return true;
            case 12:
                zzaxl zzk = zzk(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzk);
                return true;
            case 13:
                zzaau zzl = zzl(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzyx) zzhy.zzc(parcel, zzyx.CREATOR), parcel.readString(), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzl);
                return true;
            case 14:
                zzbag zzm = zzm(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzm);
                return true;
            case 15:
                zzatz zzn = zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzn);
                return true;
            case 16:
                zzaln zzo = zzo(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzaqa.zzg(parcel.readStrongBinder()), parcel.readInt(), zzalj.zzc(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzo);
                return true;
            default:
                return false;
        }
    }
}
