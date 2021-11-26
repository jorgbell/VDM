package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzni implements zzoi {
    private final zzoi[] zza;

    public zzni(zzoi[] zzoiArr) {
        this.zza = zzoiArr;
    }

    public final long zza() {
        long j = Long.MAX_VALUE;
        for (zzoi zza2 : this.zza) {
            long zza3 = zza2.zza();
            if (zza3 != Long.MIN_VALUE) {
                j = Math.min(j, zza3);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }

    public final boolean zzb(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zza2 = zza();
            if (zza2 == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zzoi zzoi : this.zza) {
                if (zzoi.zza() == zza2) {
                    z |= zzoi.zzb(j);
                }
            }
            z2 |= z;
        } while (z);
        if (true != z2) {
            return false;
        }
        return true;
    }
}
