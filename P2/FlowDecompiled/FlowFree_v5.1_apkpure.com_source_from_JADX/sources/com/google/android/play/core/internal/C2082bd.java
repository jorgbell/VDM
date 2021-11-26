package com.google.android.play.core.internal;

import java.io.File;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bd */
final class C2082bd implements C2081bc {

    /* renamed from: a */
    private final /* synthetic */ int f5186a = 0;

    C2082bd() {
    }

    C2082bd(byte[] bArr) {
    }

    /* renamed from: a */
    public final Object[] mo22053a(Object obj, List list, List list2) {
        Object a;
        if (this.f5186a != 0) {
            a = C2086bh.m5223b(obj, "makePathElements", Object[].class, List.class, list, File.class, null, List.class, list2);
        } else {
            a = C2086bh.m5222a(obj, "makePathElements", Object[].class, List.class, list);
        }
        return (Object[]) a;
    }
}
