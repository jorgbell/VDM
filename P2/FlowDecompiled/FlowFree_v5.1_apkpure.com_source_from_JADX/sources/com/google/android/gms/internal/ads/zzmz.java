package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzmz implements Parcelable {
    public static final Parcelable.Creator<zzmz> CREATOR = new zzmx();
    private final zzmy[] zza;

    zzmz(Parcel parcel) {
        this.zza = new zzmy[parcel.readInt()];
        int i = 0;
        while (true) {
            zzmy[] zzmyArr = this.zza;
            if (i < zzmyArr.length) {
                zzmyArr[i] = (zzmy) parcel.readParcelable(zzmy.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzmz.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzmz) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza.length);
        for (zzmy writeParcelable : this.zza) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzmy zzb(int i) {
        return this.zza[i];
    }

    public zzmz(List<? extends zzmy> list) {
        zzmy[] zzmyArr = new zzmy[list.size()];
        this.zza = zzmyArr;
        list.toArray(zzmyArr);
    }
}
