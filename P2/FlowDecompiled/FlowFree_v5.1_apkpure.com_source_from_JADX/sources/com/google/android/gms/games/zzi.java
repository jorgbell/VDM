package com.google.android.gms.games;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public class zzi implements Parcelable.Creator<PlayerEntity> {
    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v7, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v8, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v9, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v10, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.games.PlayerEntity zzc(android.os.Parcel r36) {
        /*
            r35 = this;
            r0 = r36
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r36)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = -1
            r13 = r2
            r16 = r13
            r9 = r5
            r10 = r9
            r11 = r10
            r12 = r11
            r18 = r12
            r19 = r18
            r20 = r19
            r21 = r20
            r22 = r21
            r25 = r22
            r26 = r25
            r27 = r26
            r28 = r27
            r29 = r28
            r30 = r29
            r33 = r30
            r34 = r33
            r31 = r6
            r15 = 0
            r23 = 0
            r24 = 0
        L_0x0034:
            int r2 = r36.dataPosition()
            if (r2 >= r1) goto L_0x0106
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r36)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            r4 = 29
            if (r3 == r4) goto L_0x0100
            r4 = 33
            if (r3 == r4) goto L_0x00f4
            r4 = 35
            if (r3 == r4) goto L_0x00e8
            switch(r3) {
                case 1: goto L_0x00e2;
                case 2: goto L_0x00dc;
                case 3: goto L_0x00d1;
                case 4: goto L_0x00c6;
                case 5: goto L_0x00c0;
                case 6: goto L_0x00ba;
                case 7: goto L_0x00b4;
                case 8: goto L_0x00af;
                case 9: goto L_0x00aa;
                default: goto L_0x0051;
            }
        L_0x0051:
            switch(r3) {
                case 14: goto L_0x00a5;
                case 15: goto L_0x009a;
                case 16: goto L_0x008f;
                default: goto L_0x0054;
            }
        L_0x0054:
            switch(r3) {
                case 18: goto L_0x008a;
                case 19: goto L_0x0085;
                case 20: goto L_0x0080;
                case 21: goto L_0x007b;
                case 22: goto L_0x0070;
                case 23: goto L_0x006b;
                case 24: goto L_0x0060;
                case 25: goto L_0x005b;
                default: goto L_0x0057;
            }
        L_0x0057:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0034
        L_0x005b:
            java.lang.String r30 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x0060:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r29 = r2
            android.net.Uri r29 = (android.net.Uri) r29
            goto L_0x0034
        L_0x006b:
            java.lang.String r28 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x0070:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r27 = r2
            android.net.Uri r27 = (android.net.Uri) r27
            goto L_0x0034
        L_0x007b:
            java.lang.String r26 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x0080:
            java.lang.String r25 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x0085:
            boolean r24 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0034
        L_0x008a:
            boolean r23 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0034
        L_0x008f:
            android.os.Parcelable$Creator<com.google.android.gms.games.PlayerLevelInfo> r3 = com.google.android.gms.games.PlayerLevelInfo.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r22 = r2
            com.google.android.gms.games.PlayerLevelInfo r22 = (com.google.android.gms.games.PlayerLevelInfo) r22
            goto L_0x0034
        L_0x009a:
            android.os.Parcelable$Creator<com.google.android.gms.games.internal.player.MostRecentGameInfoEntity> r3 = com.google.android.gms.games.internal.player.MostRecentGameInfoEntity.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r21 = r2
            com.google.android.gms.games.internal.player.MostRecentGameInfoEntity r21 = (com.google.android.gms.games.internal.player.MostRecentGameInfoEntity) r21
            goto L_0x0034
        L_0x00a5:
            java.lang.String r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x00aa:
            java.lang.String r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x00af:
            java.lang.String r18 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x00b4:
            long r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0034
        L_0x00ba:
            int r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0034
        L_0x00c0:
            long r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0034
        L_0x00c6:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            android.net.Uri r12 = (android.net.Uri) r12
            goto L_0x0034
        L_0x00d1:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r11 = r2
            android.net.Uri r11 = (android.net.Uri) r11
            goto L_0x0034
        L_0x00dc:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x00e2:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0034
        L_0x00e8:
            android.os.Parcelable$Creator<com.google.android.gms.games.zza> r3 = com.google.android.gms.games.zza.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r34 = r2
            com.google.android.gms.games.zza r34 = (com.google.android.gms.games.zza) r34
            goto L_0x0034
        L_0x00f4:
            android.os.Parcelable$Creator<com.google.android.gms.games.zzm> r3 = com.google.android.gms.games.zzm.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r33 = r2
            com.google.android.gms.games.zzm r33 = (com.google.android.gms.games.zzm) r33
            goto L_0x0034
        L_0x0100:
            long r31 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0034
        L_0x0106:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.games.PlayerEntity r0 = new com.google.android.gms.games.PlayerEntity
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13, r15, r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r33, r34)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.zzi.zzc(android.os.Parcel):com.google.android.gms.games.PlayerEntity");
    }

    public /* synthetic */ Object[] newArray(int i) {
        return new PlayerEntity[i];
    }
}
