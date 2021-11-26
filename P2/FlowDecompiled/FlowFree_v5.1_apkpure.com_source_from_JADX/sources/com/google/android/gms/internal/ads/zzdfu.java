package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdiy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzdfu<S extends zzdiy<?>> {
    public final zzefw<S> zza;
    private final long zzb;
    private final Clock zzc;

    public zzdfu(zzefw<S> zzefw, long j, Clock clock) {
        this.zza = zzefw;
        this.zzc = clock;
        this.zzb = clock.elapsedRealtime() + j;
    }

    public final boolean zza() {
        return this.zzb < this.zzc.elapsedRealtime();
    }
}
