package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzlt implements zzlr {
    private final int zza;
    private final int zzb;
    private final zzqc zzc;

    public zzlt(zzlo zzlo) {
        zzqc zzqc = zzlo.zza;
        this.zzc = zzqc;
        zzqc.zzi(12);
        this.zza = zzqc.zzu();
        this.zzb = zzqc.zzu();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int i = this.zza;
        return i == 0 ? this.zzc.zzu() : i;
    }

    public final boolean zzc() {
        return this.zza != 0;
    }
}
