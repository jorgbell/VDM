package com.google.android.gms.internal.drive;

import java.util.Map;

final class zzkv<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzkt> zztf;

    private zzkv(Map.Entry<K, zzkt> entry) {
        this.zztf = entry;
    }

    public final K getKey() {
        return this.zztf.getKey();
    }

    public final Object getValue() {
        if (this.zztf.getValue() == null) {
            return null;
        }
        zzkt.zzdp();
        throw null;
    }

    public final zzkt zzdq() {
        return this.zztf.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzlq) {
            return this.zztf.getValue().zzi((zzlq) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
