package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbcr implements Runnable {
    final /* synthetic */ zzbcw zza;

    zzbcr(zzbcw zzbcw) {
        this.zza = zzbcw;
    }

    public final void run() {
        if (this.zza.zzs != null) {
            this.zza.zzs.zza();
        }
    }
}
