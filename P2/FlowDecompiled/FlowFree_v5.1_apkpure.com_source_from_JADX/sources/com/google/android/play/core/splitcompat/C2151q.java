package com.google.android.play.core.splitcompat;

import java.io.File;
import java.util.Objects;

/* renamed from: com.google.android.play.core.splitcompat.q */
final class C2151q {

    /* renamed from: a */
    private final File f5273a;

    /* renamed from: b */
    private final String f5274b;

    C2151q() {
    }

    C2151q(File file, String str) {
        this();
        Objects.requireNonNull(file, "Null splitFile");
        this.f5273a = file;
        Objects.requireNonNull(str, "Null splitId");
        this.f5274b = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public File mo22154a() {
        return this.f5273a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo22155b() {
        return this.f5274b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2151q) {
            C2151q qVar = (C2151q) obj;
            return this.f5273a.equals(qVar.mo22154a()) && this.f5274b.equals(qVar.mo22155b());
        }
    }

    public int hashCode() {
        return ((this.f5273a.hashCode() ^ 1000003) * 1000003) ^ this.f5274b.hashCode();
    }

    public String toString() {
        String valueOf = String.valueOf(this.f5273a);
        String str = this.f5274b;
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 35 + str.length());
        sb.append("SplitFileInfo{splitFile=");
        sb.append(valueOf);
        sb.append(", splitId=");
        sb.append(str);
        sb.append("}");
        return sb.toString();
    }
}
