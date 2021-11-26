package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcnn extends zzcnp {
    private final zzdvw zzf;

    public zzcnn(Executor executor, zzbbp zzbbp, zzdvw zzdvw, zzdvy zzdvy) {
        super(executor, zzbbp, zzdvy);
        this.zzf = zzdvw;
        zzdvw.zza(this.zzb);
    }

    public final Map<String, String> zza() {
        return new HashMap(this.zzb);
    }
}
