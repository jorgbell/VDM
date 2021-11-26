package com.google.android.play.core.splitcompat;

import java.io.File;
import java.io.IOException;

/* renamed from: com.google.android.play.core.splitcompat.d */
final class C2138d implements C2143i {

    /* renamed from: a */
    final /* synthetic */ C2139e f5252a;

    C2138d(C2139e eVar) {
        this.f5252a = eVar;
    }

    /* renamed from: a */
    public final void mo22147a(C2144j jVar, File file, boolean z) throws IOException {
        this.f5252a.f5254b.add(file);
        if (!z) {
            this.f5252a.f5255c.set(false);
        }
    }
}
