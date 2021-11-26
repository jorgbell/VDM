package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcwl implements zzccx {
    private final zzbbq zza;
    private final zzefw<zzbnx> zzb;
    private final zzdqo zzc;
    private final zzbgf zzd;
    private final zzdrg zze;
    private final zzaks zzf;
    private final boolean zzg;

    zzcwl(zzbbq zzbbq, zzefw<zzbnx> zzefw, zzdqo zzdqo, zzbgf zzbgf, zzdrg zzdrg, boolean z, zzaks zzaks) {
        this.zza = zzbbq;
        this.zzb = zzefw;
        this.zzc = zzdqo;
        this.zzd = zzbgf;
        this.zze = zzdrg;
        this.zzg = z;
        this.zzf = zzaks;
    }

    public final void zza(boolean z, Context context) {
        int i;
        zzbnx zzbnx = (zzbnx) zzefo.zzq(this.zzb);
        this.zzd.zzag(true);
        zzj zzj = new zzj(this.zzg ? this.zzf.zzc(true) : true, true, this.zzg ? this.zzf.zzd() : false, this.zzg ? this.zzf.zze() : 0.0f, -1, z, this.zzc.zzJ, false);
        zzs.zzb();
        zzccm zzj2 = zzbnx.zzj();
        zzbgf zzbgf = this.zzd;
        int i2 = this.zzc.zzL;
        if (i2 == -1) {
            zzzd zzzd = this.zze.zzj;
            if (zzzd != null) {
                int i3 = zzzd.zza;
                if (i3 == 1) {
                    i = 7;
                } else if (i3 == 2) {
                    i = 6;
                }
                zzbbq zzbbq = this.zza;
                zzdqo zzdqo = this.zzc;
                String str = zzdqo.zzA;
                zzdqt zzdqt = zzdqo.zzr;
                AdOverlayInfoParcel adOverlayInfoParcel = r4;
                AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzyi) null, (zzp) zzj2, (zzw) null, zzbgf, i, zzbbq, str, zzj, zzdqt.zzb, zzdqt.zza, this.zze.zzf);
                zzn.zza(context, adOverlayInfoParcel, true);
            }
            zzbbk.zzd("Error setting app open orientation; no targeting orientation available.");
            i2 = this.zzc.zzL;
        }
        i = i2;
        zzbbq zzbbq2 = this.zza;
        zzdqo zzdqo2 = this.zzc;
        String str2 = zzdqo2.zzA;
        zzdqt zzdqt2 = zzdqo2.zzr;
        AdOverlayInfoParcel adOverlayInfoParcel3 = adOverlayInfoParcel2;
        AdOverlayInfoParcel adOverlayInfoParcel22 = new AdOverlayInfoParcel((zzyi) null, (zzp) zzj2, (zzw) null, zzbgf, i, zzbbq2, str2, zzj, zzdqt2.zzb, zzdqt2.zza, this.zze.zzf);
        zzn.zza(context, adOverlayInfoParcel3, true);
    }
}
