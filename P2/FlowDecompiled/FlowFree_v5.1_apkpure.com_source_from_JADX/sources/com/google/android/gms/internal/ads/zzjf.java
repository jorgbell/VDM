package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzjf {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {1, 2, 3, 6};
    private static final int[] zzc = {48000, 44100, 32000};
    private static final int[] zzd = {2, 1, 2, 3, 3, 4, 4, 5};

    public static zzit zza(zzqc zzqc, String str, String str2, zzkq zzkq) {
        int i = zzc[(zzqc.zzl() & 192) >> 6];
        int zzl = zzqc.zzl();
        int i2 = zzd[(zzl & 56) >> 3];
        if ((zzl & 4) != 0) {
            i2++;
        }
        return zzit.zzb(str, "audio/ac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzkq, 0, str2);
    }

    public static zzit zzb(zzqc zzqc, String str, String str2, zzkq zzkq) {
        zzqc zzqc2 = zzqc;
        zzqc.zzj(2);
        int i = zzc[(zzqc.zzl() & 192) >> 6];
        int zzl = zzqc.zzl();
        int i2 = zzd[(zzl & 14) >> 1];
        if ((zzl & 1) != 0) {
            i2++;
        }
        return zzit.zzb(str, "audio/eac3", (String) null, -1, -1, i2, i, (List<byte[]>) null, zzkq, 0, str2);
    }

    public static int zzc(ByteBuffer byteBuffer) {
        int i = 6;
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = zzb[(byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4];
        }
        return i * 256;
    }
}
