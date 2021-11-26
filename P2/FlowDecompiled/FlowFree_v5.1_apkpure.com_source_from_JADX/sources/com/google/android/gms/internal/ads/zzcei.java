package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcei implements zzeyl<zzbnf> {
    private final zzeyw<zzre> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<Context> zzc;
    private final zzeyw<Clock> zzd;

    public zzcei(zzeyw<zzre> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<Context> zzeyw3, zzeyw<Clock> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbnf(this.zzb.zzb(), new zzbmr(this.zzc.zzb(), this.zza.zzb()), this.zzd.zzb());
    }
}
