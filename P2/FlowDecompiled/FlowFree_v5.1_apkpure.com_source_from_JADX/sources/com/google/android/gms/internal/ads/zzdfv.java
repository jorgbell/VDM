package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.ads.zzdiy;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdfv<S extends zzdiy> implements zzdiz<S> {
    private final AtomicReference<zzdfu<S>> zza = new AtomicReference<>();
    private final Clock zzb;
    private final zzdiz<S> zzc;
    private final long zzd;

    public zzdfv(zzdiz<S> zzdiz, long j, Clock clock) {
        this.zzb = clock;
        this.zzc = zzdiz;
        this.zzd = j;
    }

    public final zzefw<S> zza() {
        zzdfu zzdfu = this.zza.get();
        if (zzdfu == null || zzdfu.zza()) {
            zzdfu = new zzdfu(this.zzc.zza(), this.zzd, this.zzb);
            this.zza.set(zzdfu);
        }
        return zzdfu.zza;
    }
}
