package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.concurrent.Executor;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcni {
    /* access modifiers changed from: private */
    public final zzcnn zza;
    /* access modifiers changed from: private */
    public final Executor zzb;
    /* access modifiers changed from: private */
    public final Map<String, String> zzc;

    public zzcni(zzcnn zzcnn, Executor executor) {
        this.zza = zzcnn;
        this.zzc = zzcnn.zza();
        this.zzb = executor;
    }

    public final zzcnh zza() {
        zzcnh zzcnh = new zzcnh(this);
        zzcnh unused = zzcnh.zzb.putAll(zzcnh.zza.zzc);
        return zzcnh;
    }
}
