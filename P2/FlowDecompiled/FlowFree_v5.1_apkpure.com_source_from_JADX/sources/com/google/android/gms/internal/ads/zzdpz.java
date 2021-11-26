package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdpz implements zzefk<zzcjw> {
    final /* synthetic */ zzddp zza;
    final /* synthetic */ zzdqa zzb;
    final /* synthetic */ zzdqb zzc;

    zzdpz(zzdqb zzdqb, zzddp zzddp, zzdqa zzdqa) {
        this.zzc = zzdqb;
        this.zza = zzddp;
        this.zzb = zzdqa;
    }

    public final void zza(Throwable th) {
        zzym zzym;
        zzckb zzckb = (zzckb) this.zzc.zze.zzc();
        if (zzckb == null) {
            zzym = zzdsb.zzb(th, (zzcwb) null);
        } else {
            zzym = zzckb.zzc().zzg(th);
        }
        synchronized (this.zzc) {
            if (zzckb != null) {
                zzckb.zzb().zzbC(zzym);
                this.zzc.zzb.execute(new zzdpy(this, zzym));
            } else {
                this.zzc.zzd.zzbC(zzym);
                this.zzc.zzh(this.zzb).zza().zzc().zzd().zzp();
            }
            zzdrw.zza(zzym.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcjw zzcjw = (zzcjw) obj;
        synchronized (this.zzc) {
            zzcjw.zzo().zzd(this.zzc.zzd);
            this.zza.zzb(zzcjw);
            Executor zze = this.zzc.zzb;
            zzdps zzd = this.zzc.zzd;
            zzd.getClass();
            zze.execute(zzdpx.zza(zzd));
            this.zzc.zzd.zzl();
        }
    }
}
