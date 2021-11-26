package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzoj extends zzje {
    private static final Object zzb = new Object();
    private final long zzc;
    private final long zzd;

    public zzoj(long j, boolean z) {
        this.zzc = j;
        this.zzd = j;
    }

    public final int zza() {
        return 1;
    }

    public final zzjd zzb(int i, zzjd zzjd, boolean z, long j) {
        zzpu.zzc(i, 0, 1);
        zzjd.zza = this.zzd;
        return zzjd;
    }

    public final int zzc() {
        return 1;
    }

    public final zzjc zzd(int i, zzjc zzjc, boolean z) {
        zzpu.zzc(i, 0, 1);
        Object obj = z ? zzb : null;
        long j = this.zzc;
        zzjc.zza = obj;
        zzjc.zzb = obj;
        zzjc.zzc = j;
        return zzjc;
    }

    public final int zze(Object obj) {
        return zzb.equals(obj) ? 0 : -1;
    }
}
