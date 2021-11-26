package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzawp extends zzawr {
    private final String zza;
    private final int zzb;

    public zzawp(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzawp)) {
            zzawp zzawp = (zzawp) obj;
            if (!Objects.equal(this.zza, zzawp.zza) || !Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzawp.zzb))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }
}
