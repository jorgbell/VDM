package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcdc implements zzbuf, zzcan {
    private final zzazb zza;
    private final Context zzb;
    private final zzazt zzc;
    private final View zzd;
    private String zze;
    private final zzuq zzf;

    public zzcdc(zzazb zzazb, Context context, zzazt zzazt, View view, zzuq zzuq) {
        this.zza = zzazb;
        this.zzb = context;
        this.zzc = zzazt;
        this.zzd = view;
        this.zzf = zzuq;
    }

    public final void zza() {
    }

    public final void zzc() {
        View view = this.zzd;
        if (!(view == null || this.zze == null)) {
            this.zzc.zzi(view.getContext(), this.zze);
        }
        this.zza.zza(true);
    }

    public final void zzd() {
        this.zza.zza(false);
    }

    public final void zze() {
    }

    @ParametersAreNonnullByDefault
    public final void zzf(zzaws zzaws, String str, String str2) {
        if (this.zzc.zzb(this.zzb)) {
            try {
                zzazt zzazt = this.zzc;
                Context context = this.zzb;
                zzazt.zzr(context, zzazt.zzl(context), this.zza.zzb(), zzaws.zzb(), zzaws.zzc());
            } catch (RemoteException e) {
                zzbbk.zzj("Remote Exception to get reward item.", e);
            }
        }
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzj() {
        String zzh = this.zzc.zzh(this.zzb);
        this.zze = zzh;
        String valueOf = String.valueOf(zzh);
        String str = this.zzf == zzuq.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial";
        this.zze = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }
}
