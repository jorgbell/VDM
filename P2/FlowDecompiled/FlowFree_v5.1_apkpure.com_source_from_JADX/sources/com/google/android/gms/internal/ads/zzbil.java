package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbil implements zzeyl<Set<zzcav<zzcaj>>> {
    private final zzeyw<zzctw> zza;
    private final zzeyw<Executor> zzb;

    public zzbil(zzeyw<zzctw> zzeyw, zzeyw<Executor> zzeyw2) {
        this.zza = zzeyw;
        this.zzb = zzeyw2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        zzctw zzb2 = this.zza.zzb();
        zzefx zzefx = zzbbw.zza;
        zzeyr.zzb(zzefx);
        if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzbm)).booleanValue()) {
            if (((Boolean) zzaaa.zzc().zzb(zzaeq.zzfI)).booleanValue()) {
                set = Collections.singleton(new zzcav(zzb2, zzefx));
                zzeyr.zzb(set);
                return set;
            }
        }
        set = Collections.emptySet();
        zzeyr.zzb(set);
        return set;
    }
}
