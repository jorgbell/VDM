package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzbha implements Runnable {
    private final zzbhb zza;
    private final int zzb;
    private final int zzc;
    private final boolean zzd;
    private final boolean zze;

    zzbha(zzbhb zzbhb, int i, int i2, boolean z, boolean z2) {
        this.zza = zzbhb;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = z2;
    }

    public final void run() {
        this.zza.zzt(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
