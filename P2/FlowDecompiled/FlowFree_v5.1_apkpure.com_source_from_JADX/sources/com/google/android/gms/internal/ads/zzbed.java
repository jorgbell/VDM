package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbed implements Runnable {
    private final zzbef zza;
    private final int zzb;

    zzbed(zzbef zzbef, int i) {
        this.zza = zzbef;
        this.zzb = i;
    }

    public final void run() {
        this.zza.zzG(this.zzb);
    }
}
