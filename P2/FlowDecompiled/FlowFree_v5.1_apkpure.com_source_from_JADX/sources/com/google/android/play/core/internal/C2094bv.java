package com.google.android.play.core.internal;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.play.core.internal.bv */
final class C2094bv {

    /* renamed from: a */
    private final ConcurrentHashMap<C2093bu, List<Throwable>> f5196a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b */
    private final ReferenceQueue<Throwable> f5197b = new ReferenceQueue<>();

    C2094bv() {
    }

    /* renamed from: a */
    public final List<Throwable> mo22064a(Throwable th) {
        while (true) {
            Reference<? extends Throwable> poll = this.f5197b.poll();
            if (poll == null) {
                break;
            }
            this.f5196a.remove(poll);
        }
        List<Throwable> list = this.f5196a.get(new C2093bu(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.f5196a.putIfAbsent(new C2093bu(th, this.f5197b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
