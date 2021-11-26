package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzv extends zza {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();
    private final FilterHolder zzmp;

    zzv(FilterHolder filterHolder) {
        this.zzmp = filterHolder;
    }

    public final <T> T zza(zzj<T> zzj) {
        return zzj.zza(this.zzmp.getFilter().zza(zzj));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzmp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
