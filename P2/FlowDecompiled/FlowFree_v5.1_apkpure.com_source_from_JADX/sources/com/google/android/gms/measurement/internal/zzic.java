package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzic implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzif zzb;

    zzic(zzif zzif, long j) {
        this.zzb = zzif;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzB().zzc(this.zza);
        this.zzb.zza = null;
    }
}
