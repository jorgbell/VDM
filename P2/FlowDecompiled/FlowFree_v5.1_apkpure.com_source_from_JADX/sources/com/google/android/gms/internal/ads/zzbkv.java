package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbkv implements Runnable {
    private final zzbkx zza;
    private final Runnable zzb;

    zzbkv(zzbkx zzbkx, Runnable runnable) {
        this.zza = zzbkx;
        this.zzb = runnable;
    }

    public final void run() {
        zzbbw.zze.execute(new zzbkw(this.zza, this.zzb));
    }
}
