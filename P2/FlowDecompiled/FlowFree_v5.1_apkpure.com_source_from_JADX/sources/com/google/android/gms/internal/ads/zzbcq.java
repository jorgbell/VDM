package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbcq implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbcw zzc;

    zzbcq(zzbcw zzbcw, String str, String str2) {
        this.zzc = zzbcw;
        this.zza = str;
        this.zzb = str2;
    }

    public final void run() {
        if (this.zzc.zzs != null) {
            this.zzc.zzs.zzf(this.zza, this.zzb);
        }
    }
}
