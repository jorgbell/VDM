package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzahz extends zzhx implements zzaia {
    public zzahz() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzaia zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        if (queryLocalInterface instanceof zzaia) {
            return (zzaia) queryLocalInterface;
        }
        return new zzahy(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zzbA(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                String zze = zze(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(zze);
                return true;
            case 2:
                zzahk zzf = zzf(parcel.readString());
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzf);
                return true;
            case 3:
                List<String> zzg = zzg();
                parcel2.writeNoException();
                parcel2.writeStringList(zzg);
                return true;
            case 4:
                String zzh = zzh();
                parcel2.writeNoException();
                parcel2.writeString(zzh);
                return true;
            case 5:
                zzi(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                zzj();
                parcel2.writeNoException();
                return true;
            case 7:
                zzacj zzk = zzk();
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzk);
                return true;
            case 8:
                zzl();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper zzm = zzm();
                parcel2.writeNoException();
                zzhy.zzf(parcel2, zzm);
                return true;
            case 10:
                boolean zzn = zzn(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzhy.zzb(parcel2, zzn);
                return true;
            case 11:
                parcel2.writeNoException();
                zzhy.zzf(parcel2, (IInterface) null);
                return true;
            case 12:
                boolean zzo = zzo();
                parcel2.writeNoException();
                zzhy.zzb(parcel2, zzo);
                return true;
            case 13:
                boolean zzp = zzp();
                parcel2.writeNoException();
                zzhy.zzb(parcel2, zzp);
                return true;
            case 14:
                zzq(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                parcel2.writeNoException();
                return true;
            case 15:
                zzr();
                parcel2.writeNoException();
                return true;
            default:
                return false;
        }
    }
}
