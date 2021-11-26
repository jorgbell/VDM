package com.google.android.gms.internal.games;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public abstract class zzfd {
    private final Object zzgv;
    private HashMap<String, AtomicInteger> zzgy;

    /* access modifiers changed from: protected */
    public abstract void zzc(String str, int i);

    public final void flush() {
        synchronized (this.zzgv) {
            for (Map.Entry next : this.zzgy.entrySet()) {
                zzc((String) next.getKey(), ((AtomicInteger) next.getValue()).get());
            }
            this.zzgy.clear();
        }
    }
}
