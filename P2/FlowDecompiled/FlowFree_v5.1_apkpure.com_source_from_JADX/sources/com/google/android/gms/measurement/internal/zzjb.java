package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
final class zzjb implements Runnable {
    final /* synthetic */ zzed zza;
    final /* synthetic */ zzje zzb;

    zzjb(zzje zzje, zzed zzed) {
        this.zzb = zzje;
        this.zza = zzed;
    }

    public final void run() {
        synchronized (this.zzb) {
            boolean unused = this.zzb.zzb = false;
            if (!this.zzb.zza.zzh()) {
                this.zzb.zza.zzs.zzau().zzj().zza("Connected to remote service");
                this.zzb.zza.zzE(this.zza);
            }
        }
    }
}
