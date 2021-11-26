package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbcs implements Runnable {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ zzbcw zzc;

    zzbcs(zzbcw zzbcw, int i, int i2) {
        this.zzc = zzbcw;
        this.zza = i;
        this.zzb = i2;
    }

    public final void run() {
        if (this.zzc.zzs != null) {
            this.zzc.zzs.zzj(this.zza, this.zzb);
        }
    }
}
