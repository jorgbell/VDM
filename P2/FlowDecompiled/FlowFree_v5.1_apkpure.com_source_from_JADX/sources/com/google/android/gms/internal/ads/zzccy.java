package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzccy implements zzbvr, zzp {
    IObjectWrapper zza;
    private final Context zzb;
    private final zzbgf zzc;
    private final zzdqo zzd;
    private final zzbbq zze;
    private final zzuq zzf;

    public zzccy(Context context, zzbgf zzbgf, zzdqo zzdqo, zzbbq zzbbq, zzuq zzuq) {
        this.zzb = context;
        this.zzc = zzbgf;
        this.zzd = zzdqo;
        this.zze = zzbbq;
        this.zzf = zzuq;
    }

    public final void zzbD() {
        zzaug zzaug;
        zzauh zzauh;
        zzauh zzauh2;
        zzuq zzuq = this.zzf;
        if ((zzuq == zzuq.REWARD_BASED_VIDEO_AD || zzuq == zzuq.INTERSTITIAL || zzuq == zzuq.APP_OPEN) && this.zzd.zzN && this.zzc != null && zzs.zzr().zza(this.zzb)) {
            zzbbq zzbbq = this.zze;
            int i = zzbbq.zzb;
            int i2 = zzbbq.zzc;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i);
            sb.append(".");
            sb.append(i2);
            String sb2 = sb.toString();
            String zza2 = this.zzd.zzP.zza();
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdl)).booleanValue()) {
                if (this.zzd.zzP.zzb() == 1) {
                    zzaug = zzaug.VIDEO;
                    zzauh = zzauh.DEFINED_BY_JAVASCRIPT;
                } else {
                    if (this.zzd.zzS == 2) {
                        zzauh2 = zzauh.UNSPECIFIED;
                    } else {
                        zzauh2 = zzauh.BEGIN_TO_RENDER;
                    }
                    zzauh = zzauh2;
                    zzaug = zzaug.HTML_DISPLAY;
                }
                this.zza = zzs.zzr().zzf(sb2, this.zzc.zzG(), "", "javascript", zza2, zzauh, zzaug, this.zzd.zzag);
            } else {
                this.zza = zzs.zzr().zzd(sb2, this.zzc.zzG(), "", "javascript", zza2);
            }
            if (this.zza != null) {
                zzs.zzr().zzj(this.zza, (View) this.zzc);
                this.zzc.zzak(this.zza);
                zzs.zzr().zzh(this.zza);
                if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdo)).booleanValue()) {
                    this.zzc.zze("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    public final void zzbJ() {
    }

    public final void zzbo() {
        zzbgf zzbgf;
        if (this.zza != null && (zzbgf = this.zzc) != null) {
            zzbgf.zze("onSdkImpression", new ArrayMap());
        }
    }

    public final void zzbr() {
    }

    public final void zzbs() {
    }

    public final void zzbt(int i) {
        this.zza = null;
    }
}
