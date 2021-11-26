package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzdad implements zzecb {
    private final zzbgf zzb;
    private final zzdqo zzc;
    private final zzcjx zzd;

    zzdad(zzdai zzdai, zzbgf zzbgf, zzdqo zzdqo, zzcjx zzcjx) {
        this.zzb = zzbgf;
        this.zzc = zzdqo;
        this.zzd = zzcjx;
    }

    public final Object apply(Object obj) {
        zzbgf zzbgf = this.zzb;
        zzdqo zzdqo = this.zzc;
        zzcjx zzcjx = this.zzd;
        if (zzdqo.zzH) {
            zzbgf.zzau();
        }
        zzbgf.zzL();
        zzbgf.onPause();
        return zzcjx.zzh();
    }
}
