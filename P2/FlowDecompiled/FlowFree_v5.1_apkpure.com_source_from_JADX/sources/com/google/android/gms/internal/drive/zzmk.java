package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzmk implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzvj;
    private final /* synthetic */ zzmi zzvk;

    private zzmk(zzmi zzmi) {
        this.zzvk = zzmi;
        this.pos = zzmi.zzve.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzvk.zzve.size()) || zzew().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzew() {
        if (this.zzvj == null) {
            this.zzvj = this.zzvk.zzvh.entrySet().iterator();
        }
        return this.zzvj;
    }

    public final /* synthetic */ Object next() {
        if (zzew().hasNext()) {
            return (Map.Entry) zzew().next();
        }
        List zzb = this.zzvk.zzve;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzmk(zzmi zzmi, zzmj zzmj) {
        this(zzmi);
    }
}
