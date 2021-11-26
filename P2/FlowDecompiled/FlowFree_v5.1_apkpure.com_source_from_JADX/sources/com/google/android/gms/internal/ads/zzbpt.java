package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbpt implements Runnable {
    private final zzbpu zza;
    private final Runnable zzb;

    zzbpt(zzbpu zzbpu, Runnable runnable) {
        this.zza = zzbpu;
        this.zzb = runnable;
    }

    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
