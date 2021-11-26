package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.metadata.zzb;
import java.util.Collection;

public final class zzp<T> extends zza {
    public static final zzq CREATOR = new zzq();
    private final MetadataBundle zzma;
    private final zzb<T> zzmn;

    zzp(MetadataBundle metadataBundle) {
        this.zzma = metadataBundle;
        this.zzmn = (zzb) zzi.zza(metadataBundle);
    }

    public final <F> F zza(zzj<F> zzj) {
        zzb<T> zzb = this.zzmn;
        return zzj.zza(zzb, ((Collection) this.zzma.zza(zzb)).iterator().next());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
