package com.google.android.play.core.splitcompat;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;

/* renamed from: com.google.android.play.core.splitcompat.f */
final class C2140f implements C2142h {

    /* renamed from: a */
    final /* synthetic */ Set f5257a;

    /* renamed from: b */
    final /* synthetic */ C2151q f5258b;

    /* renamed from: c */
    final /* synthetic */ C2145k f5259c;

    C2140f(C2145k kVar, Set set, C2151q qVar) {
        this.f5259c = kVar;
        this.f5257a = set;
        this.f5258b = qVar;
    }

    /* renamed from: a */
    public final void mo22148a(ZipFile zipFile, Set<C2144j> set) throws IOException {
        this.f5257a.addAll(C2145k.m5395d(this.f5259c, set, this.f5258b, zipFile));
    }
}
