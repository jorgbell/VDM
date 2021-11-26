package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcwi implements zzecb {
    private final zzbgf zzb;
    private final zzdqo zzc;
    private final zzbnx zzd;

    zzcwi(zzcwj zzcwj, zzbgf zzbgf, zzdqo zzdqo, zzbnx zzbnx) {
        this.zzb = zzbgf;
        this.zzc = zzdqo;
        this.zzd = zzbnx;
    }

    public final Object apply(Object obj) {
        zzbgf zzbgf = this.zzb;
        zzdqo zzdqo = this.zzc;
        zzbnx zzbnx = this.zzd;
        if (zzdqo.zzH) {
            zzbgf.zzau();
        }
        zzbgf.zzL();
        zzbgf.onPause();
        return zzbnx.zzh();
    }
}
