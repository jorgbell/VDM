package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

final class zzkw<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zztg;

    public zzkw(Iterator<Map.Entry<K, Object>> it) {
        this.zztg = it;
    }

    public final boolean hasNext() {
        return this.zztg.hasNext();
    }

    public final void remove() {
        this.zztg.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zztg.next();
        return next.getValue() instanceof zzkt ? new zzkv(next) : next;
    }
}
