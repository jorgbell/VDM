package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcoa implements zzeyl<Set<zzcav<zzic>>> {
    private final zzeyw<zzcoe> zzb;
    private final zzeyw<Executor> zzc;

    public zzcoa(zzcnv zzcnv, zzeyw<zzcoe> zzeyw, zzeyw<Executor> zzeyw2) {
        this.zzb = zzeyw;
        this.zzc = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        Set<zzcav<zzic>> zzf = zzcnv.zzf(this.zzb.zzb(), zzefx);
        zzeyr.zzb(zzf);
        return zzf;
    }
}
