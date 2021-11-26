package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzkq implements Comparator<zzkp>, Parcelable {
    public static final Parcelable.Creator<zzkq> CREATOR = new zzkn();
    public final int zza;
    private final zzkp[] zzb;
    private int zzc;

    zzkq(Parcel parcel) {
        zzkp[] zzkpArr = (zzkp[]) parcel.createTypedArray(zzkp.CREATOR);
        this.zzb = zzkpArr;
        this.zza = zzkpArr.length;
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzkp zzkp = (zzkp) obj;
        zzkp zzkp2 = (zzkp) obj2;
        UUID uuid = zzie.zzb;
        if (uuid.equals(zzkp.zze)) {
            return !uuid.equals(zzkp2.zze) ? 1 : 0;
        }
        return zzkp.zze.compareTo(zzkp2.zze);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzkq.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzkq) obj).zzb);
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb);
        this.zzc = hashCode;
        return hashCode;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.zzb, 0);
    }

    public final zzkp zza(int i) {
        return this.zzb[i];
    }

    public zzkq(List<zzkp> list) {
        this(false, (zzkp[]) list.toArray(new zzkp[list.size()]));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: com.google.android.gms.internal.ads.zzkp[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzkq(boolean r3, com.google.android.gms.internal.ads.zzkp... r4) {
        /*
            r2 = this;
            r2.<init>()
            if (r3 == 0) goto L_0x000c
            java.lang.Object r3 = r4.clone()
            r4 = r3
            com.google.android.gms.internal.ads.zzkp[] r4 = (com.google.android.gms.internal.ads.zzkp[]) r4
        L_0x000c:
            java.util.Arrays.sort(r4, r2)
            r3 = 1
        L_0x0010:
            int r0 = r4.length
            if (r3 >= r0) goto L_0x0055
            int r0 = r3 + -1
            r0 = r4[r0]
            java.util.UUID r0 = r0.zze
            r1 = r4[r3]
            java.util.UUID r1 = r1.zze
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002a
            int r3 = r3 + 1
            goto L_0x0010
        L_0x002a:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r3 = r4[r3]
            java.util.UUID r3 = r3.zze
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r4 = java.lang.String.valueOf(r3)
            int r4 = r4.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r4 = r4 + 25
            r1.<init>(r4)
            java.lang.String r4 = "Duplicate data for uuid: "
            r1.append(r4)
            r1.append(r3)
            java.lang.String r3 = r1.toString()
            r0.<init>(r3)
            throw r0
        L_0x0055:
            r2.zzb = r4
            r2.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkq.<init>(boolean, com.google.android.gms.internal.ads.zzkp[]):void");
    }

    public zzkq(zzkp... zzkpArr) {
        this(true, zzkpArr);
    }
}
