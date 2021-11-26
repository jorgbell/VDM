package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzasg extends zzhw implements zzasi {
    zzasg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public final void zze(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzyx zzyx, zzasl zzasl) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzhy.zzd(zza, bundle);
        zzhy.zzd(zza, bundle2);
        zzhy.zzd(zza, zzyx);
        zzhy.zzf(zza, zzasl);
        zzbj(1, zza);
    }

    public final zzasv zzf() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        zzasv zzasv = (zzasv) zzhy.zzc(zzbi, zzasv.CREATOR);
        zzbi.recycle();
        return zzasv;
    }

    public final zzasv zzg() throws RemoteException {
        Parcel zzbi = zzbi(3, zza());
        zzasv zzasv = (zzasv) zzhy.zzc(zzbi, zzasv.CREATOR);
        zzbi.recycle();
        return zzasv;
    }

    public final zzacj zzh() throws RemoteException {
        Parcel zzbi = zzbi(5, zza());
        zzacj zzb = zzaci.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    public final void zzi(String str, String str2, zzys zzys, IObjectWrapper iObjectWrapper, zzarw zzarw, zzaqh zzaqh, zzyx zzyx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzarw);
        zzhy.zzf(zza, zzaqh);
        zzhy.zzd(zza, zzyx);
        zzbj(13, zza);
    }

    public final void zzj(String str, String str2, zzys zzys, IObjectWrapper iObjectWrapper, zzarz zzarz, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzarz);
        zzhy.zzf(zza, zzaqh);
        zzbj(14, zza);
    }

    public final boolean zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        Parcel zzbi = zzbi(15, zza);
        boolean zza2 = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza2;
    }

    public final void zzl(String str, String str2, zzys zzys, IObjectWrapper iObjectWrapper, zzasf zzasf, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzasf);
        zzhy.zzf(zza, zzaqh);
        zzbj(16, zza);
    }

    public final boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        Parcel zzbi = zzbi(17, zza);
        boolean zza2 = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza2;
    }

    public final void zzn(String str, String str2, zzys zzys, IObjectWrapper iObjectWrapper, zzasc zzasc, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzasc);
        zzhy.zzf(zza, zzaqh);
        zzbj(18, zza);
    }

    public final void zzo(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbj(19, zza);
    }

    public final void zzp(String str, String str2, zzys zzys, IObjectWrapper iObjectWrapper, zzasf zzasf, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzasf);
        zzhy.zzf(zza, zzaqh);
        zzbj(20, zza);
    }

    public final void zzq(String str, String str2, zzys zzys, IObjectWrapper iObjectWrapper, zzarw zzarw, zzaqh zzaqh, zzyx zzyx) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzarw);
        zzhy.zzf(zza, zzaqh);
        zzhy.zzd(zza, zzyx);
        zzbj(21, zza);
    }

    public final void zzr(String str, String str2, zzys zzys, IObjectWrapper iObjectWrapper, zzasc zzasc, zzaqh zzaqh, zzagy zzagy) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzasc);
        zzhy.zzf(zza, zzaqh);
        zzhy.zzd(zza, zzagy);
        zzbj(22, zza);
    }
}
