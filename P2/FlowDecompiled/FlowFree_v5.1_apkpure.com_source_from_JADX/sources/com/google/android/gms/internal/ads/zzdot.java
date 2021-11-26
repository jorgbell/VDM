package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdot implements zzddq<zzcbs> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzbid zzc;
    /* access modifiers changed from: private */
    public final zzdda zzd;
    /* access modifiers changed from: private */
    public final zzdps zze;
    private zzafl zzf;
    @GuardedBy("this")
    private final zzdrf zzg;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzefw<zzcbs> zzh;

    public zzdot(Context context, Executor executor, zzbid zzbid, zzdda zzdda, zzdps zzdps, zzdrf zzdrf) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzbid;
        this.zzd = zzdda;
        this.zzg = zzdrf;
        this.zze = zzdps;
    }

    public final boolean zza(zzys zzys, String str, zzddo zzddo, zzddp<? super zzcbs> zzddp) {
        zzccp zzccp;
        if (str == null) {
            zzbbk.zzf("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new zzdon(this));
            return false;
        } else if (zzb()) {
            return false;
        } else {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue() && zzys.zzf) {
                this.zzc.zzy().zzb(true);
            }
            zzyx zzyx = ((zzdom) zzddo).zza;
            zzdrf zzdrf = this.zzg;
            zzdrf.zzf(str);
            zzdrf.zzc(zzyx);
            zzdrf.zza(zzys);
            zzdrg zzu = zzdrf.zzu();
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfq)).booleanValue()) {
                zzcco zzp = this.zzc.zzp();
                zzbtq zzbtq = new zzbtq();
                zzbtq.zza(this.zza);
                zzbtq.zzb(zzu);
                zzp.zzc(zzbtq.zzd());
                zzbze zzbze = new zzbze();
                zzbze.zzl(this.zzd, this.zzb);
                zzbze.zze(this.zzd, this.zzb);
                zzp.zzd(zzbze.zzm());
                zzp.zzb(new zzdbl(this.zzf));
                zzccp = zzp.zza();
            } else {
                zzbze zzbze2 = new zzbze();
                zzdps zzdps = this.zze;
                if (zzdps != null) {
                    zzbze2.zza(zzdps, this.zzb);
                    zzbze2.zzb(this.zze, this.zzb);
                    zzbze2.zzc(this.zze, this.zzb);
                }
                zzcco zzp2 = this.zzc.zzp();
                zzbtq zzbtq2 = new zzbtq();
                zzbtq2.zza(this.zza);
                zzbtq2.zzb(zzu);
                zzp2.zzc(zzbtq2.zzd());
                zzbze2.zzl(this.zzd, this.zzb);
                zzbze2.zza(this.zzd, this.zzb);
                zzbze2.zzb(this.zzd, this.zzb);
                zzbze2.zzc(this.zzd, this.zzb);
                zzbze2.zzf(this.zzd, this.zzb);
                zzbze2.zze(this.zzd, this.zzb);
                zzbze2.zzj(this.zzd, this.zzb);
                zzbze2.zzd(this.zzd, this.zzb);
                zzp2.zzd(zzbze2.zzm());
                zzp2.zzb(new zzdbl(this.zzf));
                zzccp = zzp2.zza();
            }
            zzbro<zzcbs> zzb2 = zzccp.zzb();
            zzefw<zzcbs> zzc2 = zzb2.zzc(zzb2.zzb());
            this.zzh = zzc2;
            zzefo.zzo(zzc2, new zzdos(this, zzddp, zzccp), this.zzb);
            return true;
        }
    }

    public final boolean zzb() {
        zzefw<zzcbs> zzefw = this.zzh;
        return zzefw != null && !zzefw.isDone();
    }

    public final void zzc(zzafl zzafl) {
        this.zzf = zzafl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd.zzbC(zzdsb.zzd(6, (String) null, (zzym) null));
    }
}
