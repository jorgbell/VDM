package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzs;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcbs extends zzbql {
    private final Context zzc;
    private final WeakReference<zzbgf> zzd;
    private final zzcam zze;
    private final zzccx zzf;
    private final zzbrf zzg;
    private final zzdzf zzh;
    private final zzbuq zzi;
    private boolean zzj = false;

    zzcbs(zzbqk zzbqk, Context context, @Nullable zzbgf zzbgf, zzcam zzcam, zzccx zzccx, zzbrf zzbrf, zzdzf zzdzf, zzbuq zzbuq) {
        super(zzbqk);
        this.zzc = context;
        this.zzd = new WeakReference<>(zzbgf);
        this.zze = zzcam;
        this.zzf = zzccx;
        this.zzg = zzbrf;
        this.zzh = zzdzf;
        this.zzi = zzbuq;
    }

    public final void finalize() throws Throwable {
        try {
            zzbgf zzbgf = (zzbgf) this.zzd.get();
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeN)).booleanValue()) {
                if (!this.zzj && zzbgf != null) {
                    zzbbw.zze.execute(zzcbr.zza(zzbgf));
                }
            } else if (zzbgf != null) {
                zzbgf.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final boolean zza(boolean z, @Nullable Activity activity) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzar)).booleanValue()) {
            zzs.zzc();
            if (zzr.zzI(this.zzc)) {
                zzbbk.zzi("Interstitials that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit  https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzi.zzd();
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzas)).booleanValue()) {
                    this.zzh.zza(this.zza.zzb.zzb.zzb);
                }
                return false;
            }
        }
        if (!this.zzj) {
            this.zze.zza();
            Context context = activity;
            if (activity == null) {
                context = this.zzc;
            }
            try {
                this.zzf.zza(z, context);
                this.zze.zzb();
                this.zzj = true;
                return true;
            } catch (zzccw e) {
                this.zzi.zzc(e);
            }
        }
        return false;
    }

    public final boolean zzb() {
        return this.zzg.zzf();
    }
}
