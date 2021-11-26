package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbcn implements Runnable {
    private final zzbcw zza;
    private final int zzb;

    zzbcn(zzbcw zzbcw, int i) {
        this.zza = zzbcw;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
