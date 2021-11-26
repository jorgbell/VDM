package com.google.android.gms.internal.drive;

import java.util.Iterator;
import java.util.Map;

final class zzml extends zzmr {
    private final /* synthetic */ zzmi zzvk;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzml(zzmi zzmi) {
        super(zzmi, (zzmj) null);
        this.zzvk = zzmi;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzmk(this.zzvk, (zzmj) null);
    }

    /* synthetic */ zzml(zzmi zzmi, zzmj zzmj) {
        this(zzmi);
    }
}
