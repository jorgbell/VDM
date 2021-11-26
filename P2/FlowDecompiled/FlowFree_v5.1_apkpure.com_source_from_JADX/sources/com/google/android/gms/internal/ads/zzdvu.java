package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdvu implements zzdvo {
    private final zzdvy zza;
    private final zzdvw zzb;
    private final zzdvl zzc;

    public zzdvu(zzdvl zzdvl, zzdvy zzdvy, zzdvw zzdvw, byte[] bArr) {
        this.zzc = zzdvl;
        this.zza = zzdvy;
        this.zzb = zzdvw;
    }

    public final void zza(zzdvn zzdvn) {
        this.zzc.zza(zzb(zzdvn));
    }

    public final String zzb(zzdvn zzdvn) {
        zzdvy zzdvy = this.zza;
        Map<String, String> zzj = zzdvn.zzj();
        this.zzb.zza(zzj);
        return zzdvy.zza(zzj);
    }
}
