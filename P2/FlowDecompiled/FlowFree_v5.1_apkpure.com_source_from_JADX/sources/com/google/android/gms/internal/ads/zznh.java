package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zznh extends zznf {
    public static final Parcelable.Creator<zznh> CREATOR = new zzng();
    public final String zza;
    public final String zzb;

    zznh(Parcel parcel) {
        super(parcel.readString());
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznh.class == obj.getClass()) {
            zznh zznh = (zznh) obj;
            return this.zze.equals(zznh.zze) && zzqj.zza(this.zza, zznh.zza) && zzqj.zza(this.zzb, zznh.zzb);
        }
    }

    public final int hashCode() {
        int hashCode = (this.zze.hashCode() + 527) * 31;
        String str = this.zza;
        int i = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode2 + i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zznh(String str, String str2, String str3) {
        super(str);
        this.zza = null;
        this.zzb = str3;
    }
}
