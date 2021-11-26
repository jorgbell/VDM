package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdcf extends zzaap {
    final zzdrf zza;
    final zzcfh zzb = new zzcfh();
    private final Context zzc;
    private final zzbid zzd;
    private zzaah zze;

    public zzdcf(zzbid zzbid, Context context, String str) {
        zzdrf zzdrf = new zzdrf();
        this.zza = zzdrf;
        this.zzd = zzbid;
        zzdrf.zzf(str);
        this.zzc = context;
    }

    public final zzaan zze() {
        zzcfi zzg = this.zzb.zzg();
        this.zza.zzl(zzg.zzh());
        this.zza.zzm(zzg.zzi());
        zzdrf zzdrf = this.zza;
        if (zzdrf.zze() == null) {
            zzdrf.zzc(zzyx.zzb());
        }
        return new zzdcg(this.zzc, this.zzd, this.zza, zzg, this.zze);
    }

    public final void zzf(zzaah zzaah) {
        this.zze = zzaah;
    }

    public final void zzg(zzaie zzaie) {
        this.zzb.zzb(zzaie);
    }

    public final void zzh(zzaih zzaih) {
        this.zzb.zza(zzaih);
    }

    public final void zzi(String str, zzain zzain, zzaik zzaik) {
        this.zzb.zzf(str, zzain, zzaik);
    }

    public final void zzj(zzagy zzagy) {
        this.zza.zzn(zzagy);
    }

    public final void zzk(zzair zzair, zzyx zzyx) {
        this.zzb.zzd(zzair);
        this.zza.zzc(zzyx);
    }

    public final void zzl(PublisherAdViewOptions publisherAdViewOptions) {
        this.zza.zzq(publisherAdViewOptions);
    }

    public final void zzm(zzaiu zzaiu) {
        this.zzb.zzc(zzaiu);
    }

    public final void zzn(zzamv zzamv) {
        this.zza.zzp(zzamv);
    }

    public final void zzo(zzane zzane) {
        this.zzb.zze(zzane);
    }

    public final void zzp(AdManagerAdViewOptions adManagerAdViewOptions) {
        this.zza.zzr(adManagerAdViewOptions);
    }

    public final void zzq(zzabf zzabf) {
        this.zza.zzN(zzabf);
    }
}
