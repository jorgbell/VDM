package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeem implements Runnable {
    final /* synthetic */ zzefw zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzeeo zzc;

    zzeem(zzeeo zzeeo, zzefw zzefw, int i) {
        this.zzc = zzeeo;
        this.zza = zzefw;
        this.zzb = i;
    }

    public final void run() {
        try {
            if (this.zza.isCancelled()) {
                zzedb unused = this.zzc.zzb = null;
                this.zzc.cancel(false);
            } else {
                this.zzc.zzK(this.zzb, this.zza);
            }
        } finally {
            zzeeo.zzA(this.zzc, (zzedb) null);
        }
    }
}
