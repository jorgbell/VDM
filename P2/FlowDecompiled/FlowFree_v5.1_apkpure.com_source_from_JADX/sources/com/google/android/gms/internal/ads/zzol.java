package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzol {
    public static final zzol zza = new zzol(new zzok[0]);
    public final int zzb;
    private final zzok[] zzc;
    private int zzd;

    public zzol(zzok... zzokArr) {
        this.zzc = zzokArr;
        this.zzb = zzokArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzol.class == obj.getClass()) {
            zzol zzol = (zzol) obj;
            return this.zzb == zzol.zzb && Arrays.equals(this.zzc, zzol.zzc);
        }
    }

    public final int hashCode() {
        int i = this.zzd;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzc);
        this.zzd = hashCode;
        return hashCode;
    }

    public final zzok zza(int i) {
        return this.zzc[i];
    }

    public final int zzb(zzok zzok) {
        for (int i = 0; i < this.zzb; i++) {
            if (this.zzc[i] == zzok) {
                return i;
            }
        }
        return -1;
    }
}
