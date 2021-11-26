package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcxx implements zzecb {
    private final zzbgf zzb;
    private final zzdqo zzc;
    private final zzcbt zzd;

    zzcxx(zzcya zzcya, zzbgf zzbgf, zzdqo zzdqo, zzcbt zzcbt) {
        this.zzb = zzbgf;
        this.zzc = zzdqo;
        this.zzd = zzcbt;
    }

    public final Object apply(Object obj) {
        zzbgf zzbgf = this.zzb;
        zzdqo zzdqo = this.zzc;
        zzcbt zzcbt = this.zzd;
        if (zzdqo.zzH) {
            zzbgf.zzau();
        }
        zzbgf.zzL();
        zzbgf.onPause();
        return zzcbt.zzh();
    }
}
