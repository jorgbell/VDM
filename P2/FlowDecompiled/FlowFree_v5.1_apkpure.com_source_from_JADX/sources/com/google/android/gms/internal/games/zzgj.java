package com.google.android.gms.internal.games;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
final class zzgj {
    private final ConcurrentHashMap<zzgm, List<Throwable>> zznj = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zznk = new ReferenceQueue<>();

    zzgj() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zznk.poll();
        while (poll != null) {
            this.zznj.remove(poll);
            poll = this.zznk.poll();
        }
        List<Throwable> list = this.zznj.get(new zzgm(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zznj.putIfAbsent(new zzgm(th, this.zznk), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
