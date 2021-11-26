package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcxo implements Runnable {
    private final zzcxq zza;
    private final zzdra zzb;
    private final zzdqo zzc;

    zzcxo(zzcxq zzcxq, zzdra zzdra, zzdqo zzdqo) {
        this.zza = zzcxq;
        this.zzb = zzdra;
        this.zzc = zzdqo;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc);
    }
}
