package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdmt implements zzddp<zzbof> {
    final /* synthetic */ zzdmu zza;

    zzdmt(zzdmu zzdmu) {
        this.zza = zzdmu;
    }

    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbof zzbof = (zzbof) obj;
        synchronized (this.zza) {
            zzbof zzbof2 = this.zza.zza;
            if (zzbof2 != null) {
                zzbof2.zzR();
            }
            zzdmu zzdmu = this.zza;
            zzdmu.zza = zzbof;
            zzbof.zza(zzdmu);
            zzdmm zzM = this.zza.zzg;
            zzdmu zzdmu2 = this.zza;
            zzM.zzm(new zzbog(zzbof, zzdmu2, zzdmu2.zzg));
            zzbof.zzQ();
        }
    }
}
