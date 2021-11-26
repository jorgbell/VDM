package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzjn implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ zzju zzb;

    zzjn(zzju zzju, long j) {
        this.zzb = zzju;
        this.zza = j;
    }

    public final void run() {
        zzju.zzi(this.zzb, this.zza);
    }
}
