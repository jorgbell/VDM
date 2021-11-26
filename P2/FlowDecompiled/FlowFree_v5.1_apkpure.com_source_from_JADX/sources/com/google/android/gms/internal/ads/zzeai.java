package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeai> CREATOR = new zzeaj();
    public final int zza;
    private zzdc zzb = null;
    private byte[] zzc;

    zzeai(int i, byte[] bArr) {
        this.zza = i;
        this.zzc = bArr;
        zzb();
    }

    private final void zzb() {
        zzdc zzdc = this.zzb;
        if (zzdc == null && this.zzc != null) {
            return;
        }
        if (zzdc != null && this.zzc == null) {
            return;
        }
        if (zzdc != null && this.zzc != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (zzdc == null && this.zzc == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        byte[] bArr = this.zzc;
        if (bArr == null) {
            bArr = this.zzb.zzao();
        }
        SafeParcelWriter.writeByteArray(parcel, 2, bArr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzdc zza() {
        if (this.zzb == null) {
            try {
                this.zzb = zzdc.zzi(this.zzc, zzest.zza());
                this.zzc = null;
            } catch (zzett | NullPointerException e) {
                throw new IllegalStateException(e);
            }
        }
        zzb();
        return this.zzb;
    }
}
