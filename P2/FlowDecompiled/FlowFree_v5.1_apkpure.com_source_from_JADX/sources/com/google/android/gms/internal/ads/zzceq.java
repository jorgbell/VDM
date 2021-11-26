package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzceq implements Runnable {
    private final zzces zza;
    private final boolean zzb;

    zzceq(zzces zzces, boolean z) {
        this.zza = zzces;
        this.zzb = z;
    }

    public final void run() {
        this.zza.zzH(this.zzb);
    }
}
