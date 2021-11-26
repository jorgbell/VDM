package com.google.android.gms.internal.measurement;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public final class zzhz {
    static final Charset zza = Charset.forName("UTF-8");
    public static final byte[] zzc;

    static {
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        zzc = bArr;
        ByteBuffer.wrap(bArr);
        try {
            new zzgt(bArr, 0, 0, false, (zzgs) null).zza(0);
        } catch (zzib e) {
            throw new IllegalArgumentException(e);
        }
    }

    static <T> T zza(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    static <T> T zzb(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    public static boolean zzc(byte[] bArr) {
        return zzkk.zza(bArr);
    }

    public static String zzd(byte[] bArr) {
        return new String(bArr, zza);
    }

    public static int zze(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int zzf(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int zzg(byte[] bArr) {
        int length = bArr.length;
        int zzh = zzh(length, bArr, 0, length);
        if (zzh == 0) {
            return 1;
        }
        return zzh;
    }

    static int zzh(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    static Object zzi(Object obj, Object obj2) {
        zziv zzbG = ((zziw) obj).zzbG();
        zzbG.zzau((zziw) obj2);
        return zzbG.zzaD();
    }
}
