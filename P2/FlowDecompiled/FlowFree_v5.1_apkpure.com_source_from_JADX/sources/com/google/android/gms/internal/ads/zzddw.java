package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzddw implements zzefk<zzbql> {
    final /* synthetic */ zzddp zza;
    final /* synthetic */ zzcdl zzb;
    final /* synthetic */ zzddx zzc;

    zzddw(zzddx zzddx, zzddp zzddp, zzcdl zzcdl) {
        this.zzc = zzddx;
        this.zza = zzddp;
        this.zzb = zzcdl;
    }

    public final void zza(Throwable th) {
        zzym zzg = this.zzb.zza().zzg(th);
        this.zzb.zzb().zzbC(zzg);
        this.zzc.zzb.zze().execute(new zzddv(this, zzg));
        zzdrw.zza(zzg.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbql zzbql = (zzbql) obj;
        synchronized (this.zzc) {
            zzbql.zzo().zza(this.zzc.zzd.zzc());
            this.zza.zzb(zzbql);
            this.zzc.zzb.zze().execute(new zzddu(this));
        }
    }
}
