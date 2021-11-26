package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;
import com.unity3d.ads.metadata.MediationMetaData;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzau {
    public final String zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final int zze;

    public zzau(String str, double d, double d2, double d3, int i) {
        this.zza = str;
        this.zzc = d;
        this.zzb = d2;
        this.zzd = d3;
        this.zze = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzau)) {
            return false;
        }
        zzau zzau = (zzau) obj;
        if (Objects.equal(this.zza, zzau.zza) && this.zzb == zzau.zzb && this.zzc == zzau.zzc && this.zze == zzau.zze && Double.compare(this.zzd, zzau.zzd) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Double.valueOf(this.zzb), Double.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    public final String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add(MediationMetaData.KEY_NAME, this.zza);
        stringHelper.add("minBound", Double.valueOf(this.zzc));
        stringHelper.add("maxBound", Double.valueOf(this.zzb));
        stringHelper.add("percent", Double.valueOf(this.zzd));
        stringHelper.add("count", Integer.valueOf(this.zze));
        return stringHelper.toString();
    }
}
