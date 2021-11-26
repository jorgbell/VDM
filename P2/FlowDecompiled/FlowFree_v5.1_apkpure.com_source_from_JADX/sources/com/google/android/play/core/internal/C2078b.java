package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.b */
final class C2078b implements C2099c {

    /* renamed from: a */
    private final ByteBuffer f5183a;

    public C2078b(ByteBuffer byteBuffer) {
        this.f5183a = byteBuffer.slice();
    }

    /* renamed from: a */
    public final long mo22051a() {
        return (long) this.f5183a.capacity();
    }

    /* renamed from: b */
    public final void mo22052b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        ByteBuffer slice;
        synchronized (this.f5183a) {
            int i2 = (int) j;
            this.f5183a.position(i2);
            this.f5183a.limit(i2 + i);
            slice = this.f5183a.slice();
        }
        for (MessageDigest update : messageDigestArr) {
            slice.position(0);
            update.update(slice);
        }
    }
}
