package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdec implements zzdiz<zzded> {
    private final Clock zza;
    private final zzdrg zzb;

    zzdec(Clock clock, zzdrg zzdrg) {
        this.zza = clock;
        this.zzb = zzdrg;
    }

    public final zzefw<zzded> zza() {
        return zzefo.zza(new zzded(this.zzb, this.zza.currentTimeMillis()));
    }
}
