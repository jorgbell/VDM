package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbpz implements zzeyl<zzbpu> {
    private final zzeyw<zzbqk> zza;
    private final zzeyw<zzaix> zzb;
    private final zzeyw<Runnable> zzc;
    private final zzeyw<Executor> zzd;

    public zzbpz(zzeyw<zzbqk> zzeyw, zzeyw<zzaix> zzeyw2, zzeyw<Runnable> zzeyw3, zzeyw<Executor> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzbpu(((zzbsf) this.zza).zzb(), ((zzbpy) this.zzb).zza(), ((zzbpx) this.zzc).zza(), this.zzd.zzb());
    }
}
