package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzaa implements Runnable {
    final /* synthetic */ String zza;
    final /* synthetic */ long zzb;
    final /* synthetic */ zzac zzc;

    zzaa(zzac zzac, String str, long j) {
        this.zzc = zzac;
        this.zza = str;
        this.zzb = j;
    }

    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
        this.zzc.zza.zzb(this.zzc.toString());
    }
}
