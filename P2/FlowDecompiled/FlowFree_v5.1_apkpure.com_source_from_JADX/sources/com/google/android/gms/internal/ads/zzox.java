package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzox {
    private int zza;
    private final zzop[] zzb;

    public zzox(zzop[] zzopArr, byte... bArr) {
        this.zzb = zzopArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzox.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzb, ((zzox) obj).zzb);
    }

    public final int hashCode() {
        int i = this.zza;
        if (i != 0) {
            return i;
        }
        int hashCode = Arrays.hashCode(this.zzb) + 527;
        this.zza = hashCode;
        return hashCode;
    }

    public final zzop zza(int i) {
        return this.zzb[i];
    }

    public final zzop[] zzb() {
        return (zzop[]) this.zzb.clone();
    }
}
