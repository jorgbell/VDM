package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzz extends zza {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();

    public final <F> F zza(zzj<F> zzj) {
        return zzj.zzbj();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        SafeParcelWriter.finishObjectHeader(parcel, SafeParcelWriter.beginObjectHeader(parcel));
    }
}
