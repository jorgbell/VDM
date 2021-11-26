package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyp<K, V> extends zzeyh<K, V, V> {
    static {
        zzeym.zza(Collections.emptyMap());
    }

    /* synthetic */ zzeyp(Map map, zzeyn zzeyn) {
        super(map);
    }

    public static <K, V> zzeyo<K, V> zzc(int i) {
        return new zzeyo<>(i, (zzeyn) null);
    }

    /* renamed from: zzd */
    public final Map<K, V> zzb() {
        LinkedHashMap zzc = zzeyi.zzc(zza().size());
        for (Map.Entry entry : zza().entrySet()) {
            zzc.put(entry.getKey(), ((zzeyw) entry.getValue()).zzb());
        }
        return Collections.unmodifiableMap(zzc);
    }
}
