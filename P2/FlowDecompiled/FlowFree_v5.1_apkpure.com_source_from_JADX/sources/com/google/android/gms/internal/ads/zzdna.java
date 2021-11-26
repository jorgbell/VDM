package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdna implements zzddq<zzbom> {
    private final Context zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    private final zzbid zzc;
    /* access modifiers changed from: private */
    public final zzdda zzd;
    /* access modifiers changed from: private */
    public final zzdde zze;
    /* access modifiers changed from: private */
    public final ViewGroup zzf;
    private zzafl zzg;
    /* access modifiers changed from: private */
    public final zzbwr zzh;
    @GuardedBy("this")
    private final zzdrf zzi;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzefw<zzbom> zzj;

    public zzdna(Context context, Executor executor, zzyx zzyx, zzbid zzbid, zzdda zzdda, zzdde zzdde, zzdrf zzdrf) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzbid;
        this.zzd = zzdda;
        this.zze = zzdde;
        this.zzi = zzdrf;
        this.zzh = zzbid.zzh();
        this.zzf = new FrameLayout(context);
        zzdrf.zzc(zzyx);
    }

    public final boolean zza(zzys zzys, String str, zzddo zzddo, zzddp<? super zzbom> zzddp) throws RemoteException {
        zzbpj zzbpj;
        if (str == null) {
            zzbbk.zzf("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new zzdmw(this));
            return false;
        } else if (zzb()) {
            return false;
        } else {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue() && zzys.zzf) {
                this.zzc.zzy().zzb(true);
            }
            zzdrf zzdrf = this.zzi;
            zzdrf.zzf(str);
            zzdrf.zza(zzys);
            zzdrg zzu = zzdrf.zzu();
            if (!zzagg.zzc.zze().booleanValue() || !this.zzi.zze().zzk) {
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfo)).booleanValue()) {
                    zzbpi zzk = this.zzc.zzk();
                    zzbtq zzbtq = new zzbtq();
                    zzbtq.zza(this.zza);
                    zzbtq.zzb(zzu);
                    zzk.zzj(zzbtq.zzd());
                    zzbze zzbze = new zzbze();
                    zzbze.zzl(this.zzd, this.zzb);
                    zzbze.zze(this.zzd, this.zzb);
                    zzk.zzk(zzbze.zzm());
                    zzk.zze(new zzdbl(this.zzg));
                    zzk.zzb(new zzcdg(zzcfi.zza, (zzaah) null));
                    zzk.zzd(new zzbqf(this.zzh));
                    zzk.zzc(new zzboj(this.zzf));
                    zzbpj = zzk.zza();
                } else {
                    zzbpi zzk2 = this.zzc.zzk();
                    zzbtq zzbtq2 = new zzbtq();
                    zzbtq2.zza(this.zza);
                    zzbtq2.zzb(zzu);
                    zzk2.zzj(zzbtq2.zzd());
                    zzbze zzbze2 = new zzbze();
                    zzbze2.zzl(this.zzd, this.zzb);
                    zzbze2.zzf(this.zzd, this.zzb);
                    zzbze2.zzf(this.zze, this.zzb);
                    zzbze2.zzg(this.zzd, this.zzb);
                    zzbze2.zza(this.zzd, this.zzb);
                    zzbze2.zzb(this.zzd, this.zzb);
                    zzbze2.zzc(this.zzd, this.zzb);
                    zzbze2.zze(this.zzd, this.zzb);
                    zzbze2.zzj(this.zzd, this.zzb);
                    zzk2.zzk(zzbze2.zzm());
                    zzk2.zze(new zzdbl(this.zzg));
                    zzk2.zzb(new zzcdg(zzcfi.zza, (zzaah) null));
                    zzk2.zzd(new zzbqf(this.zzh));
                    zzk2.zzc(new zzboj(this.zzf));
                    zzbpj = zzk2.zza();
                }
                zzbro<zzbom> zzb2 = zzbpj.zzb();
                zzefw<zzbom> zzc2 = zzb2.zzc(zzb2.zzb());
                this.zzj = zzc2;
                zzefo.zzo(zzc2, new zzdmz(this, zzddp, zzbpj), this.zzb);
                return true;
            }
            zzdda zzdda = this.zzd;
            if (zzdda != null) {
                zzdda.zzbC(zzdsb.zzd(7, (String) null, (zzym) null));
            }
            return false;
        }
    }

    public final boolean zzb() {
        zzefw<zzbom> zzefw = this.zzj;
        return zzefw != null && !zzefw.isDone();
    }

    public final ViewGroup zzc() {
        return this.zzf;
    }

    public final void zzd(zzafl zzafl) {
        this.zzg = zzafl;
    }

    public final void zze(zzaae zzaae) {
        this.zze.zza(zzaae);
    }

    public final zzdrf zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        zzs.zzc();
        return zzr.zzX(view, view.getContext());
    }

    public final void zzh(zzbws zzbws) {
        this.zzh.zzh(zzbws, this.zzb);
    }

    public final void zzi() {
        this.zzh.zzd(60);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzj() {
        this.zzd.zzbC(zzdsb.zzd(6, (String) null, (zzym) null));
    }
}
