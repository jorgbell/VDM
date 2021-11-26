package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdlx implements zzefk {
    final /* synthetic */ zzddp zza;
    final /* synthetic */ zzdly zzb;
    final /* synthetic */ zzdlz zzc;

    zzdlx(zzdlz zzdlz, zzddp zzddp, zzdly zzdly) {
        this.zzc = zzdlz;
        this.zza = zzddp;
        this.zzb = zzdly;
    }

    public final void zza(Throwable th) {
        zzym zzym;
        zzbnu zzbnu = (zzbnu) this.zzc.zze.zzc();
        if (zzbnu == null) {
            zzym = zzdsb.zzb(th, (zzcwb) null);
        } else {
            zzym = zzbnu.zzc().zzg(th);
        }
        synchronized (this.zzc) {
            zzefw unused = this.zzc.zzh = null;
            if (zzbnu != null) {
                zzbnu.zzb().zzbC(zzym);
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfp)).booleanValue()) {
                    this.zzc.zzc.execute(new zzdlw(this, zzym));
                }
            } else {
                this.zzc.zzd.zzbC(zzym);
                ((zzbnu) this.zzc.zzk(this.zzb).zzf()).zzc().zzd().zzp();
            }
            zzdrw.zza(zzym.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbql zzbql = (zzbql) obj;
        synchronized (this.zzc) {
            zzefw unused = this.zzc.zzh = null;
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfp)).booleanValue()) {
                zzbql.zzo().zzc(this.zzc.zzd);
            }
            this.zza.zzb(zzbql);
        }
    }
}
