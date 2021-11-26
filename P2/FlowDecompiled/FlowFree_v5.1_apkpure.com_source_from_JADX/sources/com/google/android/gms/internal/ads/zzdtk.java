package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdtk implements zzefk<zzdta> {
    final /* synthetic */ zzdto zza;

    zzdtk(zzdto zzdto) {
        this.zza = zzdto;
    }

    public final void zza(Throwable th) {
        synchronized (this.zza) {
            this.zza.zzc.zzi(th);
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzdta zzdta = (zzdta) obj;
        synchronized (this.zza) {
            this.zza.zzf.zzb(zzdta);
            if (this.zza.zzi != 2) {
                this.zza.zze.zzb(this.zza.zzb.zzb(), zzdta);
            }
            if (this.zza.zzi == 1) {
                zzdto zzdto = this.zza;
                zzdto.zzl(zzdto.zzb);
            }
            int unused = this.zza.zzi = 1;
            this.zza.zzc.zzh(zzdta);
        }
    }
}
