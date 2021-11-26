package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcpa implements Runnable {
    private final zzcpj zza;
    private final zzbcb zzb;

    zzcpa(zzcpj zzcpj, zzbcb zzbcb) {
        this.zza = zzcpj;
        this.zzb = zzbcb;
    }

    public final void run() {
        this.zza.zzj(this.zzb);
    }
}
