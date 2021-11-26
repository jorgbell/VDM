package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdwb implements zzdvo {
    private final zzdvy zza;
    private final zzdvw zzb;

    public zzdwb(zzdvy zzdvy, zzdvw zzdvw) {
        this.zza = zzdvy;
        this.zzb = zzdvw;
    }

    public final void zza(zzdvn zzdvn) {
    }

    public final String zzb(zzdvn zzdvn) {
        zzdvy zzdvy = this.zza;
        Map<String, String> zzj = zzdvn.zzj();
        this.zzb.zza(zzj);
        return zzdvy.zza(zzj);
    }
}
