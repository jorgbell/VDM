package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzhn implements Runnable {
    final /* synthetic */ zzaf zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ long zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzhr zze;

    zzhn(zzhr zzhr, zzaf zzaf, int i, long j, boolean z) {
        this.zze = zzhr;
        this.zza = zzaf;
        this.zzb = i;
        this.zzc = j;
        this.zzd = z;
    }

    public final void run() {
        this.zze.zzr(this.zza);
        zzhr.zzW(this.zze, this.zza, this.zzb, this.zzc, false, this.zzd);
    }
}
