package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcuf implements zzeyl<zzcav<zzdvf>> {
    private final zzeyw<zzcur> zza;
    private final zzeyw<Executor> zzb;

    public zzcuf(zzeyw<zzcur> zzeyw, zzeyw<Executor> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzcur zza2 = ((zzcus) this.zza).zzb();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcav(zza2, zzefx);
    }
}
