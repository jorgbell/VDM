package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcch implements zzeyl<Set<zzcav<zzcda>>> {
    private final zzeyw<zzcda> zza;

    public zzcch(zzeyw<zzcda> zzeyw) {
        this.zza = zzeyw;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set singleton = Collections.singleton(new zzcav(this.zza.zzb(), zzbbw.zzf));
        zzeyr.zzb(singleton);
        return singleton;
    }
}
