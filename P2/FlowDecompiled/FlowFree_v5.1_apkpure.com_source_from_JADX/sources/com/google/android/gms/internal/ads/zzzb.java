package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzzb> CREATOR = new zzzc();
    public final String zza;
    public long zzb;
    public zzym zzc;
    public final Bundle zzd;

    public zzzb(String str, long j, zzym zzym, Bundle bundle) {
        this.zza = str;
        this.zzb = j;
        this.zzc = zzym;
        this.zzd = bundle;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeBundle(parcel, 4, this.zzd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
