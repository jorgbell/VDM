package com.google.android.play.core.assetpacks;

import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.google.android.play.core.assetpacks.av */
final class C1971av extends InputStream {

    /* renamed from: a */
    private final InputStream f4858a;

    /* renamed from: b */
    private long f4859b;

    C1971av(InputStream inputStream, long j) {
        this.f4858a = inputStream;
        this.f4859b = j;
    }

    public final void close() throws IOException {
        super.close();
        this.f4858a.close();
        this.f4859b = 0;
    }

    public final int read() throws IOException {
        long j = this.f4859b;
        if (j <= 0) {
            return -1;
        }
        this.f4859b = j - 1;
        return this.f4858a.read();
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f4859b;
        if (j <= 0) {
            return -1;
        }
        int read = this.f4858a.read(bArr, i, (int) Math.min((long) i2, j));
        if (read != -1) {
            this.f4859b -= (long) read;
        }
        return read;
    }
}
