package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcnm implements zzeyl<zzcnl> {
    private final zzeyw<zzcne> zza;
    private final zzeyw<Set<zzcnk>> zzb;
    private final zzeyw<Clock> zzc;

    public zzcnm(zzeyw<zzcne> zzeyw, zzeyw<Set<zzcnk>> zzeyw2, zzeyw<Clock> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcnl(this.zza.zzb(), ((zzeyu) this.zzb).zzb(), this.zzc.zzb());
    }
}
