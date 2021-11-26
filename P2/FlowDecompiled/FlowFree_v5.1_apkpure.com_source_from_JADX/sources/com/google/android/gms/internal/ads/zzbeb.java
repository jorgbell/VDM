package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbeb implements Runnable {
    private final zzbef zza;
    private final int zzb;
    private final int zzc;

    zzbeb(zzbef zzbef, int i, int i2) {
        this.zza = zzbef;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzI(this.zzb, this.zzc);
    }
}
