package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public class zzbzc<ListenerT> {
    @GuardedBy("this")
    protected final Map<ListenerT, Executor> zza = new HashMap();

    protected zzbzc(Set<zzcav<ListenerT>> set) {
        zzi(set);
    }

    public final synchronized void zzg(zzcav<ListenerT> zzcav) {
        zzh(zzcav.zza, zzcav.zzb);
    }

    public final synchronized void zzh(ListenerT listenert, Executor executor) {
        this.zza.put(listenert, executor);
    }

    public final synchronized void zzi(Set<zzcav<ListenerT>> set) {
        for (zzcav<ListenerT> zzg : set) {
            zzg(zzg);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zzr(zzbzb<ListenerT> zzbzb) {
        for (Map.Entry next : this.zza.entrySet()) {
            ((Executor) next.getValue()).execute(new zzbza(zzbzb, next.getKey()));
        }
    }
}
