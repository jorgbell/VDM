package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdlw implements Runnable {
    private final zzdlx zza;
    private final zzym zzb;

    zzdlw(zzdlx zzdlx, zzym zzym) {
        this.zza = zzdlx;
        this.zzb = zzym;
    }

    public final void run() {
        zzdlx zzdlx = this.zza;
        zzdlx.zzc.zzd.zzbC(this.zzb);
    }
}
