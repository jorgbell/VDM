package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzabj extends zzhw implements zzabl {
    zzabj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    public final void zze() throws RemoteException {
        zzbj(1, zza());
    }

    public final void zzf(float f) throws RemoteException {
        Parcel zza = zza();
        zza.writeFloat(f);
        zzbj(2, zza);
    }

    public final void zzh(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzb(zza, z);
        zzbj(4, zza);
    }

    public final void zzj(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zza.writeString((String) null);
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(6, zza);
    }

    public final String zzm() throws RemoteException {
        Parcel zzbi = zzbi(9, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final void zzo(zzaqb zzaqb) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaqb);
        zzbj(11, zza);
    }

    public final void zzp(zzamq zzamq) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzamq);
        zzbj(12, zza);
    }

    public final List<zzamj> zzq() throws RemoteException {
        Parcel zzbi = zzbi(13, zza());
        ArrayList<zzamj> createTypedArrayList = zzbi.createTypedArrayList(zzamj.CREATOR);
        zzbi.recycle();
        return createTypedArrayList;
    }

    public final void zzr(zzads zzads) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzads);
        zzbj(14, zza);
    }
}
