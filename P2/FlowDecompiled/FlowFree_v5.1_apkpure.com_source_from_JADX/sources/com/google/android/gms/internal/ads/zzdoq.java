package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdoq implements Runnable {
    private final zzdos zza;
    private final zzym zzb;

    zzdoq(zzdos zzdos, zzym zzym) {
        this.zza = zzdos;
        this.zzb = zzym;
    }

    public final void run() {
        zzdos zzdos = this.zza;
        zzdos.zzc.zzd.zzbC(this.zzb);
    }
}
