package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcxp implements zzefk<zzbom> {
    final /* synthetic */ zzcxq zza;

    zzcxp(zzcxq zzcxq) {
        this.zza = zzcxq;
    }

    public final void zza(Throwable th) {
        zzym zzg = this.zza.zza.zzb().zzg(th);
        this.zza.zzd.zzbC(zzg);
        zzdrw.zza(zzg.zza, th, "DelayedBannerAd.onFailure");
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        ((zzbom) obj).zzQ();
    }
}
