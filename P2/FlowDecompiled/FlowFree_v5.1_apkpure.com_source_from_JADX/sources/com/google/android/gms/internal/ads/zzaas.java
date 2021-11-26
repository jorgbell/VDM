package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaas extends zzhw implements zzaau {
    zzaas(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdManager");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzacj zzE() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 26
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IVideoController"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzacj
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzacj r1 = (com.google.android.gms.internal.ads.zzacj) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzach r2 = new com.google.android.gms.internal.ads.zzach
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaas.zzE():com.google.android.gms.internal.ads.zzacj");
    }

    public final void zzF(zzady zzady) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzady);
        zzbj(29, zza);
    }

    public final void zzJ(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzb(zza, z);
        zzbj(34, zza);
    }

    public final void zzO(zzacd zzacd) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzacd);
        zzbj(42, zza);
    }

    public final void zzP(zzys zzys, zzaak zzaak) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zzhy.zzf(zza, zzaak);
        zzbj(43, zza);
    }

    public final void zzQ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(44, zza);
    }

    public final void zzR(zzabi zzabi) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzabi);
        zzbj(45, zza);
    }

    public final IObjectWrapper zzb() throws RemoteException {
        Parcel zzbi = zzbi(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final void zzc() throws RemoteException {
        zzbj(2, zza());
    }

    public final boolean zze(zzys zzys) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        Parcel zzbi = zzbi(4, zza);
        boolean zza2 = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza2;
    }

    public final void zzf() throws RemoteException {
        zzbj(5, zza());
    }

    public final void zzg() throws RemoteException {
        zzbj(6, zza());
    }

    public final void zzh(zzaah zzaah) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaah);
        zzbj(7, zza);
    }

    public final void zzi(zzabb zzabb) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzabb);
        zzbj(8, zza);
    }

    public final zzyx zzn() throws RemoteException {
        Parcel zzbi = zzbi(12, zza());
        zzyx zzyx = (zzyx) zzhy.zzc(zzbi, zzyx.CREATOR);
        zzbi.recycle();
        return zzyx;
    }

    public final void zzo(zzyx zzyx) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzyx);
        zzbj(13, zza);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzacg zzt() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 41
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IResponseInfo"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzacg
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzacg r1 = (com.google.android.gms.internal.ads.zzacg) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzace r2 = new com.google.android.gms.internal.ads.zzace
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaas.zzt():com.google.android.gms.internal.ads.zzacg");
    }

    public final String zzu() throws RemoteException {
        Parcel zzbi = zzbi(31, zza());
        String readString = zzbi.readString();
        zzbi.recycle();
        return readString;
    }

    public final void zzy(zzaae zzaae) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaae);
        zzbj(20, zza);
    }

    public final void zzz(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzb(zza, z);
        zzbj(22, zza);
    }
}
