package com.google.android.play.core.assetpacks;

import java.util.Arrays;

/* renamed from: com.google.android.play.core.assetpacks.de */
final class C2029de {

    /* renamed from: a */
    private final String f5091a;

    /* renamed from: b */
    private final long f5092b;

    /* renamed from: c */
    private final int f5093c;

    /* renamed from: d */
    private final boolean f5094d;

    /* renamed from: e */
    private final boolean f5095e;

    /* renamed from: f */
    private final byte[] f5096f;

    C2029de() {
    }

    C2029de(String str, long j, int i, boolean z, boolean z2, byte[] bArr) {
        this();
        this.f5091a = str;
        this.f5092b = j;
        this.f5093c = i;
        this.f5094d = z;
        this.f5095e = z2;
        this.f5096f = bArr;
    }

    /* renamed from: a */
    static C2029de m5086a(String str, long j, int i, boolean z, byte[] bArr, boolean z2) {
        return new C2029de(str, j, i, z, z2, bArr);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final boolean mo21995b() {
        if (mo21997d() == null) {
            return false;
        }
        return mo21997d().endsWith("/");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final boolean mo21996c() {
        return mo22000f() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public String mo21997d() {
        return this.f5091a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public long mo21998e() {
        return this.f5092b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2029de) {
            C2029de deVar = (C2029de) obj;
            String str = this.f5091a;
            if (str != null ? str.equals(deVar.mo21997d()) : deVar.mo21997d() == null) {
                if (this.f5092b == deVar.mo21998e() && this.f5093c == deVar.mo22000f() && this.f5094d == deVar.mo22001g() && this.f5095e == deVar.mo22002h()) {
                    if (Arrays.equals(this.f5096f, deVar instanceof C2029de ? deVar.f5096f : deVar.mo22004i())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo22000f() {
        return this.f5093c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo22001g() {
        return this.f5094d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean mo22002h() {
        return this.f5095e;
    }

    public int hashCode() {
        String str = this.f5091a;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f5092b;
        int i = 1237;
        int i2 = (((((((hashCode ^ 1000003) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ this.f5093c) * 1000003) ^ (true != this.f5094d ? 1237 : 1231)) * 1000003;
        if (true == this.f5095e) {
            i = 1231;
        }
        return ((i2 ^ i) * 1000003) ^ Arrays.hashCode(this.f5096f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public byte[] mo22004i() {
        return this.f5096f;
    }

    public String toString() {
        String str = this.f5091a;
        long j = this.f5092b;
        int i = this.f5093c;
        boolean z = this.f5094d;
        boolean z2 = this.f5095e;
        String arrays = Arrays.toString(this.f5096f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 126 + String.valueOf(arrays).length());
        sb.append("ZipEntry{name=");
        sb.append(str);
        sb.append(", size=");
        sb.append(j);
        sb.append(", compressionMethod=");
        sb.append(i);
        sb.append(", isPartial=");
        sb.append(z);
        sb.append(", isEndOfArchive=");
        sb.append(z2);
        sb.append(", headerBytes=");
        sb.append(arrays);
        sb.append("}");
        return sb.toString();
    }
}
