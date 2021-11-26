package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.zza;
import com.google.android.gms.drive.zzu;
import java.util.List;

public final class zzff extends zzu {
    public static final Parcelable.Creator<zzff> CREATOR = new zzfg();
    private final DataHolder zzhr;
    private final List<DriveId> zzhs;
    private final zza zzht;
    private final boolean zzhu;

    /* access modifiers changed from: protected */
    public final void zza(Parcel parcel, int i) {
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzhr, i2, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzhs, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzht, i2, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzff(DataHolder dataHolder, List<DriveId> list, zza zza, boolean z) {
        this.zzhr = dataHolder;
        this.zzhs = list;
        this.zzht = zza;
        this.zzhu = z;
    }
}
