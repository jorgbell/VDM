package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcms implements zzdvf {
    private final Map<zzduy, zzcmr> zza;
    private final zzug zzb;

    zzcms(zzug zzug, Map<zzduy, zzcmr> map) {
        this.zza = map;
        this.zzb = zzug;
    }

    public final void zzbE(zzduy zzduy, String str) {
    }

    public final void zzbF(zzduy zzduy, String str) {
        if (this.zza.containsKey(zzduy)) {
            this.zzb.zzb(this.zza.get(zzduy).zza);
        }
    }

    public final void zzbG(zzduy zzduy, String str, Throwable th) {
        if (this.zza.containsKey(zzduy)) {
            this.zzb.zzb(this.zza.get(zzduy).zzc);
        }
    }

    public final void zzbH(zzduy zzduy, String str) {
        if (this.zza.containsKey(zzduy)) {
            this.zzb.zzb(this.zza.get(zzduy).zzb);
        }
    }
}
