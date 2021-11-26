package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzayv implements zzeyl<zzayu> {
    private final zzeyw<Clock> zza;
    private final zzeyw<zzg> zzb;
    private final zzeyw<zzazt> zzc;

    public zzayv(zzeyw<Clock> zzeyw, zzeyw<zzg> zzeyw2, zzeyw<zzazt> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzayu(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
