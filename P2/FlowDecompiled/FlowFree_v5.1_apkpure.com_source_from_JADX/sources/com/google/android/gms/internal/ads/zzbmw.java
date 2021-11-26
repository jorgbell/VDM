package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmw implements zzeyl<zzbmv> {
    private final zzeyw<zzapn> zza;
    private final zzeyw<zzbmr> zzb;
    private final zzeyw<Executor> zzc;
    private final zzeyw<zzbmq> zzd;
    private final zzeyw<Clock> zze;

    public zzbmw(zzeyw<zzapn> zzeyw, zzeyw<zzbmr> zzeyw2, zzeyw<Executor> zzeyw3, zzeyw<zzbmq> zzeyw4, zzeyw<Clock> zzeyw5) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbmv(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb(), this.zze.zzb());
    }
}
