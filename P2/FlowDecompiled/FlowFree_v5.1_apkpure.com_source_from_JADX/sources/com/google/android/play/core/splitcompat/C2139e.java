package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.e */
final class C2139e implements C2142h {

    /* renamed from: a */
    final /* synthetic */ C2151q f5253a;

    /* renamed from: b */
    final /* synthetic */ Set f5254b;

    /* renamed from: c */
    final /* synthetic */ AtomicBoolean f5255c;

    /* renamed from: d */
    final /* synthetic */ C2145k f5256d;

    C2139e(C2145k kVar, C2151q qVar, Set set, AtomicBoolean atomicBoolean) {
        this.f5256d = kVar;
        this.f5253a = qVar;
        this.f5254b = set;
        this.f5255c = atomicBoolean;
    }

    /* renamed from: a */
    public final void mo22148a(ZipFile zipFile, Set<C2144j> set) throws IOException {
        this.f5256d.m5397f(this.f5253a, set, new C2138d(this));
    }
}
