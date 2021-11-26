package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.zzr;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzcxz implements zzccx {
    private final Context zza;
    private final zzbbq zzb;
    private final zzefw<zzcbt> zzc;
    private final zzdqo zzd;
    private final zzbgf zze;
    private final zzdrg zzf;
    private final zzaks zzg;
    private final boolean zzh;

    /* synthetic */ zzcxz(Context context, zzbbq zzbbq, zzefw zzefw, zzdqo zzdqo, zzbgf zzbgf, zzdrg zzdrg, boolean z, zzaks zzaks, zzcxy zzcxy) {
        this.zza = context;
        this.zzb = zzbbq;
        this.zzc = zzefw;
        this.zzd = zzdqo;
        this.zze = zzbgf;
        this.zzf = zzdrg;
        this.zzg = zzaks;
        this.zzh = z;
    }

    public final void zza(boolean z, Context context) {
        zzcbt zzcbt = (zzcbt) zzefo.zzq(this.zzc);
        this.zze.zzag(true);
        boolean zzc2 = this.zzh ? this.zzg.zzc(false) : false;
        zzs.zzc();
        zzj zzj = new zzj(zzc2, zzr.zzK(this.zza), this.zzh ? this.zzg.zzd() : false, this.zzh ? this.zzg.zze() : 0.0f, -1, z, this.zzd.zzJ, false);
        zzs.zzb();
        zzccm zzj2 = zzcbt.zzj();
        zzbgf zzbgf = this.zze;
        zzdqo zzdqo = this.zzd;
        int i = zzdqo.zzL;
        zzbbq zzbbq = this.zzb;
        String str = zzdqo.zzA;
        zzdqt zzdqt = zzdqo.zzr;
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel((zzyi) null, (zzp) zzj2, (zzw) null, zzbgf, i, zzbbq, str, zzj, zzdqt.zzb, zzdqt.zza, this.zzf.zzf);
        zzn.zza(context, adOverlayInfoParcel, true);
    }
}
