package com.google.android.gms.internal.drive;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class zzjc implements Serializable, Iterable<Byte> {
    public static final zzjc zznq = new zzjm(zzkm.zzsn);
    private int zzns = 0;

    zzjc() {
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i, int i2, int i3);

    public abstract zzjc zza(int i, int i2);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(zzjb zzjb) throws IOException;

    public abstract boolean zzbu();

    public abstract byte zzs(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzt(int i);

    public static zzjc zzk(String str) {
        return new zzjm(str.getBytes(zzkm.UTF_8));
    }

    public final String zzbt() {
        return size() == 0 ? "" : zza(zzkm.UTF_8);
    }

    public final int hashCode() {
        int i = this.zzns;
        if (i == 0) {
            int size = size();
            i = zza(size, 0, size);
            if (i == 0) {
                i = 1;
            }
            this.zzns = i;
        }
        return i;
    }

    static zzjk zzu(int i) {
        return new zzjk(i, (zzjd) null);
    }

    /* access modifiers changed from: protected */
    public final int zzbv() {
        return this.zzns;
    }

    static int zzb(int i, int i2, int i3) {
        int i4 = i2 - i;
        if ((i | i2 | i4 | (i3 - i2)) >= 0) {
            return i4;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i2 < i) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i2);
            sb3.append(" >= ");
            sb3.append(i3);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new zzjd(this);
    }

    static {
        boolean zzbr = zzix.zzbr();
    }
}
