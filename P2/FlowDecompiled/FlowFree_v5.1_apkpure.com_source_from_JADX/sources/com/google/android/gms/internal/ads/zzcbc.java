package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcbc {
    private final List<String> zza;
    private final zzdwg zzb;
    private boolean zzc;

    public zzcbc(zzdqo zzdqo, zzdwg zzdwg) {
        this.zza = zzdqo.zzo;
        this.zzb = zzdwg;
    }

    public final void zza() {
        if (!this.zzc) {
            this.zzb.zza(this.zza);
            this.zzc = true;
        }
    }
}
