package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzddx implements zzddq<zzbql> {
    @GuardedBy("this")
    private final zzdrf zza;
    /* access modifiers changed from: private */
    public final zzbid zzb;
    private final Context zzc;
    /* access modifiers changed from: private */
    public final zzddn zzd;
    @GuardedBy("this")
    private zzbqz zze;

    public zzddx(zzbid zzbid, Context context, zzddn zzddn, zzdrf zzdrf) {
        this.zzb = zzbid;
        this.zzc = context;
        this.zzd = zzddn;
        this.zza = zzdrf;
        zzdrf.zzs(zzddn.zzc());
    }

    public final boolean zza(zzys zzys, String str, zzddo zzddo, zzddp<? super zzbql> zzddp) throws RemoteException {
        zzs.zzc();
        if (zzr.zzJ(this.zzc) && zzys.zzs == null) {
            zzbbk.zzf("Failed to load the ad because app ID is missing.");
            this.zzb.zze().execute(new zzdds(this));
            return false;
        } else if (str == null) {
            zzbbk.zzf("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zze().execute(new zzddt(this));
            return false;
        } else {
            zzdrw.zzb(this.zzc, zzys.zzf);
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfP)).booleanValue() && zzys.zzf) {
                this.zzb.zzy().zzb(true);
            }
            int i = ((zzddr) zzddo).zza;
            zzdrf zzdrf = this.zza;
            zzdrf.zza(zzys);
            zzdrf.zzk(i);
            zzdrg zzu = zzdrf.zzu();
            if (zzu.zzn != null) {
                this.zzd.zzc().zzo(zzu.zzn);
            }
            zzcdk zzr = this.zzb.zzr();
            zzbtq zzbtq = new zzbtq();
            zzbtq.zza(this.zzc);
            zzbtq.zzb(zzu);
            zzr.zzd(zzbtq.zzd());
            zzbze zzbze = new zzbze();
            zzbze.zze(this.zzd.zzc(), this.zzb.zze());
            zzr.zze(zzbze.zzm());
            zzr.zzc(this.zzd.zzb());
            zzr.zzb(new zzboj((ViewGroup) null));
            zzcdl zza2 = zzr.zza();
            this.zzb.zzx().zza(1);
            zzefx zzefx = zzbbw.zza;
            zzeyr.zzb(zzefx);
            ScheduledExecutorService zzf = this.zzb.zzf();
            zzbro<zzbqs> zza3 = zza2.zza();
            zzbqz zzbqz = new zzbqz(zzefx, zzf, zza3.zzc(zza3.zzb()));
            this.zze = zzbqz;
            zzbqz.zza(new zzddw(this, zzddp, zza2));
            return true;
        }
    }

    public final boolean zzb() {
        zzbqz zzbqz = this.zze;
        return zzbqz != null && zzbqz.zzb();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zzd.zze().zzbC(zzdsb.zzd(6, (String) null, (zzym) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd.zze().zzbC(zzdsb.zzd(4, (String) null, (zzym) null));
    }
}
