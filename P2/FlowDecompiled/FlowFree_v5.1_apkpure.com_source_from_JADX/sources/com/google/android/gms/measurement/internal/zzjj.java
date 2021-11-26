package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
final class zzjj implements Runnable {
    final /* synthetic */ zzki zza;
    final /* synthetic */ Runnable zzb;

    zzjj(zzjl zzjl, zzki zzki, Runnable runnable) {
        this.zza = zzki;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzH();
        this.zza.zzG(this.zzb);
        this.zza.zzC();
    }
}
