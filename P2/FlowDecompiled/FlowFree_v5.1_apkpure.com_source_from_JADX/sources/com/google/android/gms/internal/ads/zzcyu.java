package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyu implements zzeyl<zzcyt> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzcdl> zzb;
    private final zzeyw<Executor> zzc;

    public zzcyu(zzeyw<Context> zzeyw, zzeyw<zzcdl> zzeyw2, zzeyw<Executor> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcyt(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
