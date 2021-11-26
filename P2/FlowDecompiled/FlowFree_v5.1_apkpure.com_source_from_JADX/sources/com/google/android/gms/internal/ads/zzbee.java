package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbee implements Runnable {
    private final zzbef zza;
    private final boolean zzb;
    private final long zzc;

    zzbee(zzbef zzbef, boolean z, long j) {
        this.zza = zzbef;
        this.zzb = z;
        this.zzc = j;
    }

    public final void run() {
        this.zza.zzF(this.zzb, this.zzc);
    }
}
