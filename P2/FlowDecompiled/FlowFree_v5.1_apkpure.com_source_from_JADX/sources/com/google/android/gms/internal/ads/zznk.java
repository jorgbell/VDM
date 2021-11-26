package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zznk implements Runnable {
    final /* synthetic */ zznq zza;

    zznk(zznq zznq) {
        this.zza = zznq;
    }

    public final void run() {
        if (!this.zza.zzF) {
            this.zza.zzo.zzn(this.zza);
        }
    }
}
