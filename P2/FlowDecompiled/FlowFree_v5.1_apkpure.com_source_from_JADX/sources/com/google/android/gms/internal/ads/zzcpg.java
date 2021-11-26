package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcpg implements Runnable {
    private final zzcph zza;
    private final String zzb;

    zzcpg(zzcph zzcph, String str) {
        this.zza = zzcph;
        this.zzb = str;
    }

    public final void run() {
        zzcph zzcph = this.zza;
        zzcpj.zzq(zzcph.zza, this.zzb);
    }
}
