package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaqc extends zzhw implements zzaqe {
    zzaqc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    public final void zzA(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzb(zza, z);
        zzbj(25, zza);
    }

    public final zzacj zzB() throws RemoteException {
        Parcel zzbi = zzbi(26, zza());
        zzacj zzb = zzaci.zzb(zzbi.readStrongBinder());
        zzbi.recycle();
        return zzb;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaqq zzC() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 27
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaqq
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaqq r1 = (com.google.android.gms.internal.ads.zzaqq) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaqo r2 = new com.google.android.gms.internal.ads.zzaqo
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqc.zzC():com.google.android.gms.internal.ads.zzaqq");
    }

    public final void zzD(IObjectWrapper iObjectWrapper, zzys zzys, String str, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzys);
        zza.writeString(str);
        zzhy.zzf(zza, zzaqh);
        zzbj(28, zza);
    }

    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(30, zza);
    }

    public final void zzF(IObjectWrapper iObjectWrapper, zzamn zzamn, List<zzamt> list) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzamn);
        zza.writeTypedList(list);
        zzbj(31, zza);
    }

    public final void zzG(IObjectWrapper iObjectWrapper, zzys zzys, String str, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzys);
        zza.writeString(str);
        zzhy.zzf(zza, zzaqh);
        zzbj(32, zza);
    }

    public final zzasv zzH() throws RemoteException {
        Parcel zzbi = zzbi(33, zza());
        zzasv zzasv = (zzasv) zzhy.zzc(zzbi, zzasv.CREATOR);
        zzbi.recycle();
        return zzasv;
    }

    public final zzasv zzI() throws RemoteException {
        Parcel zzbi = zzbi(34, zza());
        zzasv zzasv = (zzasv) zzhy.zzc(zzbi, zzasv.CREATOR);
        zzbi.recycle();
        return zzasv;
    }

    public final void zzJ(IObjectWrapper iObjectWrapper, zzyx zzyx, zzys zzys, String str, String str2, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzyx);
        zzhy.zzd(zza, zzys);
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzf(zza, zzaqh);
        zzbj(35, zza);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaqk zzK() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 36
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaqk
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaqk r1 = (com.google.android.gms.internal.ads.zzaqk) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaqi r2 = new com.google.android.gms.internal.ads.zzaqi
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqc.zzK():com.google.android.gms.internal.ads.zzaqk");
    }

    public final void zzL(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(37, zza);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaqm zzM() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 15
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaqm
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaqm r1 = (com.google.android.gms.internal.ads.zzaqm) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaqm r2 = new com.google.android.gms.internal.ads.zzaqm
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqc.zzM():com.google.android.gms.internal.ads.zzaqm");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaqn zzN() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 16
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0012
            r1 = 0
            goto L_0x0026
        L_0x0012:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaqn
            if (r3 == 0) goto L_0x0020
            r1 = r2
            com.google.android.gms.internal.ads.zzaqn r1 = (com.google.android.gms.internal.ads.zzaqn) r1
            goto L_0x0026
        L_0x0020:
            com.google.android.gms.internal.ads.zzaqn r2 = new com.google.android.gms.internal.ads.zzaqn
            r2.<init>(r1)
            r1 = r2
        L_0x0026:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqc.zzN():com.google.android.gms.internal.ads.zzaqn");
    }

    public final IObjectWrapper zzf() throws RemoteException {
        Parcel zzbi = zzbi(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbi.readStrongBinder());
        zzbi.recycle();
        return asInterface;
    }

    public final void zzh() throws RemoteException {
        zzbj(4, zza());
    }

    public final void zzi() throws RemoteException {
        zzbj(5, zza());
    }

    public final void zzj(IObjectWrapper iObjectWrapper, zzyx zzyx, zzys zzys, String str, String str2, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzyx);
        zzhy.zzd(zza, zzys);
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzf(zza, zzaqh);
        zzbj(6, zza);
    }

    public final void zzk(IObjectWrapper iObjectWrapper, zzys zzys, String str, String str2, zzaqh zzaqh) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzys);
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzf(zza, zzaqh);
        zzbj(7, zza);
    }

    public final void zzl() throws RemoteException {
        zzbj(8, zza());
    }

    public final void zzm() throws RemoteException {
        zzbj(9, zza());
    }

    public final void zzn(IObjectWrapper iObjectWrapper, zzys zzys, String str, zzaxd zzaxd, String str2) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzys);
        zza.writeString((String) null);
        zzhy.zzf(zza, zzaxd);
        zza.writeString(str2);
        zzbj(10, zza);
    }

    public final void zzo(zzys zzys, String str) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzys);
        zza.writeString(str);
        zzbj(11, zza);
    }

    public final void zzp() throws RemoteException {
        zzbj(12, zza());
    }

    public final boolean zzq() throws RemoteException {
        Parcel zzbi = zzbi(13, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzys zzys, String str, String str2, zzaqh zzaqh, zzagy zzagy, List<String> list) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzd(zza, zzys);
        zza.writeString(str);
        zza.writeString(str2);
        zzhy.zzf(zza, zzaqh);
        zzhy.zzd(zza, zzagy);
        zza.writeStringList(list);
        zzbj(14, zza);
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzbj(21, zza);
    }

    public final boolean zzx() throws RemoteException {
        Parcel zzbi = zzbi(22, zza());
        boolean zza = zzhy.zza(zzbi);
        zzbi.recycle();
        return zza;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzaxd zzaxd, List<String> list) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, iObjectWrapper);
        zzhy.zzf(zza, zzaxd);
        zza.writeStringList(list);
        zzbj(23, zza);
    }
}
