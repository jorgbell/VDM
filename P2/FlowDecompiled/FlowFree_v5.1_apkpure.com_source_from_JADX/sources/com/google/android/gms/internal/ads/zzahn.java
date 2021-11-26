package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzahn extends zzhx implements zzaho {
    public zzahn() {
        super("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    public static zzaho zzbz(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
        if (queryLocalInterface instanceof zzaho) {
            return (zzaho) queryLocalInterface;
        }
        return new zzahm(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbA(int r1, android.os.Parcel r2, android.os.Parcel r3, int r4) throws android.os.RemoteException {
        /*
            r0 = this;
            switch(r1) {
                case 1: goto L_0x0089;
                case 2: goto L_0x007a;
                case 3: goto L_0x006b;
                case 4: goto L_0x0064;
                case 5: goto L_0x0056;
                case 6: goto L_0x0047;
                case 7: goto L_0x0038;
                case 8: goto L_0x0015;
                case 9: goto L_0x0005;
                default: goto L_0x0003;
            }
        L_0x0003:
            r1 = 0
            return r1
        L_0x0005:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzbv(r1)
            r3.writeNoException()
            goto L_0x009b
        L_0x0015:
            android.os.IBinder r1 = r2.readStrongBinder()
            if (r1 != 0) goto L_0x001d
            r1 = 0
            goto L_0x0031
        L_0x001d:
            java.lang.String r2 = "com.google.android.gms.ads.internal.formats.client.IMediaContent"
            android.os.IInterface r2 = r1.queryLocalInterface(r2)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzahh
            if (r4 == 0) goto L_0x002b
            r1 = r2
            com.google.android.gms.internal.ads.zzahh r1 = (com.google.android.gms.internal.ads.zzahh) r1
            goto L_0x0031
        L_0x002b:
            com.google.android.gms.internal.ads.zzahf r2 = new com.google.android.gms.internal.ads.zzahf
            r2.<init>(r1)
            r1 = r2
        L_0x0031:
            r0.zzbx(r1)
            r3.writeNoException()
            goto L_0x009b
        L_0x0038:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzbw(r1)
            r3.writeNoException()
            goto L_0x009b
        L_0x0047:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzg(r1)
            r3.writeNoException()
            goto L_0x009b
        L_0x0056:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r2.readInt()
            r3.writeNoException()
            goto L_0x009b
        L_0x0064:
            r0.zze()
            r3.writeNoException()
            goto L_0x009b
        L_0x006b:
            android.os.IBinder r1 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r1 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r1)
            r0.zzd(r1)
            r3.writeNoException()
            goto L_0x009b
        L_0x007a:
            java.lang.String r1 = r2.readString()
            com.google.android.gms.dynamic.IObjectWrapper r1 = r0.zzc(r1)
            r3.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzf(r3, r1)
            goto L_0x009b
        L_0x0089:
            java.lang.String r1 = r2.readString()
            android.os.IBinder r2 = r2.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r0.zzb(r1, r2)
            r3.writeNoException()
        L_0x009b:
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahn.zzbA(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
