package com.chartboost.sdk.impl;

import com.chartboost.sdk.Libraries.C1224j;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.chartboost.sdk.impl.l */
class C1334l implements Comparable<C1334l> {

    /* renamed from: a */
    private final C1224j f3260a;

    /* renamed from: b */
    final int f3261b;

    /* renamed from: c */
    final String f3262c;

    /* renamed from: d */
    final String f3263d;

    /* renamed from: e */
    final String f3264e;

    /* renamed from: f */
    final String f3265f;

    /* renamed from: g */
    final AtomicInteger f3266g;

    /* renamed from: h */
    private final AtomicReference<C1328j> f3267h;

    /* renamed from: i */
    private final long f3268i;

    /* renamed from: j */
    final AtomicInteger f3269j;

    C1334l(C1224j jVar, int i, String str, String str2, String str3, AtomicInteger atomicInteger, AtomicReference<C1328j> atomicReference, long j, AtomicInteger atomicInteger2, String str4) {
        this.f3260a = jVar;
        this.f3261b = i;
        this.f3262c = str;
        this.f3263d = str2;
        this.f3264e = str3;
        this.f3266g = atomicInteger;
        this.f3267h = atomicReference;
        this.f3268i = j;
        this.f3269j = atomicInteger2;
        this.f3265f = str4;
        atomicInteger.incrementAndGet();
    }

    /* renamed from: a */
    public int compareTo(C1334l lVar) {
        return this.f3261b - lVar.f3261b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo10501a(Executor executor, boolean z) {
        C1328j andSet;
        if ((this.f3266g.decrementAndGet() == 0 || !z) && (andSet = this.f3267h.getAndSet((Object) null)) != null) {
            executor.execute(new C1331k(andSet, z, (int) TimeUnit.NANOSECONDS.toMillis(this.f3260a.mo10067b() - this.f3268i), this.f3269j.get()));
        }
    }
}
