package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcjt implements zzale {
    private final zzbvk zza;
    private final zzaxe zzb;
    private final String zzc;
    private final String zzd;

    public zzcjt(zzbvk zzbvk, zzdqo zzdqo) {
        this.zza = zzbvk;
        this.zzb = zzdqo.zzl;
        this.zzc = zzdqo.zzj;
        this.zzd = zzdqo.zzk;
    }

    public final void zza() {
        this.zza.zzd();
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzaxe zzaxe) {
        int i;
        String str;
        zzaxe zzaxe2 = this.zzb;
        if (zzaxe2 != null) {
            zzaxe = zzaxe2;
        }
        if (zzaxe != null) {
            str = zzaxe.zza;
            i = zzaxe.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zze(new zzawp(str, i), this.zzc, this.zzd);
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
