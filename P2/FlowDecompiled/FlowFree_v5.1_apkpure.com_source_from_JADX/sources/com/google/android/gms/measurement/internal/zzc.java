package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzc implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzd zzb;

    zzc(zzd zzd, long j) {
        this.zzb = zzd;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzj(this.zza);
    }
}