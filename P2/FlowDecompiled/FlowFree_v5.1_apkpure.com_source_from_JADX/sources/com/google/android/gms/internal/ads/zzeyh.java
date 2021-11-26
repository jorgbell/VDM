package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
abstract class zzeyh<K, V, V2> implements zzeyl<Map<K, V2>> {
    private final Map<K, zzeyw<V>> zza;

    zzeyh(Map<K, zzeyw<V>> map) {
        this.zza = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, zzeyw<V>> zza() {
        return this.zza;
    }
}
