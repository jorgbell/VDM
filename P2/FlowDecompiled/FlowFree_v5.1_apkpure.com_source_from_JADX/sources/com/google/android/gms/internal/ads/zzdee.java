package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdee implements zzeyl<zzdec> {
    private final zzeyw<Clock> zza;
    private final zzeyw<zzdrg> zzb;

    public zzdee(zzeyw<Clock> zzeyw, zzeyw<zzdrg> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public static zzdec zza(Clock clock, zzdrg zzdrg) {
        return new zzdec(clock, zzdrg);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdec(this.zza.zzb(), ((zzbtw) this.zzb).zza());
    }
}
