package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhm implements Runnable {
    final /* synthetic */ zzaf zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ int zzc;
    final /* synthetic */ long zzd;
    final /* synthetic */ boolean zze;
    final /* synthetic */ zzhr zzf;

    zzhm(zzhr zzhr, zzaf zzaf, long j, int i, long j2, boolean z) {
        this.zzf = zzhr;
        this.zza = zzaf;
        this.zzb = j;
        this.zzc = i;
        this.zzd = j2;
        this.zze = z;
    }

    public final void run() {
        this.zzf.zzr(this.zza);
        this.zzf.zzG(this.zzb, false);
        zzhr.zzW(this.zzf, this.zza, this.zzc, this.zzd, true, this.zze);
    }
}
