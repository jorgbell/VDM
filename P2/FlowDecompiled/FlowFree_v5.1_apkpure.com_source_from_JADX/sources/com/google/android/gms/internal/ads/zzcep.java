package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcep implements Runnable {
    private final zzces zza;
    private final zzcgr zzb;

    zzcep(zzces zzces, zzcgr zzcgr) {
        this.zza = zzces;
        this.zzb = zzcgr;
    }

    public final void run() {
        this.zza.zzI(this.zzb);
    }
}
