package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzn implements Runnable {
    final /* synthetic */ zzac zza;
    final /* synthetic */ zzo zzb;

    zzn(zzo zzo, zzac zzac) {
        this.zzb = zzo;
        this.zza = zzac;
    }

    public final void run() {
        try {
            this.zzb.zzc.put(this.zza);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }
}
