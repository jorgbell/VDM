package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcft implements Runnable {
    private final zzcfw zza;
    private final zzcgr zzb;

    zzcft(zzcfw zzcfw, zzcgr zzcgr) {
        this.zza = zzcfw;
        this.zzb = zzcgr;
    }

    public final void run() {
        this.zza.zzf(this.zzb);
    }
}
