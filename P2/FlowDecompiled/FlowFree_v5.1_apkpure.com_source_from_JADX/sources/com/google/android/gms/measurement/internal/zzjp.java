package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzjp implements Runnable {
    final long zza;
    final long zzb;
    final /* synthetic */ zzjq zzc;

    zzjp(zzjq zzjq, long j, long j2) {
        this.zzc = zzjq;
        this.zza = j;
        this.zzb = j2;
    }

    public final void run() {
        this.zzc.zza.zzs.zzav().zzh(new zzjo(this));
    }
}
