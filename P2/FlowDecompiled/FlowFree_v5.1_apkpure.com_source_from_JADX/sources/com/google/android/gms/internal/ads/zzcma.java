package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcma implements zzeyl<Set<zzcav<zzdvf>>> {
    private final zzeyw<Executor> zza;
    private final zzeyw<zzcms> zzb;

    public zzcma(zzeyw<Executor> zzeyw, zzeyw<zzcms> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        zzcms zza2 = ((zzcmt) this.zzb).zzb();
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzdc)).booleanValue()) {
            set = Collections.singleton(new zzcav(zza2, zzefx));
        } else {
            set = Collections.emptySet();
        }
        zzeyr.zzb(set);
        return set;
    }
}
