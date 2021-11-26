package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzs;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcur implements zzdvf {
    private final zzcuo zza;

    zzcur(zzcuo zzcuo) {
        this.zza = zzcuo;
    }

    public final void zzbE(zzduy zzduy, String str) {
    }

    public final void zzbF(zzduy zzduy, String str) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue() && zzduy.RENDERER == zzduy) {
            this.zza.zze(zzs.zzj().elapsedRealtime());
        }
    }

    public final void zzbG(zzduy zzduy, String str, Throwable th) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue() && zzduy.RENDERER == zzduy && this.zza.zzf() != 0) {
            this.zza.zzg(zzs.zzj().elapsedRealtime() - this.zza.zzf());
        }
    }

    public final void zzbH(zzduy zzduy, String str) {
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzeo)).booleanValue() && zzduy.RENDERER == zzduy && this.zza.zzf() != 0) {
            this.zza.zzg(zzs.zzj().elapsedRealtime() - this.zza.zzf());
        }
    }
}
