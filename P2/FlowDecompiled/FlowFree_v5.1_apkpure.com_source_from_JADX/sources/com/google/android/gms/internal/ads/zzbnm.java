package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbnm implements zzeyl<Set<zzcav<zzri>>> {
    private final zzeyw<zzbqd> zzb;

    public zzbnm(zzbnj zzbnj, zzeyw<zzbqd> zzeyw) {
        this.zzb = zzeyw;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzcav(this.zzb.zzb(), zzbbw.zzf));
        zzeyr.zzb(singleton);
        return singleton;
    }
}
