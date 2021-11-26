package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzje {
    private static final zzje zza = new zzje();
    private final zzji zzb = new zzio();
    private final ConcurrentMap<Class<?>, zzjh<?>> zzc = new ConcurrentHashMap();

    private zzje() {
    }

    public static zzje zza() {
        return zza;
    }

    public final <T> zzjh<T> zzb(Class<T> cls) {
        zzhz.zzb(cls, "messageType");
        zzjh<T> zzjh = (zzjh) this.zzc.get(cls);
        if (zzjh == null) {
            zzjh = this.zzb.zza(cls);
            zzhz.zzb(cls, "messageType");
            zzhz.zzb(zzjh, "schema");
            zzjh<T> putIfAbsent = this.zzc.putIfAbsent(cls, zzjh);
            return putIfAbsent == null ? zzjh : putIfAbsent;
        }
    }
}
