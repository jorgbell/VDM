package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzet implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzeu zzb;

    zzet(zzeu zzeu, boolean z) {
        this.zzb = zzeu;
        this.zza = z;
    }

    public final void run() {
        this.zzb.zzb.zzW(this.zza);
    }
}
