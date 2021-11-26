package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbmx implements zzeyl<zzbmq> {
    private final zzeyw<zzre> zza;
    private final zzeyw<zzapn> zzb;
    private final zzeyw<Executor> zzc;

    public zzbmx(zzeyw<zzre> zzeyw, zzeyw<zzapn> zzeyw2, zzeyw<Executor> zzeyw3) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zza2 = zzdts.zza();
        zzeyr.zzb(zza2);
        return new zzbmq(this.zza.zzb().zzd(), this.zzb.zzb(), zza2);
    }
}
