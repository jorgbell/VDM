package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

final class zzmq implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzvj;
    private final /* synthetic */ zzmi zzvk;
    private boolean zzvo;

    private zzmq(zzmi zzmi) {
        this.zzvk = zzmi;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzvk.zzve.size() || (!this.zzvk.zzvf.isEmpty() && zzew().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzvo) {
            this.zzvo = false;
            this.zzvk.zzeu();
            if (this.pos < this.zzvk.zzve.size()) {
                zzmi zzmi = this.zzvk;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzmi.zzax(i);
                return;
            }
            zzew().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzew() {
        if (this.zzvj == null) {
            this.zzvj = this.zzvk.zzvf.entrySet().iterator();
        }
        return this.zzvj;
    }

    public final /* synthetic */ Object next() {
        this.zzvo = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzvk.zzve.size()) {
            return (Map.Entry) this.zzvk.zzve.get(this.pos);
        }
        return (Map.Entry) zzew().next();
    }

    /* synthetic */ zzmq(zzmi zzmi, zzmj zzmj) {
        this(zzmi);
    }
}
