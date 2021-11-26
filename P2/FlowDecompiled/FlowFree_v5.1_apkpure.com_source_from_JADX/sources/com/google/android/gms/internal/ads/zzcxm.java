package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxm implements zzeyl<zzcxl> {
    private final zzeyw<Context> zza;
    private final zzeyw<Executor> zzb;
    private final zzeyw<zzccp> zzc;
    private final zzeyw<zzdqn> zzd;

    public zzcxm(zzeyw<Context> zzeyw, zzeyw<Executor> zzeyw2, zzeyw<zzccp> zzeyw3, zzeyw<zzdqn> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcxl(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb());
    }
}
