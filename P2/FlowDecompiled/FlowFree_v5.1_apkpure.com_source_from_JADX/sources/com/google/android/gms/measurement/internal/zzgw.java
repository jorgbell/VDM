package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzgw implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzhr zzb;

    zzgw(zzhr zzhr, long j) {
        this.zzb = zzhr;
        this.zza = j;
    }

    public final void run() {
        this.zzb.zzs.zzd().zzf.zzb(this.zza);
        this.zzb.zzs.zzau().zzj().zzb("Session timeout duration set", Long.valueOf(this.zza));
    }
}
