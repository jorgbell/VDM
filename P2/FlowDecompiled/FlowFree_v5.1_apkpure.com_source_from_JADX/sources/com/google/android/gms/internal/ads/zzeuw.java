package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzeuw {
    private static final zzeuw zza = new zzeuw();
    private final zzevg zzb = new zzeug();
    private final ConcurrentMap<Class<?>, zzevf<?>> zzc = new ConcurrentHashMap();

    private zzeuw() {
    }

    public static zzeuw zza() {
        return zza;
    }

    public final <T> zzevf<T> zzb(Class<T> cls) {
        zzetr.zzb(cls, "messageType");
        zzevf<T> zzevf = (zzevf) this.zzc.get(cls);
        if (zzevf == null) {
            zzevf = this.zzb.zza(cls);
            zzetr.zzb(cls, "messageType");
            zzetr.zzb(zzevf, "schema");
            zzevf<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzevf);
            return putIfAbsent == null ? zzevf : putIfAbsent;
        }
    }
}
