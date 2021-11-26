package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdal implements Runnable {
    private final zzdam zza;
    private final zzdra zzb;
    private final zzdqo zzc;
    private final zzcvz zzd;

    zzdal(zzdam zzdam, zzdra zzdra, zzdqo zzdqo, zzcvz zzcvz) {
        this.zza = zzdam;
        this.zzb = zzdra;
        this.zzc = zzdqo;
        this.zzd = zzcvz;
    }

    public final void run() {
        zzdam zzdam = this.zza;
        zzdao.zze(this.zzb, this.zzc, this.zzd);
    }
}
