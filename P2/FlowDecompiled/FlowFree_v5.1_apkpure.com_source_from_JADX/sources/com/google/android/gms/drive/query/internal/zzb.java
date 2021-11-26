package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class zzb<T> extends zza {
    public static final zzc CREATOR = new zzc();
    private final zzx zzlz;
    private final MetadataBundle zzma;
    private final MetadataField<T> zzmb;

    zzb(zzx zzx, MetadataBundle metadataBundle) {
        this.zzlz = zzx;
        this.zzma = metadataBundle;
        this.zzmb = zzi.zza(metadataBundle);
    }

    public final <F> F zza(zzj<F> zzj) {
        zzx zzx = this.zzlz;
        MetadataField<T> metadataField = this.zzmb;
        return zzj.zza(zzx, metadataField, this.zzma.zza(metadataField));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlz, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
