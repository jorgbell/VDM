package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private int accountType;
    private String zzbg;
    private String zzbh;
    private String zzbi;
    private int zzbj;
    private boolean zzbk;

    public zzr(String str, int i, String str2, String str3, int i2, boolean z) {
        this.zzbg = str;
        this.accountType = i;
        this.zzbh = str2;
        this.zzbi = str3;
        this.zzbj = i2;
        this.zzbk = z;
    }

    private static boolean zzb(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        String str;
        int i2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        if (!zzb(this.accountType)) {
            str = null;
        } else {
            str = this.zzbg;
        }
        boolean z = false;
        SafeParcelWriter.writeString(parcel, 2, str, false);
        int i3 = -1;
        if (!zzb(this.accountType)) {
            i2 = -1;
        } else {
            i2 = this.accountType;
        }
        SafeParcelWriter.writeInt(parcel, 3, i2);
        SafeParcelWriter.writeString(parcel, 4, this.zzbh, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbi, false);
        int i4 = this.zzbj;
        if (i4 == 0 || i4 == 1 || i4 == 2 || i4 == 3) {
            z = true;
        }
        if (z) {
            i3 = i4;
        }
        SafeParcelWriter.writeInt(parcel, 6, i3);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzbk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzbg, Integer.valueOf(this.accountType), Integer.valueOf(this.zzbj), Boolean.valueOf(this.zzbk));
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == zzr.class) {
            if (obj == this) {
                return true;
            }
            zzr zzr = (zzr) obj;
            return Objects.equal(this.zzbg, zzr.zzbg) && this.accountType == zzr.accountType && this.zzbj == zzr.zzbj && this.zzbk == zzr.zzbk;
        }
    }
}
