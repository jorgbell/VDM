package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public final class zzbak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbak> CREATOR = new zzbal();
    @Deprecated
    public final String zza;
    public final String zzb;
    @Deprecated
    public final zzyx zzc;
    public final zzys zzd;

    public zzbak(String str, String str2, zzyx zzyx, zzys zzys) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzyx;
        this.zzd = zzys;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
