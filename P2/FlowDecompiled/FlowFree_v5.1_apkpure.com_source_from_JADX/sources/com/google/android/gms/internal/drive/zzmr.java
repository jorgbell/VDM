package com.google.android.gms.internal.drive;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzmr extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzmi zzvk;

    private zzmr(zzmi zzmi) {
        this.zzvk = zzmi;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzmq(this.zzvk, (zzmj) null);
    }

    public int size() {
        return this.zzvk.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzvk.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzvk.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzvk.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzvk.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzmr(zzmi zzmi, zzmj zzmj) {
        this(zzmi);
    }
}
