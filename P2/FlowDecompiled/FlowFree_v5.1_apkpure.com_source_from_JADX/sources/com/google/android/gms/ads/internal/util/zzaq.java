package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzdsb;
import com.google.android.gms.internal.ads.zzecs;
import com.google.android.gms.internal.ads.zzym;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzaq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaq> CREATOR = new zzar();
    public final String zza;
    public final int zzb;

    zzaq(String str, int i) {
        this.zza = str == null ? "" : str;
        this.zzb = i;
    }

    public static zzaq zza(Throwable th) {
        String str;
        zzym zza2 = zzdsb.zza(th);
        if (zzecs.zzc(th.getMessage())) {
            str = zza2.zzb;
        } else {
            str = th.getMessage();
        }
        return new zzaq(str, zza2.zza);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
