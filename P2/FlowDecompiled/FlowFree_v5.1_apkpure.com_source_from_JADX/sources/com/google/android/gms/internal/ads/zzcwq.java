package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcwq implements zzeyl<zzcwp> {
    private final zzeyw<zzbnp> zza;
    private final zzeyw<Context> zzb;
    private final zzeyw<Executor> zzc;
    private final zzeyw<zzckt> zzd;

    public zzcwq(zzeyw<zzbnp> zzeyw, zzeyw<Context> zzeyw2, zzeyw<Executor> zzeyw3, zzeyw<zzckt> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcwp(this.zza.zzb(), this.zzb.zzb(), this.zzc.zzb(), this.zzd.zzb());
    }
}
