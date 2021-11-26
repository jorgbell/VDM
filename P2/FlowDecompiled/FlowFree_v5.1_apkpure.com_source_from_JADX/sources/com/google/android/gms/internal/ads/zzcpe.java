package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final /* synthetic */ class zzcpe implements Runnable {
    private final zzcpj zza;
    private final zzdrx zzb;
    private final zzamn zzc;
    private final List zzd;
    private final String zze;

    zzcpe(zzcpj zzcpj, zzdrx zzdrx, zzamn zzamn, List list, String str) {
        this.zza = zzcpj;
        this.zzb = zzdrx;
        this.zzc = zzamn;
        this.zzd = list;
        this.zze = str;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
