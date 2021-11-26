package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdmz implements zzefk<zzbom> {
    final /* synthetic */ zzddp zza;
    final /* synthetic */ zzbpj zzb;
    final /* synthetic */ zzdna zzc;

    zzdmz(zzdna zzdna, zzddp zzddp, zzbpj zzbpj) {
        this.zzc = zzdna;
        this.zza = zzddp;
        this.zzb = zzbpj;
    }

    public final void zza(Throwable th) {
        zzym zzg = this.zzb.zzb().zzg(th);
        synchronized (this.zzc) {
            zzefw unused = this.zzc.zzj = null;
            this.zzb.zza().zzbC(zzg);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfo)).booleanValue()) {
                this.zzc.zzb.execute(new zzdmy(this, zzg));
            }
            this.zzc.zzh.zzd(60);
            zzdrw.zza(zzg.zza, th, "BannerAdLoader.onFailure");
            this.zza.zza();
        }
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzbom zzbom = (zzbom) obj;
        synchronized (this.zzc) {
            zzefw unused = this.zzc.zzj = null;
            this.zzc.zzf.removeAllViews();
            if (zzbom.zza() != null) {
                ViewParent parent = zzbom.zza().getParent();
                if (parent instanceof ViewGroup) {
                    String str = "";
                    if (zzbom.zzm() != null) {
                        str = zzbom.zzm().zze();
                    }
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(str);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzbbk.zzi(sb.toString());
                    ((ViewGroup) parent).removeView(zzbom.zza());
                }
            }
            zzaei zzaei = zzaeq.zzfo;
            if (((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
                zzbya zzo = zzbom.zzo();
                zzo.zza(this.zzc.zzd);
                zzo.zzb(this.zzc.zze);
            }
            this.zzc.zzf.addView(zzbom.zza());
            this.zza.zzb(zzbom);
            if (((Boolean) zzaaa.zzc().zzb(zzaei)).booleanValue()) {
                Executor zzo2 = this.zzc.zzb;
                zzdda zzn = this.zzc.zzd;
                zzn.getClass();
                zzo2.execute(zzdmx.zza(zzn));
            }
            this.zzc.zzh.zzd(zzbom.zzg());
        }
    }
}
