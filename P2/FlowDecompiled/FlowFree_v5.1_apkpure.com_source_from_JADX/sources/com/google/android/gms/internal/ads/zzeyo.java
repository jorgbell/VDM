package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyo<K, V> extends zzeyg<K, V, V> {
    /* synthetic */ zzeyo(int i, zzeyn zzeyn) {
        super(i);
    }

    public final zzeyo<K, V> zza(K k, zzeyw<V> zzeyw) {
        LinkedHashMap<K, zzeyw<V>> linkedHashMap = this.zza;
        zzeyr.zza(k, "key");
        zzeyr.zza(zzeyw, "provider");
        linkedHashMap.put(k, zzeyw);
        return this;
    }

    public final zzeyp<K, V> zzb() {
        return new zzeyp<>(this.zza, (zzeyn) null);
    }
}
