package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

public final class zzr extends zza {
    public static final Parcelable.Creator<zzr> CREATOR = new zzs();
    private final zzx zzlz;
    private final List<FilterHolder> zzmo;

    zzr(zzx zzx, List<FilterHolder> list) {
        this.zzlz = zzx;
        this.zzmo = list;
    }

    public final <T> T zza(zzj<T> zzj) {
        ArrayList arrayList = new ArrayList();
        for (FilterHolder filter : this.zzmo) {
            arrayList.add(filter.getFilter().zza(zzj));
        }
        return zzj.zza(this.zzlz, (List<T>) arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzlz, i, false);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzmo, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
