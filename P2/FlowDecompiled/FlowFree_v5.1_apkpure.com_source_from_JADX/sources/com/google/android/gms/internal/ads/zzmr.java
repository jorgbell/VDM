package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzmr {
    public final String zza;
    public final boolean zzb;

    public zzmr(String str, boolean z) {
        this.zza = str;
        this.zzb = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == zzmr.class) {
            zzmr zzmr = (zzmr) obj;
            return TextUtils.equals(this.zza, zzmr.zza) && this.zzb == zzmr.zzb;
        }
    }

    public final int hashCode() {
        String str = this.zza;
        return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (true != this.zzb ? 1237 : 1231);
    }
}
