package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzok {
    public final int zza;
    private final zzit[] zzb;
    private int zzc;

    public zzok(zzit... zzitArr) {
        int length = zzitArr.length;
        zzpu.zzd(length > 0);
        this.zzb = zzitArr;
        this.zza = length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzok.class == obj.getClass()) {
            zzok zzok = (zzok) obj;
            return this.zza == zzok.zza && Arrays.equals(this.zzb, zzok.zzb);
        }
    }

    public final int hashCode() {
        int i = this.zzc;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zzc = hashCode;
        return hashCode;
    }

    public final zzit zza(int i) {
        return this.zzb[i];
    }

    public final int zzb(zzit zzit) {
        int i = 0;
        while (true) {
            zzit[] zzitArr = this.zzb;
            if (i >= zzitArr.length) {
                return -1;
            }
            if (zzit == zzitArr[i]) {
                return i;
            }
            i++;
        }
    }
}
