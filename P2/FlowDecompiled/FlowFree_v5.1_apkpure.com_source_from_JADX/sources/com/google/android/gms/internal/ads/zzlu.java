package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzlu implements zzlr {
    private final zzqc zza;
    private final int zzb;
    private final int zzc;
    private int zzd;
    private int zze;

    public zzlu(zzlo zzlo) {
        zzqc zzqc = zzlo.zza;
        this.zza = zzqc;
        zzqc.zzi(12);
        this.zzc = zzqc.zzu() & 255;
        this.zzb = zzqc.zzu();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        int i = this.zzc;
        if (i == 8) {
            return this.zza.zzl();
        }
        if (i == 16) {
            return this.zza.zzm();
        }
        int i2 = this.zzd;
        this.zzd = i2 + 1;
        if (i2 % 2 != 0) {
            return this.zze & 15;
        }
        int zzl = this.zza.zzl();
        this.zze = zzl;
        return (zzl & 240) >> 4;
    }

    public final boolean zzc() {
        return false;
    }
}
