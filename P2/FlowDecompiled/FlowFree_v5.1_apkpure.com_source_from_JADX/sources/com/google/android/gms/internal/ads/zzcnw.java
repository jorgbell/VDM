package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcnw implements zzeyl<Set<zzcav<zzbuf>>> {
    private final zzeyw<zzcoe> zzb;
    private final zzeyw<Executor> zzc;

    public zzcnw(zzcnv zzcnv, zzeyw<zzcoe> zzeyw, zzeyw<Executor> zzeyw2) {
        this.zzb = zzeyw;
        this.zzc = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        Set<zzcav<zzbuf>> zza = zzcnv.zza(this.zzb.zzb(), zzefx);
        zzeyr.zzb(zza);
        return zza;
    }
}
