package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcjw extends zzbql {
    private final Context zzc;
    private final WeakReference<zzbgf> zzd;
    private final zzccx zze;
    private final zzcam zzf;
    private final zzbuq zzg;
    private final zzbvx zzh;
    private final zzbrf zzi;
    private final zzaxi zzj;
    private final zzdzf zzk;
    private boolean zzl = false;

    zzcjw(zzbqk zzbqk, Context context, zzbgf zzbgf, zzccx zzccx, zzcam zzcam, zzbuq zzbuq, zzbvx zzbvx, zzbrf zzbrf, zzdqo zzdqo, zzdzf zzdzf) {
        super(zzbqk);
        this.zzc = context;
        this.zze = zzccx;
        this.zzd = new WeakReference<>(zzbgf);
        this.zzf = zzcam;
        this.zzg = zzbuq;
        this.zzh = zzbvx;
        this.zzi = zzbrf;
        this.zzk = zzdzf;
        zzaxe zzaxe = zzdqo.zzl;
        this.zzj = new zzayc(zzaxe != null ? zzaxe.zza : "", zzaxe != null ? zzaxe.zzb : 1);
    }

    public final void finalize() throws Throwable {
        try {
            zzbgf zzbgf = (zzbgf) this.zzd.get();
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeN)).booleanValue()) {
                if (!this.zzl && zzbgf != null) {
                    zzbbw.zze.execute(zzcjv.zza(zzbgf));
                }
            } else if (zzbgf != null) {
                zzbgf.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza(boolean z, Activity activity) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzar)).booleanValue()) {
            zzs.zzc();
            if (zzr.zzI(this.zzc)) {
                zzbbk.zzi("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzg.zzd();
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzas)).booleanValue()) {
                    this.zzk.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (this.zzl) {
            zzbbk.zzi("The rewarded ad have been showed.");
            this.zzg.zza(zzdsb.zzd(10, (String) null, (zzym) null));
            return false;
        }
        this.zzl = true;
        this.zzf.zza();
        Context context = activity;
        if (activity == null) {
            context = this.zzc;
        }
        try {
            this.zze.zza(z, context);
            this.zzf.zzb();
            return true;
        } catch (zzccw e) {
            this.zzg.zzc(e);
            return false;
        }
    }

    public final boolean zzb() {
        return this.zzl;
    }

    public final zzaxi zzc() {
        return this.zzj;
    }

    public final boolean zze() {
        return this.zzi.zzf();
    }

    public final boolean zzf() {
        zzbgf zzbgf = (zzbgf) this.zzd.get();
        return zzbgf != null && !zzbgf.zzaA();
    }

    public final Bundle zzg() {
        return this.zzh.zzb();
    }
}
