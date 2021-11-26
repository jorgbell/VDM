package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzash extends zzhx implements zzasi {
    public zzash() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzasi zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        if (queryLocalInterface instanceof zzasi) {
            return (zzasi) queryLocalInterface;
        }
        return new zzasg(iBinder);
    }

    /* JADX WARNING: type inference failed for: r2v5, types: [com.google.android.gms.internal.ads.zzarw] */
    /* JADX WARNING: type inference failed for: r2v10, types: [com.google.android.gms.internal.ads.zzarx] */
    /* JADX WARNING: type inference failed for: r2v11, types: [com.google.android.gms.internal.ads.zzarz] */
    /* JADX WARNING: type inference failed for: r5v8, types: [com.google.android.gms.internal.ads.zzarz] */
    /* JADX WARNING: type inference failed for: r2v15, types: [com.google.android.gms.internal.ads.zzasd] */
    /* JADX WARNING: type inference failed for: r2v16, types: [com.google.android.gms.internal.ads.zzasf] */
    /* JADX WARNING: type inference failed for: r5v10, types: [com.google.android.gms.internal.ads.zzasf] */
    /* JADX WARNING: type inference failed for: r2v20, types: [com.google.android.gms.internal.ads.zzasa] */
    /* JADX WARNING: type inference failed for: r2v21, types: [com.google.android.gms.internal.ads.zzasc] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzasc] */
    /* JADX WARNING: type inference failed for: r2v25, types: [com.google.android.gms.internal.ads.zzasd] */
    /* JADX WARNING: type inference failed for: r2v26, types: [com.google.android.gms.internal.ads.zzasf] */
    /* JADX WARNING: type inference failed for: r5v14, types: [com.google.android.gms.internal.ads.zzasf] */
    /* JADX WARNING: type inference failed for: r2v31, types: [com.google.android.gms.internal.ads.zzarw] */
    /* JADX WARNING: type inference failed for: r2v35, types: [com.google.android.gms.internal.ads.zzasa] */
    /* JADX WARNING: type inference failed for: r2v36, types: [com.google.android.gms.internal.ads.zzasc] */
    /* JADX WARNING: type inference failed for: r5v18, types: [com.google.android.gms.internal.ads.zzasc] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbA(int r15, android.os.Parcel r16, android.os.Parcel r17, int r18) throws android.os.RemoteException {
        /*
            r14 = this;
            r8 = r14
            r0 = r15
            r1 = r16
            r9 = r17
            r10 = 1
            r2 = 0
            if (r0 == r10) goto L_0x02a5
            r3 = 2
            if (r0 == r3) goto L_0x02a1
            r3 = 3
            if (r0 == r3) goto L_0x029d
            r3 = 5
            if (r0 == r3) goto L_0x0292
            r3 = 10
            if (r0 == r3) goto L_0x0287
            r3 = 11
            if (r0 == r3) goto L_0x0277
            java.lang.String r3 = "com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback"
            java.lang.String r4 = "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback"
            java.lang.String r5 = "com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback"
            switch(r0) {
                case 13: goto L_0x0225;
                case 14: goto L_0x01da;
                case 15: goto L_0x01c6;
                case 16: goto L_0x017d;
                case 17: goto L_0x0169;
                case 18: goto L_0x0120;
                case 19: goto L_0x0114;
                case 20: goto L_0x00cb;
                case 21: goto L_0x0079;
                case 22: goto L_0x0026;
                default: goto L_0x0024;
            }
        L_0x0024:
            r0 = 0
            return r0
        L_0x0026:
            java.lang.String r4 = r16.readString()
            java.lang.String r5 = r16.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r0 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzys r6 = (com.google.android.gms.internal.ads.zzys) r6
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x0047
        L_0x0045:
            r11 = r2
            goto L_0x0058
        L_0x0047:
            android.os.IInterface r2 = r0.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzasc
            if (r3 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzasc r2 = (com.google.android.gms.internal.ads.zzasc) r2
            goto L_0x0045
        L_0x0052:
            com.google.android.gms.internal.ads.zzasa r2 = new com.google.android.gms.internal.ads.zzasa
            r2.<init>(r0)
            goto L_0x0045
        L_0x0058:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqh r12 = com.google.android.gms.internal.ads.zzaqg.zzb(r0)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzagy> r0 = com.google.android.gms.internal.ads.zzagy.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r13 = r0
            com.google.android.gms.internal.ads.zzagy r13 = (com.google.android.gms.internal.ads.zzagy) r13
            r0 = r14
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r11
            r6 = r12
            r7 = r13
            r0.zzr(r1, r2, r3, r4, r5, r6, r7)
            r17.writeNoException()
            goto L_0x02f1
        L_0x0079:
            java.lang.String r3 = r16.readString()
            java.lang.String r4 = r16.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r0 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzys r6 = (com.google.android.gms.internal.ads.zzys) r6
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x009a
        L_0x0098:
            r5 = r2
            goto L_0x00ab
        L_0x009a:
            android.os.IInterface r2 = r0.queryLocalInterface(r5)
            boolean r5 = r2 instanceof com.google.android.gms.internal.ads.zzarw
            if (r5 == 0) goto L_0x00a5
            com.google.android.gms.internal.ads.zzarw r2 = (com.google.android.gms.internal.ads.zzarw) r2
            goto L_0x0098
        L_0x00a5:
            com.google.android.gms.internal.ads.zzaru r2 = new com.google.android.gms.internal.ads.zzaru
            r2.<init>(r0)
            goto L_0x0098
        L_0x00ab:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqh r11 = com.google.android.gms.internal.ads.zzaqg.zzb(r0)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyx> r0 = com.google.android.gms.internal.ads.zzyx.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r12 = r0
            com.google.android.gms.internal.ads.zzyx r12 = (com.google.android.gms.internal.ads.zzyx) r12
            r0 = r14
            r1 = r3
            r2 = r4
            r3 = r6
            r4 = r7
            r6 = r11
            r7 = r12
            r0.zzq(r1, r2, r3, r4, r5, r6, r7)
            r17.writeNoException()
            goto L_0x02f1
        L_0x00cb:
            java.lang.String r3 = r16.readString()
            java.lang.String r5 = r16.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r0 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzys r6 = (com.google.android.gms.internal.ads.zzys) r6
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x00ec
        L_0x00ea:
            r11 = r2
            goto L_0x00fd
        L_0x00ec:
            android.os.IInterface r2 = r0.queryLocalInterface(r4)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzasf
            if (r4 == 0) goto L_0x00f7
            com.google.android.gms.internal.ads.zzasf r2 = (com.google.android.gms.internal.ads.zzasf) r2
            goto L_0x00ea
        L_0x00f7:
            com.google.android.gms.internal.ads.zzasd r2 = new com.google.android.gms.internal.ads.zzasd
            r2.<init>(r0)
            goto L_0x00ea
        L_0x00fd:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqh r12 = com.google.android.gms.internal.ads.zzaqg.zzb(r0)
            r0 = r14
            r1 = r3
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r11
            r6 = r12
            r0.zzp(r1, r2, r3, r4, r5, r6)
            r17.writeNoException()
            goto L_0x02f1
        L_0x0114:
            java.lang.String r0 = r16.readString()
            r14.zzo(r0)
            r17.writeNoException()
            goto L_0x02f1
        L_0x0120:
            java.lang.String r4 = r16.readString()
            java.lang.String r5 = r16.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r0 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzys r6 = (com.google.android.gms.internal.ads.zzys) r6
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x0141
        L_0x013f:
            r11 = r2
            goto L_0x0152
        L_0x0141:
            android.os.IInterface r2 = r0.queryLocalInterface(r3)
            boolean r3 = r2 instanceof com.google.android.gms.internal.ads.zzasc
            if (r3 == 0) goto L_0x014c
            com.google.android.gms.internal.ads.zzasc r2 = (com.google.android.gms.internal.ads.zzasc) r2
            goto L_0x013f
        L_0x014c:
            com.google.android.gms.internal.ads.zzasa r2 = new com.google.android.gms.internal.ads.zzasa
            r2.<init>(r0)
            goto L_0x013f
        L_0x0152:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqh r12 = com.google.android.gms.internal.ads.zzaqg.zzb(r0)
            r0 = r14
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r11
            r6 = r12
            r0.zzn(r1, r2, r3, r4, r5, r6)
            r17.writeNoException()
            goto L_0x02f1
        L_0x0169:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r14.zzm(r0)
            r17.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzb(r9, r0)
            goto L_0x02f1
        L_0x017d:
            java.lang.String r3 = r16.readString()
            java.lang.String r5 = r16.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r0 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzys r6 = (com.google.android.gms.internal.ads.zzys) r6
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x019e
        L_0x019c:
            r11 = r2
            goto L_0x01af
        L_0x019e:
            android.os.IInterface r2 = r0.queryLocalInterface(r4)
            boolean r4 = r2 instanceof com.google.android.gms.internal.ads.zzasf
            if (r4 == 0) goto L_0x01a9
            com.google.android.gms.internal.ads.zzasf r2 = (com.google.android.gms.internal.ads.zzasf) r2
            goto L_0x019c
        L_0x01a9:
            com.google.android.gms.internal.ads.zzasd r2 = new com.google.android.gms.internal.ads.zzasd
            r2.<init>(r0)
            goto L_0x019c
        L_0x01af:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqh r12 = com.google.android.gms.internal.ads.zzaqg.zzb(r0)
            r0 = r14
            r1 = r3
            r2 = r5
            r3 = r6
            r4 = r7
            r5 = r11
            r6 = r12
            r0.zzl(r1, r2, r3, r4, r5, r6)
            r17.writeNoException()
            goto L_0x02f1
        L_0x01c6:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            boolean r0 = r14.zzk(r0)
            r17.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzb(r9, r0)
            goto L_0x02f1
        L_0x01da:
            java.lang.String r3 = r16.readString()
            java.lang.String r4 = r16.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r0 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r5 = r0
            com.google.android.gms.internal.ads.zzys r5 = (com.google.android.gms.internal.ads.zzys) r5
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r6 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x01fb
        L_0x01f9:
            r7 = r2
            goto L_0x020e
        L_0x01fb:
            java.lang.String r2 = "com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback"
            android.os.IInterface r2 = r0.queryLocalInterface(r2)
            boolean r7 = r2 instanceof com.google.android.gms.internal.ads.zzarz
            if (r7 == 0) goto L_0x0208
            com.google.android.gms.internal.ads.zzarz r2 = (com.google.android.gms.internal.ads.zzarz) r2
            goto L_0x01f9
        L_0x0208:
            com.google.android.gms.internal.ads.zzarx r2 = new com.google.android.gms.internal.ads.zzarx
            r2.<init>(r0)
            goto L_0x01f9
        L_0x020e:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqh r11 = com.google.android.gms.internal.ads.zzaqg.zzb(r0)
            r0 = r14
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zzj(r1, r2, r3, r4, r5, r6)
            r17.writeNoException()
            goto L_0x02f1
        L_0x0225:
            java.lang.String r3 = r16.readString()
            java.lang.String r4 = r16.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r0 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r6 = r0
            com.google.android.gms.internal.ads.zzys r6 = (com.google.android.gms.internal.ads.zzys) r6
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r7 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x0246
        L_0x0244:
            r5 = r2
            goto L_0x0257
        L_0x0246:
            android.os.IInterface r2 = r0.queryLocalInterface(r5)
            boolean r5 = r2 instanceof com.google.android.gms.internal.ads.zzarw
            if (r5 == 0) goto L_0x0251
            com.google.android.gms.internal.ads.zzarw r2 = (com.google.android.gms.internal.ads.zzarw) r2
            goto L_0x0244
        L_0x0251:
            com.google.android.gms.internal.ads.zzaru r2 = new com.google.android.gms.internal.ads.zzaru
            r2.<init>(r0)
            goto L_0x0244
        L_0x0257:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.internal.ads.zzaqh r11 = com.google.android.gms.internal.ads.zzaqg.zzb(r0)
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyx> r0 = com.google.android.gms.internal.ads.zzyx.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r12 = r0
            com.google.android.gms.internal.ads.zzyx r12 = (com.google.android.gms.internal.ads.zzyx) r12
            r0 = r14
            r1 = r3
            r2 = r4
            r3 = r6
            r4 = r7
            r6 = r11
            r7 = r12
            r0.zzi(r1, r2, r3, r4, r5, r6, r7)
            r17.writeNoException()
            goto L_0x02f1
        L_0x0277:
            r16.createStringArray()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            java.lang.Object[] r0 = r1.createTypedArray(r0)
            android.os.Bundle[] r0 = (android.os.Bundle[]) r0
            r17.writeNoException()
            goto L_0x02f1
        L_0x0287:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            r17.writeNoException()
            goto L_0x02f1
        L_0x0292:
            com.google.android.gms.internal.ads.zzacj r0 = r14.zzh()
            r17.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzf(r9, r0)
            goto L_0x02f1
        L_0x029d:
            r14.zzg()
            throw r2
        L_0x02a1:
            r14.zzf()
            throw r2
        L_0x02a5:
            android.os.IBinder r0 = r16.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r0)
            java.lang.String r4 = r16.readString()
            android.os.Parcelable$Creator r0 = android.os.Bundle.CREATOR
            android.os.Parcelable r5 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            android.os.Bundle r5 = (android.os.Bundle) r5
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r6 = r0
            android.os.Bundle r6 = (android.os.Bundle) r6
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyx> r0 = com.google.android.gms.internal.ads.zzyx.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.ads.zzhy.zzc(r1, r0)
            r7 = r0
            com.google.android.gms.internal.ads.zzyx r7 = (com.google.android.gms.internal.ads.zzyx) r7
            android.os.IBinder r0 = r16.readStrongBinder()
            if (r0 != 0) goto L_0x02d1
            r11 = r2
            goto L_0x02e4
        L_0x02d1:
            java.lang.String r1 = "com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback"
            android.os.IInterface r1 = r0.queryLocalInterface(r1)
            boolean r2 = r1 instanceof com.google.android.gms.internal.ads.zzasl
            if (r2 == 0) goto L_0x02de
            com.google.android.gms.internal.ads.zzasl r1 = (com.google.android.gms.internal.ads.zzasl) r1
            goto L_0x02e3
        L_0x02de:
            com.google.android.gms.internal.ads.zzasj r1 = new com.google.android.gms.internal.ads.zzasj
            r1.<init>(r0)
        L_0x02e3:
            r11 = r1
        L_0x02e4:
            r0 = r14
            r1 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r5 = r7
            r6 = r11
            r0.zze(r1, r2, r3, r4, r5, r6)
            r17.writeNoException()
        L_0x02f1:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzash.zzbA(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
