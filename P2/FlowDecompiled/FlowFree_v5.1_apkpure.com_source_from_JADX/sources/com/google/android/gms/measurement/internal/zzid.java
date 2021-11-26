package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzid implements Runnable {
    final /* synthetic */ zzhy zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzif zzc;

    zzid(zzif zzif, zzhy zzhy, long j) {
        this.zzc = zzif;
        this.zza = zzhy;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zzC(this.zza, false, this.zzb);
        zzif zzif = this.zzc;
        zzif.zza = null;
        zzif.zzs.zzy().zzz((zzhy) null);
    }
}
