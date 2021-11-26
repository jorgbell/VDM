package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzesf implements Iterable<Byte>, Serializable {
    public static final zzesf zzb = new zzesc(zzetr.zzc);
    private int zza = 0;

    static {
        int i = zzerr.zza;
    }

    zzesf() {
    }

    public static zzesd zzA() {
        return new zzesd(128);
    }

    static void zzC(int i, int i2) {
        if (((i2 - (i + 1)) | i) >= 0) {
            return;
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
        sb2.append(i2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    public static zzesf zzr(byte[] bArr, int i, int i2) {
        zzD(i, i + i2, bArr.length);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new zzesc(bArr2);
    }

    public static zzesf zzs(byte[] bArr) {
        return zzr(bArr, 0, bArr.length);
    }

    static zzesf zzt(byte[] bArr) {
        return new zzesc(bArr);
    }

    public static zzesf zzu(String str) {
        return new zzesc(str.getBytes(zzetr.zza));
    }

    public static zzesf zzv(InputStream inputStream) throws IOException {
        zzesf zzesf;
        ArrayList arrayList = new ArrayList();
        int i = 256;
        while (true) {
            byte[] bArr = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = inputStream.read(bArr, i2, i - i2);
                if (read == -1) {
                    break;
                }
                i2 += read;
            }
            if (i2 == 0) {
                zzesf = null;
            } else {
                zzesf = zzr(bArr, 0, i2);
            }
            if (zzesf == null) {
                return zzw(arrayList);
            }
            arrayList.add(zzesf);
            i = Math.min(i + i, 8192);
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.Collection, java.lang.Iterable<com.google.android.gms.internal.ads.zzesf>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzesf zzw(java.lang.Iterable<com.google.android.gms.internal.ads.zzesf> r3) {
        /*
            boolean r0 = r3 instanceof java.util.Collection
            if (r0 != 0) goto L_0x0015
            java.util.Iterator r0 = r3.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0019
            r0.next()
            int r1 = r1 + 1
            goto L_0x0009
        L_0x0015:
            int r1 = r3.size()
        L_0x0019:
            if (r1 != 0) goto L_0x001e
            com.google.android.gms.internal.ads.zzesf r3 = zzb
            return r3
        L_0x001e:
            java.util.Iterator r3 = r3.iterator()
            com.google.android.gms.internal.ads.zzesf r3 = zzd(r3, r1)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzesf.zzw(java.lang.Iterable):com.google.android.gms.internal.ads.zzesf");
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i = this.zza;
        if (i == 0) {
            int zzc = zzc();
            i = zzn(zzc, 0, zzc);
            if (i == 0) {
                i = 1;
            }
            this.zza = i;
        }
        return i;
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(zzc());
        objArr[2] = zzc() <= 50 ? zzevr.zza(this) : String.valueOf(zzevr.zza(zzi(0, 47))).concat("...");
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    /* access modifiers changed from: protected */
    public final int zzB() {
        return this.zza;
    }

    public abstract byte zza(int i);

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i);

    public abstract int zzc();

    /* access modifiers changed from: protected */
    public abstract void zze(byte[] bArr, int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzf();

    /* access modifiers changed from: protected */
    public abstract boolean zzg();

    public abstract zzesf zzi(int i, int i2);

    /* access modifiers changed from: package-private */
    public abstract void zzj(zzerv zzerv) throws IOException;

    /* access modifiers changed from: protected */
    public abstract String zzk(Charset charset);

    public abstract boolean zzl();

    /* access modifiers changed from: protected */
    public abstract int zzm(int i, int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract int zzn(int i, int i2, int i3);

    public abstract zzesj zzo();

    /* renamed from: zzp */
    public zzesa iterator() {
        return new zzerw(this);
    }

    public final boolean zzq() {
        return zzc() == 0;
    }

    @Deprecated
    public final void zzx(byte[] bArr, int i, int i2, int i3) {
        zzD(i, i + i3, zzc());
        zzD(i2, i2 + i3, bArr.length);
        if (i3 > 0) {
            zze(bArr, i, i2, i3);
        }
    }

    public final byte[] zzy() {
        int zzc = zzc();
        if (zzc == 0) {
            return zzetr.zzc;
        }
        byte[] bArr = new byte[zzc];
        zze(bArr, 0, 0, zzc);
        return bArr;
    }

    public final String zzz(Charset charset) {
        return zzc() == 0 ? "" : zzk(charset);
    }

    private static zzesf zzd(Iterator<zzesf> it, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i)}));
        } else if (i == 1) {
            return it.next();
        } else {
            int i2 = i >>> 1;
            zzesf zzd = zzd(it, i2);
            zzesf zzd2 = zzd(it, i - i2);
            if (Integer.MAX_VALUE - zzd.zzc() >= zzd2.zzc()) {
                return zzeve.zzd(zzd, zzd2);
            }
            int zzc = zzd.zzc();
            int zzc2 = zzd2.zzc();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(zzc);
            sb.append("+");
            sb.append(zzc2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    static int zzD(int i, int i2, int i3) {
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
}
