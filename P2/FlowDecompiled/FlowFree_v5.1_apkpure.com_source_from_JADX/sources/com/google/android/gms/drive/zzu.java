package com.google.android.gms.drive;

import android.os.Parcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public abstract class zzu extends AbstractSafeParcelable {
    private volatile transient boolean zzbt = false;

    /* access modifiers changed from: protected */
    public abstract void zza(Parcel parcel, int i);

    public void writeToParcel(Parcel parcel, int i) {
        Preconditions.checkState(!this.zzbt);
        this.zzbt = true;
        zza(parcel, i);
    }
}
