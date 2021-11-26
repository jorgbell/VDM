package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdpy implements Runnable {
    private final zzdpz zza;
    private final zzym zzb;

    zzdpy(zzdpz zzdpz, zzym zzym) {
        this.zza = zzdpz;
        this.zzb = zzym;
    }

    public final void run() {
        zzdpz zzdpz = this.zza;
        zzdpz.zzc.zzd.zzbC(this.zzb);
    }
}
