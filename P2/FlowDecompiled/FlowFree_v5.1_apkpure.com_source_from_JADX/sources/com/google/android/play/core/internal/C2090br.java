package com.google.android.play.core.internal;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.br */
public abstract class C2090br implements Closeable {
    /* renamed from: a */
    public abstract long mo21901a();

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract InputStream mo21902b(long j, long j2) throws IOException;

    /* renamed from: c */
    public final synchronized InputStream mo22059c() throws IOException {
        return mo21902b(0, mo21901a());
    }
}
