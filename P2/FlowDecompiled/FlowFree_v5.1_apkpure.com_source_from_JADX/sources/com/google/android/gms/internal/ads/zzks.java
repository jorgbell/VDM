package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzks implements zzlb {
    public final long[] zzb;
    public final long[] zzd;
    private final long zze;

    public zzks(int[] iArr, long[] jArr, long[] jArr2, long[] jArr3) {
        this.zzb = jArr;
        this.zzd = jArr3;
        int length = iArr.length;
        if (length > 0) {
            int i = length - 1;
            this.zze = jArr2[i] + jArr3[i];
            return;
        }
        this.zze = 0;
    }

    public final boolean zza() {
        return true;
    }

    public final long zzb() {
        return this.zze;
    }

    public final long zzc(long j) {
        return this.zzb[zzqj.zzh(this.zzd, j, true, true)];
    }
}
