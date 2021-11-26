package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbcu implements Runnable {
    final /* synthetic */ zzbcw zza;

    zzbcu(zzbcw zzbcw) {
        this.zza = zzbcw;
    }

    public final void run() {
        if (this.zza.zzs != null) {
            this.zza.zzs.zzc();
        }
    }
}
