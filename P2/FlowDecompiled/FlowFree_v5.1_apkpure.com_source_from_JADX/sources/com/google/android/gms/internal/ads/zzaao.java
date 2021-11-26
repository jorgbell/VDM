package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzaao extends zzhw implements zzaaq {
    zzaao(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.os.IInterface] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzaan zze() throws android.os.RemoteException {
        /*
            r4 = this;
            android.os.Parcel r0 = r4.zza()
            r1 = 1
            android.os.Parcel r0 = r4.zzbi(r1, r0)
            android.os.IBinder r1 = r0.readStrongBinder()
            if (r1 != 0) goto L_0x0011
            r1 = 0
            goto L_0x0025
        L_0x0011:
            java.lang.String r2 = "com.google.android.gms.ads.internal.client.IAdLoader"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzaan
            if (r3 == 0) goto L_0x001f
            r1 = r2
            com.google.android.gms.internal.ads.zzaan r1 = (com.google.android.gms.internal.ads.zzaan) r1
            goto L_0x0025
        L_0x001f:
            com.google.android.gms.internal.ads.zzaal r2 = new com.google.android.gms.internal.ads.zzaal
            r2.<init>(r1)
            r1 = r2
        L_0x0025:
            r0.recycle()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaao.zze():com.google.android.gms.internal.ads.zzaan");
    }

    public final void zzf(zzaah zzaah) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaah);
        zzbj(2, zza);
    }

    public final void zzi(String str, zzain zzain, zzaik zzaik) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzhy.zzf(zza, zzain);
        zzhy.zzf(zza, zzaik);
        zzbj(5, zza);
    }

    public final void zzj(zzagy zzagy) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzd(zza, zzagy);
        zzbj(6, zza);
    }

    public final void zzm(zzaiu zzaiu) throws RemoteException {
        Parcel zza = zza();
        zzhy.zzf(zza, zzaiu);
        zzbj(10, zza);
    }
}
