package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzczs implements zzeyl<zzczr> {
    private final zzeyw<Context> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzckb> zzc;

    public zzczs(zzeyw<Context> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzckb> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzczr(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
