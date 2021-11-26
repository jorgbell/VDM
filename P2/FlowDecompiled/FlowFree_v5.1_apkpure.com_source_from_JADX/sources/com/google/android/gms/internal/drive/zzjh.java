package com.google.android.gms.internal.drive;

final class zzjh extends zzjm {
    private final int zznv;
    private final int zznw;

    zzjh(byte[] bArr, int i, int i2) {
        super(bArr);
        zzjc.zzb(i, i + i2, bArr.length);
        this.zznv = i;
        this.zznw = i2;
    }

    public final byte zzs(int i) {
        int size = size();
        if (((size - (i + 1)) | i) >= 0) {
            return this.zzny[this.zznv + i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzt(int i) {
        return this.zzny[this.zznv + i];
    }

    public final int size() {
        return this.zznw;
    }

    /* access modifiers changed from: protected */
    public final int zzbw() {
        return this.zznv;
    }
}
