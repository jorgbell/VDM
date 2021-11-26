package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxc implements zzeyl<zzcxb> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzbpj> zzb;
    private final zzeyw<Executor> zzc;

    public zzcxc(zzeyw<Context> zzeyw, zzeyw<zzbpj> zzeyw2, zzeyw<Executor> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxb(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb());
    }
}
