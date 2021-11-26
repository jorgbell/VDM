package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public abstract class zzaat extends zzhx implements zzaau {
    public zzaat() {
        super("com.google.android.gms.ads.internal.client.IAdManager");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: com.google.android.gms.internal.ads.zzabf} */
    /* JADX WARNING: type inference failed for: r5v1 */
    /* JADX WARNING: type inference failed for: r5v2, types: [com.google.android.gms.internal.ads.zzaah] */
    /* JADX WARNING: type inference failed for: r5v7, types: [com.google.android.gms.internal.ads.zzabb] */
    /* JADX WARNING: type inference failed for: r5v12, types: [com.google.android.gms.internal.ads.zzaae] */
    /* JADX WARNING: type inference failed for: r5v22, types: [com.google.android.gms.internal.ads.zzaay] */
    /* JADX WARNING: type inference failed for: r5v27, types: [com.google.android.gms.internal.ads.zzacd] */
    /* JADX WARNING: type inference failed for: r5v32, types: [com.google.android.gms.internal.ads.zzaak] */
    /* JADX WARNING: type inference failed for: r5v37, types: [com.google.android.gms.internal.ads.zzabi] */
    /* JADX WARNING: type inference failed for: r5v42 */
    /* JADX WARNING: type inference failed for: r5v43 */
    /* JADX WARNING: type inference failed for: r5v44 */
    /* JADX WARNING: type inference failed for: r5v45 */
    /* JADX WARNING: type inference failed for: r5v46 */
    /* JADX WARNING: type inference failed for: r5v47 */
    /* JADX WARNING: type inference failed for: r5v48 */
    /* JADX WARNING: type inference failed for: r5v49 */
    /* JADX WARNING: type inference failed for: r5v50 */
    /* JADX WARNING: type inference failed for: r5v51 */
    /* JADX WARNING: type inference failed for: r5v52 */
    /* JADX WARNING: type inference failed for: r5v53 */
    /* JADX WARNING: type inference failed for: r5v54 */
    /* JADX WARNING: type inference failed for: r5v55 */
    /* JADX WARNING: type inference failed for: r5v56 */
    /* JADX WARNING: type inference failed for: r5v57 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzbA(int r2, android.os.Parcel r3, android.os.Parcel r4, int r5) throws android.os.RemoteException {
        /*
            r1 = this;
            r5 = 0
            switch(r2) {
                case 1: goto L_0x02af;
                case 2: goto L_0x02a8;
                case 3: goto L_0x029d;
                case 4: goto L_0x028a;
                case 5: goto L_0x0283;
                case 6: goto L_0x027c;
                case 7: goto L_0x025b;
                case 8: goto L_0x023a;
                case 9: goto L_0x0232;
                case 10: goto L_0x022d;
                case 11: goto L_0x0225;
                case 12: goto L_0x0219;
                case 13: goto L_0x0209;
                case 14: goto L_0x01f9;
                case 15: goto L_0x01e5;
                case 16: goto L_0x0004;
                case 17: goto L_0x0004;
                case 18: goto L_0x01d9;
                case 19: goto L_0x01c9;
                case 20: goto L_0x01a7;
                case 21: goto L_0x0185;
                case 22: goto L_0x0179;
                case 23: goto L_0x016d;
                case 24: goto L_0x015d;
                case 25: goto L_0x0151;
                case 26: goto L_0x0145;
                case 27: goto L_0x0004;
                case 28: goto L_0x0004;
                case 29: goto L_0x0135;
                case 30: goto L_0x0125;
                case 31: goto L_0x0119;
                case 32: goto L_0x010d;
                case 33: goto L_0x0101;
                case 34: goto L_0x00f5;
                case 35: goto L_0x00e9;
                case 36: goto L_0x00c7;
                case 37: goto L_0x00bb;
                case 38: goto L_0x00af;
                case 39: goto L_0x009f;
                case 40: goto L_0x008f;
                case 41: goto L_0x0083;
                case 42: goto L_0x0061;
                case 43: goto L_0x0038;
                case 44: goto L_0x0028;
                case 45: goto L_0x0006;
                default: goto L_0x0004;
            }
        L_0x0004:
            r2 = 0
            return r2
        L_0x0006:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x000d
            goto L_0x0020
        L_0x000d:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IFullScreenContentCallback"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzabi
            if (r5 == 0) goto L_0x001b
            r5 = r3
            com.google.android.gms.internal.ads.zzabi r5 = (com.google.android.gms.internal.ads.zzabi) r5
            goto L_0x0020
        L_0x001b:
            com.google.android.gms.internal.ads.zzabg r5 = new com.google.android.gms.internal.ads.zzabg
            r5.<init>(r2)
        L_0x0020:
            r1.zzR(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0028:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(r2)
            r1.zzQ(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0038:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r2 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhy.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzys r2 = (com.google.android.gms.internal.ads.zzys) r2
            android.os.IBinder r3 = r3.readStrongBinder()
            if (r3 != 0) goto L_0x0047
            goto L_0x0059
        L_0x0047:
            java.lang.String r5 = "com.google.android.gms.ads.internal.client.IAdLoadCallback"
            android.os.IInterface r5 = r3.queryLocalInterface(r5)
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzaak
            if (r0 == 0) goto L_0x0054
            com.google.android.gms.internal.ads.zzaak r5 = (com.google.android.gms.internal.ads.zzaak) r5
            goto L_0x0059
        L_0x0054:
            com.google.android.gms.internal.ads.zzaai r5 = new com.google.android.gms.internal.ads.zzaai
            r5.<init>(r3)
        L_0x0059:
            r1.zzP(r2, r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0061:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0068
            goto L_0x007b
        L_0x0068:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IOnPaidEventListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzacd
            if (r5 == 0) goto L_0x0076
            r5 = r3
            com.google.android.gms.internal.ads.zzacd r5 = (com.google.android.gms.internal.ads.zzacd) r5
            goto L_0x007b
        L_0x0076:
            com.google.android.gms.internal.ads.zzacb r5 = new com.google.android.gms.internal.ads.zzacb
            r5.<init>(r2)
        L_0x007b:
            r1.zzO(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0083:
            com.google.android.gms.internal.ads.zzacg r2 = r1.zzt()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzf(r4, r2)
            goto L_0x02b9
        L_0x008f:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzte r2 = com.google.android.gms.internal.ads.zztd.zze(r2)
            r1.zzI(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x009f:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzzd> r2 = com.google.android.gms.internal.ads.zzzd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhy.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzzd r2 = (com.google.android.gms.internal.ads.zzzd) r2
            r1.zzH(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x00af:
            java.lang.String r2 = r3.readString()
            r1.zzD(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x00bb:
            android.os.Bundle r2 = r1.zzk()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zze(r4, r2)
            goto L_0x02b9
        L_0x00c7:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x00ce
            goto L_0x00e1
        L_0x00ce:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdMetadataListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzaay
            if (r5 == 0) goto L_0x00dc
            r5 = r3
            com.google.android.gms.internal.ads.zzaay r5 = (com.google.android.gms.internal.ads.zzaay) r5
            goto L_0x00e1
        L_0x00dc:
            com.google.android.gms.internal.ads.zzaaw r5 = new com.google.android.gms.internal.ads.zzaaw
            r5.<init>(r2)
        L_0x00e1:
            r1.zzj(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x00e9:
            java.lang.String r2 = r1.zzs()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02b9
        L_0x00f5:
            boolean r2 = com.google.android.gms.internal.ads.zzhy.zza(r3)
            r1.zzJ(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0101:
            com.google.android.gms.internal.ads.zzaah r2 = r1.zzw()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzf(r4, r2)
            goto L_0x02b9
        L_0x010d:
            com.google.android.gms.internal.ads.zzabb r2 = r1.zzv()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzf(r4, r2)
            goto L_0x02b9
        L_0x0119:
            java.lang.String r2 = r1.zzu()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02b9
        L_0x0125:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzacn> r2 = com.google.android.gms.internal.ads.zzacn.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhy.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzacn r2 = (com.google.android.gms.internal.ads.zzacn) r2
            r1.zzG(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0135:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzady> r2 = com.google.android.gms.internal.ads.zzady.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhy.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzady r2 = (com.google.android.gms.internal.ads.zzady) r2
            r1.zzF(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0145:
            com.google.android.gms.internal.ads.zzacj r2 = r1.zzE()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzf(r4, r2)
            goto L_0x02b9
        L_0x0151:
            java.lang.String r2 = r3.readString()
            r1.zzC(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x015d:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzawy r2 = com.google.android.gms.internal.ads.zzawx.zzb(r2)
            r1.zzB(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x016d:
            boolean r2 = r1.zzA()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzb(r4, r2)
            goto L_0x02b9
        L_0x0179:
            boolean r2 = com.google.android.gms.internal.ads.zzhy.zza(r3)
            r1.zzz(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0185:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x018c
            goto L_0x019f
        L_0x018c:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.ICorrelationIdProvider"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzabf
            if (r5 == 0) goto L_0x019a
            r5 = r3
            com.google.android.gms.internal.ads.zzabf r5 = (com.google.android.gms.internal.ads.zzabf) r5
            goto L_0x019f
        L_0x019a:
            com.google.android.gms.internal.ads.zzabf r5 = new com.google.android.gms.internal.ads.zzabf
            r5.<init>(r2)
        L_0x019f:
            r1.zzab(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01a7:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x01ae
            goto L_0x01c1
        L_0x01ae:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdClickListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzaae
            if (r5 == 0) goto L_0x01bc
            r5 = r3
            com.google.android.gms.internal.ads.zzaae r5 = (com.google.android.gms.internal.ads.zzaae) r5
            goto L_0x01c1
        L_0x01bc:
            com.google.android.gms.internal.ads.zzaac r5 = new com.google.android.gms.internal.ads.zzaac
            r5.<init>(r2)
        L_0x01c1:
            r1.zzy(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01c9:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzafl r2 = com.google.android.gms.internal.ads.zzafk.zzb(r2)
            r1.zzx(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01d9:
            java.lang.String r2 = r1.zzr()
            r4.writeNoException()
            r4.writeString(r2)
            goto L_0x02b9
        L_0x01e5:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzauv r2 = com.google.android.gms.internal.ads.zzauu.zzb(r2)
            java.lang.String r3 = r3.readString()
            r1.zzq(r2, r3)
            r4.writeNoException()
            goto L_0x02b9
        L_0x01f9:
            android.os.IBinder r2 = r3.readStrongBinder()
            com.google.android.gms.internal.ads.zzaus r2 = com.google.android.gms.internal.ads.zzaur.zzb(r2)
            r1.zzp(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0209:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzyx> r2 = com.google.android.gms.internal.ads.zzyx.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhy.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzyx r2 = (com.google.android.gms.internal.ads.zzyx) r2
            r1.zzo(r2)
            r4.writeNoException()
            goto L_0x02b9
        L_0x0219:
            com.google.android.gms.internal.ads.zzyx r2 = r1.zzn()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zze(r4, r2)
            goto L_0x02b9
        L_0x0225:
            r1.zzm()
            r4.writeNoException()
            goto L_0x02b9
        L_0x022d:
            r4.writeNoException()
            goto L_0x02b9
        L_0x0232:
            r1.zzl()
            r4.writeNoException()
            goto L_0x02b9
        L_0x023a:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0241
            goto L_0x0254
        L_0x0241:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAppEventListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzabb
            if (r5 == 0) goto L_0x024f
            r5 = r3
            com.google.android.gms.internal.ads.zzabb r5 = (com.google.android.gms.internal.ads.zzabb) r5
            goto L_0x0254
        L_0x024f:
            com.google.android.gms.internal.ads.zzaaz r5 = new com.google.android.gms.internal.ads.zzaaz
            r5.<init>(r2)
        L_0x0254:
            r1.zzi(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x025b:
            android.os.IBinder r2 = r3.readStrongBinder()
            if (r2 != 0) goto L_0x0262
            goto L_0x0275
        L_0x0262:
            java.lang.String r3 = "com.google.android.gms.ads.internal.client.IAdListener"
            android.os.IInterface r3 = r2.queryLocalInterface(r3)
            boolean r5 = r3 instanceof com.google.android.gms.internal.ads.zzaah
            if (r5 == 0) goto L_0x0270
            r5 = r3
            com.google.android.gms.internal.ads.zzaah r5 = (com.google.android.gms.internal.ads.zzaah) r5
            goto L_0x0275
        L_0x0270:
            com.google.android.gms.internal.ads.zzaaf r5 = new com.google.android.gms.internal.ads.zzaaf
            r5.<init>(r2)
        L_0x0275:
            r1.zzh(r5)
            r4.writeNoException()
            goto L_0x02b9
        L_0x027c:
            r1.zzg()
            r4.writeNoException()
            goto L_0x02b9
        L_0x0283:
            r1.zzf()
            r4.writeNoException()
            goto L_0x02b9
        L_0x028a:
            android.os.Parcelable$Creator<com.google.android.gms.internal.ads.zzys> r2 = com.google.android.gms.internal.ads.zzys.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.internal.ads.zzhy.zzc(r3, r2)
            com.google.android.gms.internal.ads.zzys r2 = (com.google.android.gms.internal.ads.zzys) r2
            boolean r2 = r1.zze(r2)
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzb(r4, r2)
            goto L_0x02b9
        L_0x029d:
            boolean r2 = r1.zzbI()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzb(r4, r2)
            goto L_0x02b9
        L_0x02a8:
            r1.zzc()
            r4.writeNoException()
            goto L_0x02b9
        L_0x02af:
            com.google.android.gms.dynamic.IObjectWrapper r2 = r1.zzb()
            r4.writeNoException()
            com.google.android.gms.internal.ads.zzhy.zzf(r4, r2)
        L_0x02b9:
            r2 = 1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaat.zzbA(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
