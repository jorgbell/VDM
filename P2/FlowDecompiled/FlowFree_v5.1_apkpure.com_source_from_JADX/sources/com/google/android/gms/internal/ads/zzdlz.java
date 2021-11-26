package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbnu;
import com.google.android.gms.internal.ads.zzbql;
import com.google.android.gms.internal.ads.zzbtn;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzdlz<AppOpenAd extends zzbql, AppOpenRequestComponent extends zzbnu<AppOpenAd>, AppOpenRequestComponentBuilder extends zzbtn<AppOpenRequestComponent>> implements zzddq<AppOpenAd> {
    protected final zzbid zza;
    private final Context zzb;
    /* access modifiers changed from: private */
    public final Executor zzc;
    /* access modifiers changed from: private */
    public final zzdmm zzd;
    /* access modifiers changed from: private */
    public final zzdof<AppOpenRequestComponent, AppOpenAd> zze;
    private final ViewGroup zzf;
    @GuardedBy("this")
    private final zzdrf zzg;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzefw<AppOpenAd> zzh;

    protected zzdlz(Context context, Executor executor, zzbid zzbid, zzdof<AppOpenRequestComponent, AppOpenAd> zzdof, zzdmm zzdmm, zzdrf zzdrf) {
        this.zzb = context;
        this.zzc = executor;
        this.zza = zzbid;
        this.zze = zzdof;
        this.zzd = zzdmm;
        this.zzg = zzdrf;
        this.zzf = new FrameLayout(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: zzl */
    public final synchronized AppOpenRequestComponentBuilder zzk(zzdod zzdod) {
        zzdly zzdly = (zzdly) zzdod;
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfp)).booleanValue()) {
            zzboj zzboj = new zzboj(this.zzf);
            zzbtq zzbtq = new zzbtq();
            zzbtq.zza(this.zzb);
            zzbtq.zzb(zzdly.zza);
            return zzc(zzboj, zzbtq.zzd(), new zzbze().zzm());
        }
        zzdmm zzf2 = zzdmm.zzf(this.zzd);
        zzbze zzbze = new zzbze();
        zzbze.zzc(zzf2, this.zzc);
        zzbze.zzh(zzf2, this.zzc);
        zzbze.zzi(zzf2, this.zzc);
        zzbze.zzj(zzf2, this.zzc);
        zzbze.zzk(zzf2);
        zzboj zzboj2 = new zzboj(this.zzf);
        zzbtq zzbtq2 = new zzbtq();
        zzbtq2.zza(this.zzb);
        zzbtq2.zzb(zzdly.zza);
        return zzc(zzboj2, zzbtq2.zzd(), zzbze.zzm());
    }

    public final synchronized boolean zza(zzys zzys, String str, zzddo zzddo, zzddp<? super AppOpenAd> zzddp) throws RemoteException {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzbbk.zzf("Ad unit ID should not be null for app open ad.");
            this.zzc.execute(new zzdlu(this));
            return false;
        } else if (this.zzh != null) {
            return false;
        } else {
            zzdrw.zzb(this.zzb, zzys.zzf);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue() && zzys.zzf) {
                this.zza.zzy().zzb(true);
            }
            zzdrf zzdrf = this.zzg;
            zzdrf.zzf(str);
            zzdrf.zzc(zzyx.zzd());
            zzdrf.zza(zzys);
            zzdrg zzu = zzdrf.zzu();
            zzdly zzdly = new zzdly((zzdlx) null);
            zzdly.zza = zzu;
            zzefw<AppOpenAd> zzb2 = this.zze.zzb(new zzdog(zzdly, (zzawc) null), new zzdlv(this));
            this.zzh = zzb2;
            zzefo.zzo(zzb2, new zzdlx(this, zzddp, zzdly), this.zzc);
            return true;
        }
    }

    public final boolean zzb() {
        zzefw<AppOpenAd> zzefw = this.zzh;
        return zzefw != null && !zzefw.isDone();
    }

    /* access modifiers changed from: protected */
    public abstract AppOpenRequestComponentBuilder zzc(zzboj zzboj, zzbtr zzbtr, zzbzf zzbzf);

    public final void zzd(zzzd zzzd) {
        this.zzg.zzo(zzzd);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzd.zzbC(zzdsb.zzd(6, (String) null, (zzym) null));
    }
}
