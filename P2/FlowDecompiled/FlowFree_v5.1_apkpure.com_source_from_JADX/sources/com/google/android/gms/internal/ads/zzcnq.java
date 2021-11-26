package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcnq implements zzeyl<zzcnn> {
    private final zzeyw<Executor> zza;
    private final zzeyw<zzbbp> zzb;
    private final zzeyw<zzdvw> zzc;
    private final zzeyw<zzdvy> zzd;

    public zzcnq(zzeyw<Executor> zzeyw, zzeyw<zzbbp> zzeyw2, zzeyw<zzdvw> zzeyw3, zzeyw<zzdvy> zzeyw4) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
        this.zzc = zzeyw3;
        this.zzd = zzeyw4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        return new zzcnn(zzefx, this.zzb.zzb(), ((zzdvx) this.zzc).zzb(), new zzdvy());
    }
}
