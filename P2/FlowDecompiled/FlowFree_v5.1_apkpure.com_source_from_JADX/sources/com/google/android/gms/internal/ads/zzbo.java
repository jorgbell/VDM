package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbo {
    public static long zza(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int zzb(ByteBuffer byteBuffer) {
        return (zzc(byteBuffer.get()) << 8) + zzc(byteBuffer.get());
    }

    public static int zzc(byte b) {
        return b < 0 ? b + Constants.FEMALE : b;
    }

    public static long zzd(ByteBuffer byteBuffer) {
        long zza = zza(byteBuffer) << 32;
        if (zza >= 0) {
            return zza + zza(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static double zze(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (((bArr[0] << 24) & Constants.FEMALE) | ((bArr[1] << 16) & Constants.FEMALE) | ((bArr[2] << 8) & Constants.FEMALE) | (bArr[3] & Constants.UNKNOWN));
        Double.isNaN(d);
        return d / 65536.0d;
    }

    public static double zzf(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (((bArr[0] << 24) & Constants.FEMALE) | ((bArr[1] << 16) & Constants.FEMALE) | ((bArr[2] << 8) & Constants.FEMALE) | (bArr[3] & Constants.UNKNOWN));
        Double.isNaN(d);
        return d / 1.073741824E9d;
    }
}
