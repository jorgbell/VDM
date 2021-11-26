package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Objects;

class zzjm extends zzjl {
    protected final byte[] zzny;

    zzjm(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.zzny = bArr;
    }

    /* access modifiers changed from: protected */
    public int zzbw() {
        return 0;
    }

    public byte zzs(int i) {
        return this.zzny[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzt(int i) {
        return this.zzny[i];
    }

    public int size() {
        return this.zzny.length;
    }

    public final zzjc zza(int i, int i2) {
        int zzb = zzjc.zzb(0, i2, size());
        if (zzb == 0) {
            return zzjc.zznq;
        }
        return new zzjh(this.zzny, zzbw(), zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjb zzjb) throws IOException {
        zzjb.zza(this.zzny, zzbw(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzny, zzbw(), size(), charset);
    }

    public final boolean zzbu() {
        int zzbw = zzbw();
        return zznf.zze(this.zzny, zzbw, size() + zzbw);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzjc) || size() != ((zzjc) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzjm)) {
            return obj.equals(this);
        }
        zzjm zzjm = (zzjm) obj;
        int zzbv = zzbv();
        int zzbv2 = zzjm.zzbv();
        if (zzbv == 0 || zzbv2 == 0 || zzbv == zzbv2) {
            return zza(zzjm, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzjc zzjc, int i, int i2) {
        if (i2 > zzjc.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i2 > zzjc.size()) {
            int size2 = zzjc.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(zzjc instanceof zzjm)) {
            return zzjc.zza(0, i2).equals(zza(0, i2));
        } else {
            zzjm zzjm = (zzjm) zzjc;
            byte[] bArr = this.zzny;
            byte[] bArr2 = zzjm.zzny;
            int zzbw = zzbw() + i2;
            int zzbw2 = zzbw();
            int zzbw3 = zzjm.zzbw();
            while (zzbw2 < zzbw) {
                if (bArr[zzbw2] != bArr2[zzbw3]) {
                    return false;
                }
                zzbw2++;
                zzbw3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i, int i2, int i3) {
        return zzkm.zza(i, this.zzny, zzbw(), i3);
    }
}
