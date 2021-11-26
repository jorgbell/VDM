package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdos implements zzefk<zzcbs> {
    final /* synthetic */ zzddp zza;
    final /* synthetic */ zzccp zzb;
    final /* synthetic */ zzdot zzc;

    zzdos(zzdot zzdot, zzddp zzddp, zzccp zzccp) {
        this.zzc = zzdot;
        this.zza = zzddp;
        this.zzb = zzccp;
    }

    public final void zza(Throwable th) {
        zzym zzg = this.zzb.zzb().zzg(th);
        synchronized (this.zzc) {
            zzefw unused = this.zzc.zzh = null;
            this.zzb.zza().zzbC(zzg);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfq)).booleanValue()) {
                this.zzc.zzb.execute(new zzdoq(this, zzg));
                this.zzc.zzb.execute(new zzdor(this, zzg));
            }
            zzdrw.zza(zzg.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcbs zzcbs = (zzcbs) obj;
        synchronized (this.zzc) {
            zzefw unused = this.zzc.zzh = null;
            zzaei zzaei = zzaeq.zzfq;
            if (((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
                zzbya zzo = zzcbs.zzo();
                zzo.zza(this.zzc.zzd);
                zzo.zzd(this.zzc.zze);
            }
            this.zza.zzb(zzcbs);
            if (((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
                this.zzc.zzb.execute(new zzdoo(this));
                this.zzc.zzb.execute(new zzdop(this));
            }
        }
    }
}
