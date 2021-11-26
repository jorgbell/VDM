package com.google.android.play.core.internal;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.internal.bs */
public final class C2091bs extends C2090br {

    /* renamed from: a */
    private final C2090br f5192a;

    /* renamed from: b */
    private final long f5193b;

    /* renamed from: c */
    private final long f5194c;

    public C2091bs(C2090br brVar, long j, long j2) {
        this.f5192a = brVar;
        long d = m5244d(j);
        this.f5193b = d;
        this.f5194c = m5244d(d + j2);
    }

    /* renamed from: d */
    private final long m5244d(long j) {
        if (j < 0) {
            return 0;
        }
        return j > this.f5192a.mo21901a() ? this.f5192a.mo21901a() : j;
    }

    /* renamed from: a */
    public final long mo21901a() {
        return this.f5194c - this.f5193b;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public final InputStream mo21902b(long j, long j2) throws IOException {
        long d = m5244d(this.f5193b);
        return this.f5192a.mo21902b(d, m5244d(j2 + d) - d);
    }

    public final void close() throws IOException {
    }
}
