package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzl extends zza {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    private final String value;

    public zzl(String str) {
        this.value = str;
    }

    public final <F> F zza(zzj<F> zzj) {
        return zzj.zzi(this.value);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
