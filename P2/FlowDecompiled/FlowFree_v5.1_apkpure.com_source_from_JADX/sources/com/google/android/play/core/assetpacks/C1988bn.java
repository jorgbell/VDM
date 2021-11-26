package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.play.core.assetpacks.bn */
final class C1988bn extends OutputStream {

    /* renamed from: a */
    private final C2011cm f4948a = new C2011cm();

    /* renamed from: b */
    private final File f4949b;

    /* renamed from: c */
    private final C2024cz f4950c;

    /* renamed from: d */
    private long f4951d;

    /* renamed from: e */
    private long f4952e;

    /* renamed from: f */
    private FileOutputStream f4953f;

    /* renamed from: g */
    private C2029de f4954g;

    C1988bn(File file, C2024cz czVar) {
        this.f4949b = file;
        this.f4950c = czVar;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        while (i2 > 0) {
            if (this.f4951d == 0 && this.f4952e == 0) {
                int a = this.f4948a.mo21961a(bArr, i, i2);
                if (a != -1) {
                    i += a;
                    i2 -= a;
                    C2029de b = this.f4948a.mo21962b();
                    this.f4954g = b;
                    if (b.mo22002h()) {
                        this.f4951d = 0;
                        this.f4950c.mo21992m(this.f4954g.mo22004i(), this.f4954g.mo22004i().length);
                        this.f4952e = (long) this.f4954g.mo22004i().length;
                    } else if (!this.f4954g.mo21996c() || this.f4954g.mo21995b()) {
                        byte[] i4 = this.f4954g.mo22004i();
                        this.f4950c.mo21992m(i4, i4.length);
                        this.f4951d = this.f4954g.mo21998e();
                    } else {
                        this.f4950c.mo21986g(this.f4954g.mo22004i());
                        File file = new File(this.f4949b, this.f4954g.mo21997d());
                        file.getParentFile().mkdirs();
                        this.f4951d = this.f4954g.mo21998e();
                        this.f4953f = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.f4954g.mo21995b()) {
                if (this.f4954g.mo22002h()) {
                    this.f4950c.mo21988i(this.f4952e, bArr, i, i2);
                    this.f4952e += (long) i2;
                    i3 = i2;
                } else if (this.f4954g.mo21996c()) {
                    i3 = (int) Math.min((long) i2, this.f4951d);
                    this.f4953f.write(bArr, i, i3);
                    long j = this.f4951d - ((long) i3);
                    this.f4951d = j;
                    if (j == 0) {
                        this.f4953f.close();
                    }
                } else {
                    i3 = (int) Math.min((long) i2, this.f4951d);
                    int length = this.f4954g.mo22004i().length;
                    this.f4950c.mo21988i((((long) length) + this.f4954g.mo21998e()) - this.f4951d, bArr, i, i3);
                    this.f4951d -= (long) i3;
                }
                i += i3;
                i2 -= i3;
            }
        }
    }
}
