package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcxr implements zzeyl<zzcxq> {
    private final zzeyw<zzbpj> zza;
    private final zzeyw<zzcwx> zzb;
    private final zzeyw<zzbuh> zzc;
    private final zzeyw<ScheduledExecutorService> zzd;
    private final zzeyw<zzefx> zze;

    public zzcxr(zzeyw<zzbpj> zzeyw, zzeyw<zzcwx> zzeyw2, zzeyw<zzbuh> zzeyw3, zzeyw<ScheduledExecutorService> zzeyw4, zzeyw<zzefx> zzeyw5) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
        this.zze = zzeyw5;
    }

    /* renamed from: zza */
    public final zzcxq zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcxq(this.zza.zzb(), ((zzcwy) this.zzb).zzb(), this.zzc.zzb(), this.zzd.zzb(), zzefx);
    }
}
