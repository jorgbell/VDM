package com.google.android.play.core.assetpacks;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.bd */
final class C1978bd extends FilterInputStream {

    /* renamed from: a */
    private final C2011cm f4880a = new C2011cm();

    /* renamed from: b */
    private byte[] f4881b = new byte[4096];

    /* renamed from: c */
    private long f4882c;

    /* renamed from: d */
    private boolean f4883d = false;

    /* renamed from: e */
    private boolean f4884e = false;

    C1978bd(InputStream inputStream) {
        super(inputStream);
    }

    /* renamed from: e */
    private final boolean m4975e(int i) throws IOException {
        int f = m4976f(this.f4881b, 0, i);
        if (f != i) {
            int i2 = i - f;
            if (m4976f(this.f4881b, f, i2) != i2) {
                this.f4880a.mo21961a(this.f4881b, 0, f);
                return false;
            }
        }
        this.f4880a.mo21961a(this.f4881b, 0, i);
        return true;
    }

    /* renamed from: f */
    private final int m4976f(byte[] bArr, int i, int i2) throws IOException {
        return Math.max(0, super.read(bArr, i, i2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final C2029de mo21916a() throws IOException {
        byte[] bArr;
        if (this.f4882c > 0) {
            do {
                bArr = this.f4881b;
            } while (read(bArr, 0, bArr.length) != -1);
        }
        if (this.f4883d || this.f4884e) {
            return new C2029de((String) null, -1, -1, false, false, (byte[]) null);
        }
        if (!m4975e(30)) {
            this.f4883d = true;
            return this.f4880a.mo21962b();
        }
        C2029de b = this.f4880a.mo21962b();
        if (b.mo22002h()) {
            this.f4884e = true;
            return b;
        } else if (b.mo21998e() != 4294967295L) {
            int c = this.f4880a.mo21963c() - 30;
            long j = (long) c;
            int length = this.f4881b.length;
            if (j > ((long) length)) {
                do {
                    length += length;
                } while (((long) length) < j);
                this.f4881b = Arrays.copyOf(this.f4881b, length);
            }
            if (!m4975e(c)) {
                this.f4883d = true;
                return this.f4880a.mo21962b();
            }
            C2029de b2 = this.f4880a.mo21962b();
            this.f4882c = b2.mo21998e();
            return b2;
        } else {
            throw new C1985bk("Files bigger than 4GiB are not supported.");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo21917b() {
        return this.f4883d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo21918c() {
        return this.f4884e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final long mo21919d() {
        return this.f4882c;
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f4882c;
        if (j <= 0 || this.f4883d) {
            return -1;
        }
        int f = m4976f(bArr, i, (int) Math.min(j, (long) i2));
        this.f4882c -= (long) f;
        if (f != 0) {
            return f;
        }
        this.f4883d = true;
        return 0;
    }
}
