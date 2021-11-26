package com.google.android.play.core.assetpacks;

/* renamed from: com.google.android.play.core.assetpacks.cy */
final class C2023cy {

    /* renamed from: a */
    private final int f5070a;

    /* renamed from: b */
    private final String f5071b;

    /* renamed from: c */
    private final long f5072c;

    /* renamed from: d */
    private final long f5073d;

    /* renamed from: e */
    private final int f5074e;

    C2023cy() {
    }

    C2023cy(int i, String str, long j, long j2, int i2) {
        this();
        this.f5070a = i;
        this.f5071b = str;
        this.f5072c = j;
        this.f5073d = j2;
        this.f5074e = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo21972a() {
        return this.f5070a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo21973b() {
        return this.f5071b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public long mo21974c() {
        return this.f5072c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public long mo21975d() {
        return this.f5073d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo21976e() {
        return this.f5074e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0013, code lost:
        r1 = r7.f5071b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r8) {
        /*
            r7 = this;
            r0 = 1
            if (r8 != r7) goto L_0x0004
            return r0
        L_0x0004:
            boolean r1 = r8 instanceof com.google.android.play.core.assetpacks.C2023cy
            r2 = 0
            if (r1 == 0) goto L_0x0046
            com.google.android.play.core.assetpacks.cy r8 = (com.google.android.play.core.assetpacks.C2023cy) r8
            int r1 = r7.f5070a
            int r3 = r8.mo21972a()
            if (r1 != r3) goto L_0x0046
            java.lang.String r1 = r7.f5071b
            if (r1 != 0) goto L_0x001e
            java.lang.String r1 = r8.mo21973b()
            if (r1 != 0) goto L_0x0046
            goto L_0x0029
        L_0x001e:
            java.lang.String r3 = r8.mo21973b()
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0029
            goto L_0x0046
        L_0x0029:
            long r3 = r7.f5072c
            long r5 = r8.mo21974c()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            long r3 = r7.f5073d
            long r5 = r8.mo21975d()
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x0046
            int r1 = r7.f5074e
            int r8 = r8.mo21976e()
            if (r1 != r8) goto L_0x0046
            return r0
        L_0x0046:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.play.core.assetpacks.C2023cy.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int i = (this.f5070a ^ 1000003) * 1000003;
        String str = this.f5071b;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f5072c;
        long j2 = this.f5073d;
        return ((((((i ^ hashCode) * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.f5074e;
    }

    public String toString() {
        int i = this.f5070a;
        String str = this.f5071b;
        long j = this.f5072c;
        long j2 = this.f5073d;
        int i2 = this.f5074e;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 157);
        sb.append("SliceCheckpoint{fileExtractionStatus=");
        sb.append(i);
        sb.append(", filePath=");
        sb.append(str);
        sb.append(", fileOffset=");
        sb.append(j);
        sb.append(", remainingBytes=");
        sb.append(j2);
        sb.append(", previousChunk=");
        sb.append(i2);
        sb.append("}");
        return sb.toString();
    }
}
