package com.google.android.gms.games.achievement;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zza implements Parcelable.Creator<AchievementEntity> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AchievementEntity[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r29) {
        /*
            r28 = this;
            r0 = r29
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r29)
            r2 = 0
            r4 = 0
            r5 = 0
            r6 = -1082130432(0xffffffffbf800000, float:-1.0)
            r22 = r2
            r24 = r22
            r8 = r5
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r15 = r14
            r17 = r15
            r18 = r17
            r21 = r18
            r27 = r21
            r9 = 0
            r16 = 0
            r19 = 0
            r20 = 0
            r26 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x0028:
            int r2 = r29.dataPosition()
            if (r2 >= r1) goto L_0x00a7
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r29)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x00a2;
                case 2: goto L_0x009d;
                case 3: goto L_0x0098;
                case 4: goto L_0x0093;
                case 5: goto L_0x0089;
                case 6: goto L_0x0084;
                case 7: goto L_0x007a;
                case 8: goto L_0x0075;
                case 9: goto L_0x0070;
                case 10: goto L_0x006b;
                case 11: goto L_0x0060;
                case 12: goto L_0x005b;
                case 13: goto L_0x0056;
                case 14: goto L_0x0051;
                case 15: goto L_0x004c;
                case 16: goto L_0x0047;
                case 17: goto L_0x0042;
                case 18: goto L_0x003d;
                default: goto L_0x0039;
            }
        L_0x0039:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0028
        L_0x003d:
            java.lang.String r27 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x0042:
            float r26 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readFloat(r0, r2)
            goto L_0x0028
        L_0x0047:
            long r24 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0028
        L_0x004c:
            long r22 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0028
        L_0x0051:
            java.lang.String r21 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x0056:
            int r20 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0028
        L_0x005b:
            int r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0028
        L_0x0060:
            android.os.Parcelable$Creator<com.google.android.gms.games.PlayerEntity> r3 = com.google.android.gms.games.PlayerEntity.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r18 = r2
            com.google.android.gms.games.PlayerEntity r18 = (com.google.android.gms.games.PlayerEntity) r18
            goto L_0x0028
        L_0x006b:
            java.lang.String r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x0070:
            int r16 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0028
        L_0x0075:
            java.lang.String r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x007a:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r14 = r2
            android.net.Uri r14 = (android.net.Uri) r14
            goto L_0x0028
        L_0x0084:
            java.lang.String r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x0089:
            android.os.Parcelable$Creator r3 = android.net.Uri.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            android.net.Uri r12 = (android.net.Uri) r12
            goto L_0x0028
        L_0x0093:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x0098:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x009d:
            int r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x0028
        L_0x00a2:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0028
        L_0x00a7:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.games.achievement.AchievementEntity r0 = new com.google.android.gms.games.achievement.AchievementEntity
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r26, r27)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.achievement.zza.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
