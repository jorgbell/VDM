package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdga implements zzeyl<zzdfv<zzdfp>> {
    private final zzeyw<zzdfo> zza;
    private final zzeyw<Clock> zzb;

    public zzdga(zzeyw<zzdfo> zzeyw, zzeyw<Clock> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdfv(((zzdfq) this.zza).zzb(), 10000, this.zzb.zzb());
    }
}
