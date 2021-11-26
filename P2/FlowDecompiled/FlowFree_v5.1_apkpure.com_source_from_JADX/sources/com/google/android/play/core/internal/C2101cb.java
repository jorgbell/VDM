package com.google.android.play.core.internal;

/* renamed from: com.google.android.play.core.internal.cb */
public final class C2101cb<T> implements C2103ce<T> {

    /* renamed from: a */
    private C2103ce<T> f5200a;

    /* renamed from: b */
    public static <T> void m5256b(C2103ce<T> ceVar, C2103ce<T> ceVar2) {
        C2086bh.m5231j(ceVar2);
        C2101cb cbVar = (C2101cb) ceVar;
        if (cbVar.f5200a == null) {
            cbVar.f5200a = ceVar2;
            return;
        }
        throw new IllegalStateException();
    }

    /* renamed from: a */
    public final T mo21822a() {
        C2103ce<T> ceVar = this.f5200a;
        if (ceVar != null) {
            return ceVar.mo21822a();
        }
        throw new IllegalStateException();
    }
}
