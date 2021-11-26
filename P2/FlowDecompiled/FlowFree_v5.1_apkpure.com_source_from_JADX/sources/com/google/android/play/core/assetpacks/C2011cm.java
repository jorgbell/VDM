package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.cm */
final class C2011cm {

    /* renamed from: a */
    private byte[] f5022a = new byte[4096];

    /* renamed from: b */
    private int f5023b;

    /* renamed from: c */
    private long f5024c;

    /* renamed from: d */
    private long f5025d;

    /* renamed from: e */
    private int f5026e;

    /* renamed from: f */
    private int f5027f;

    /* renamed from: g */
    private int f5028g;

    /* renamed from: h */
    private boolean f5029h;

    /* renamed from: i */
    private String f5030i;

    public C2011cm() {
        mo21964d();
    }

    /* renamed from: e */
    private final int m5048e(int i, byte[] bArr, int i2, int i3) {
        int i4 = this.f5023b;
        if (i4 >= i) {
            return 0;
        }
        int min = Math.min(i3, i - i4);
        System.arraycopy(bArr, i2, this.f5022a, this.f5023b, min);
        int i5 = this.f5023b + min;
        this.f5023b = i5;
        if (i5 < i) {
            return -1;
        }
        return min;
    }

    /* renamed from: a */
    public final int mo21961a(byte[] bArr, int i, int i2) {
        int e = m5048e(30, bArr, i, i2);
        if (e == -1) {
            return -1;
        }
        if (this.f5024c == -1) {
            long d = C2009ck.m5040d(this.f5022a, 0);
            this.f5024c = d;
            if (d == 67324752) {
                this.f5029h = false;
                this.f5025d = C2009ck.m5040d(this.f5022a, 18);
                this.f5028g = C2009ck.m5041e(this.f5022a, 8);
                this.f5026e = C2009ck.m5041e(this.f5022a, 26);
                int e2 = this.f5026e + 30 + C2009ck.m5041e(this.f5022a, 28);
                this.f5027f = e2;
                int length = this.f5022a.length;
                if (length < e2) {
                    do {
                        length += length;
                    } while (length < e2);
                    this.f5022a = Arrays.copyOf(this.f5022a, length);
                }
            } else {
                this.f5029h = true;
            }
        }
        int e3 = m5048e(this.f5027f, bArr, i + e, i2 - e);
        if (e3 == -1) {
            return -1;
        }
        int i3 = e + e3;
        if (!this.f5029h && this.f5030i == null) {
            this.f5030i = new String(this.f5022a, 30, this.f5026e);
        }
        return i3;
    }

    /* renamed from: b */
    public final C2029de mo21962b() {
        int i = this.f5023b;
        int i2 = this.f5027f;
        if (i < i2) {
            return C2029de.m5086a(this.f5030i, this.f5025d, this.f5028g, true, Arrays.copyOf(this.f5022a, i), this.f5029h);
        }
        C2029de a = C2029de.m5086a(this.f5030i, this.f5025d, this.f5028g, false, Arrays.copyOf(this.f5022a, i2), this.f5029h);
        mo21964d();
        return a;
    }

    /* renamed from: c */
    public final int mo21963c() {
        return this.f5027f;
    }

    /* renamed from: d */
    public final void mo21964d() {
        this.f5023b = 0;
        this.f5026e = -1;
        this.f5024c = -1;
        this.f5029h = false;
        this.f5027f = 30;
        this.f5025d = -1;
        this.f5028g = -1;
        this.f5030i = null;
    }
}
