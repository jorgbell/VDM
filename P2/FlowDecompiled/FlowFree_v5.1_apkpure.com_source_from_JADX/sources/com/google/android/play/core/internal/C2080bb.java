package com.google.android.play.core.internal;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bb */
final class C2080bb implements C2077az {

    /* renamed from: a */
    private final /* synthetic */ int f5185a = 0;

    C2080bb() {
    }

    C2080bb(byte[] bArr) {
    }

    /* renamed from: a */
    public final Object[] mo22050a(Object obj, ArrayList arrayList, File file, ArrayList arrayList2) {
        Object b;
        if (this.f5185a != 0) {
            b = C2086bh.m5223b(obj, "makeDexElements", Object[].class, ArrayList.class, arrayList, File.class, file, ArrayList.class, arrayList2);
        } else {
            b = C2086bh.m5223b(obj, "makePathElements", Object[].class, List.class, arrayList, File.class, file, List.class, arrayList2);
        }
        return (Object[]) b;
    }
}
