package com.google.android.gms.games;

import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public final class zzk implements Parcelable.Creator<PlayerLevelInfo> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new PlayerLevelInfo[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r12) {
        /*
            r11 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r12)
            r1 = 0
            r2 = 0
            r9 = r1
            r10 = r9
            r5 = r2
            r7 = r5
        L_0x000b:
            int r1 = r12.dataPosition()
            if (r1 >= r0) goto L_0x0047
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r12)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 1
            if (r2 == r3) goto L_0x0042
            r3 = 2
            if (r2 == r3) goto L_0x003d
            r3 = 3
            if (r2 == r3) goto L_0x0033
            r3 = 4
            if (r2 == r3) goto L_0x0029
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r12, r1)
            goto L_0x000b
        L_0x0029:
            android.os.Parcelable$Creator<com.google.android.gms.games.PlayerLevel> r2 = com.google.android.gms.games.PlayerLevel.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r10 = r1
            com.google.android.gms.games.PlayerLevel r10 = (com.google.android.gms.games.PlayerLevel) r10
            goto L_0x000b
        L_0x0033:
            android.os.Parcelable$Creator<com.google.android.gms.games.PlayerLevel> r2 = com.google.android.gms.games.PlayerLevel.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r12, r1, r2)
            r9 = r1
            com.google.android.gms.games.PlayerLevel r9 = (com.google.android.gms.games.PlayerLevel) r9
            goto L_0x000b
        L_0x003d:
            long r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r1)
            goto L_0x000b
        L_0x0042:
            long r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r12, r1)
            goto L_0x000b
        L_0x0047:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r12, r0)
            com.google.android.gms.games.PlayerLevelInfo r12 = new com.google.android.gms.games.PlayerLevelInfo
            r4 = r12
            r4.<init>(r5, r7, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.games.zzk.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
