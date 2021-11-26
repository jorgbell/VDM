package com.google.android.play.core.internal;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;

/* renamed from: com.google.android.play.core.internal.d */
final class C2104d implements C2099c {

    /* renamed from: a */
    private final FileChannel f5204a;

    /* renamed from: b */
    private final long f5205b;

    /* renamed from: c */
    private final long f5206c;

    public C2104d(FileChannel fileChannel, long j, long j2) {
        this.f5204a = fileChannel;
        this.f5205b = j;
        this.f5206c = j2;
    }

    /* renamed from: a */
    public final long mo22051a() {
        return this.f5206c;
    }

    /* renamed from: b */
    public final void mo22052b(MessageDigest[] messageDigestArr, long j, int i) throws IOException {
        MappedByteBuffer map = this.f5204a.map(FileChannel.MapMode.READ_ONLY, this.f5205b + j, (long) i);
        map.load();
        for (MessageDigest update : messageDigestArr) {
            map.position(0);
            update.update(map);
        }
    }
}
