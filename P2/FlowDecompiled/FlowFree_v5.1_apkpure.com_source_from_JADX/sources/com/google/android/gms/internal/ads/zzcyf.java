package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcyf implements zzeyl<zzcye> {
    private final zzeyw<Context> zza;
    private final zzeyw<zzbbq> zzb;
    private final zzeyw<zzccp> zzc;
    private final zzeyw<Executor> zzd;

    public zzcyf(zzeyw<Context> zzeyw, zzeyw<zzbbq> zzeyw2, zzeyw<zzccp> zzeyw3, zzeyw<Executor> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcye(this.zza.zzb(), ((zzbir) this.zzb).zza(), this.zzc.zzb(), zzefx);
    }
}
