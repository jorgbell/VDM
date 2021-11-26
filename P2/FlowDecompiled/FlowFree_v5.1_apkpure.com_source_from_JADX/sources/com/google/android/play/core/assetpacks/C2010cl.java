package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Objects;

/* renamed from: com.google.android.play.core.assetpacks.cl */
public final class C2010cl extends InputStream {

    /* renamed from: a */
    private final Enumeration<File> f5020a;

    /* renamed from: b */
    private InputStream f5021b;

    public C2010cl(Enumeration<File> enumeration) throws IOException {
        this.f5020a = enumeration;
        mo21957a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo21957a() throws IOException {
        InputStream inputStream = this.f5021b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f5021b = this.f5020a.hasMoreElements() ? new FileInputStream(this.f5020a.nextElement()) : null;
    }

    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.f5021b;
        if (inputStream != null) {
            inputStream.close();
            this.f5021b = null;
        }
    }

    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f5021b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            mo21957a();
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f5021b == null) {
            return -1;
        }
        Objects.requireNonNull(bArr);
        if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.f5021b.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                mo21957a();
            } while (this.f5021b != null);
            return -1;
        }
    }
}
