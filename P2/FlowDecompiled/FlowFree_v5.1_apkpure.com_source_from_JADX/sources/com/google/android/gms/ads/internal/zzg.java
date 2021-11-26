package com.google.android.gms.ads.internal;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzg implements Runnable {
    private final zzi zza;
    private final boolean zzb;

    zzg(zzi zzi, boolean z) {
        this.zza = zzi;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
