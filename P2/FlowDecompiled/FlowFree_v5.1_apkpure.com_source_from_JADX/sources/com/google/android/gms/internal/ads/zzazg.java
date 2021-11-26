package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzazg implements Runnable {
    private final zzazt zza;
    private final zzazs zzb;
    private final String zzc;

    zzazg(zzazt zzazt, zzazs zzazs, String str) {
        this.zza = zzazt;
        this.zzb = zzazs;
        this.zzc = str;
    }

    public final void run() {
        this.zza.zzs(this.zzb, this.zzc);
    }
}
