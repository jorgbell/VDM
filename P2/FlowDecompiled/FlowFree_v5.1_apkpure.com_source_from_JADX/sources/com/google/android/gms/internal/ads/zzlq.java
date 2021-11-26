package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzlq {
    public final int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    private final boolean zze;
    private final zzqc zzf;
    private final zzqc zzg;
    private int zzh;
    private int zzi;

    public zzlq(zzqc zzqc, zzqc zzqc2, boolean z) {
        this.zzg = zzqc;
        this.zzf = zzqc2;
        this.zze = z;
        zzqc2.zzi(12);
        this.zza = zzqc2.zzu();
        zzqc.zzi(12);
        this.zzi = zzqc.zzu();
        zzpu.zze(zzqc.zzr() != 1 ? false : true, "first_chunk must be 1");
        this.zzb = -1;
    }

    public final boolean zza() {
        long j;
        int i = this.zzb + 1;
        this.zzb = i;
        if (i == this.zza) {
            return false;
        }
        if (this.zze) {
            j = this.zzf.zzv();
        } else {
            j = this.zzf.zzp();
        }
        this.zzd = j;
        if (this.zzb == this.zzh) {
            this.zzc = this.zzg.zzu();
            this.zzg.zzj(4);
            int i2 = -1;
            int i3 = this.zzi - 1;
            this.zzi = i3;
            if (i3 > 0) {
                i2 = -1 + this.zzg.zzu();
            }
            this.zzh = i2;
        }
        return true;
    }
}
