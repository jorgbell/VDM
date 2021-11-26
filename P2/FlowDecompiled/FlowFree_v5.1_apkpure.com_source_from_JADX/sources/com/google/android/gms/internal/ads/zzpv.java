package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.mopub.mobileads.VastVideoViewController;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzpv {
    private static final byte[] zza = {0, 0, 0, 1};
    private static final int[] zzb = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, VastVideoViewController.MAX_VIDEO_DURATION_FOR_CLOSE_BUTTON, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zza(byte[] bArr) {
        zzqb zzqb = new zzqb(bArr, bArr.length);
        int zzc2 = zzc(zzqb);
        int zzd = zzd(zzqb);
        int zza2 = zzqb.zza(4);
        if (zzc2 == 5 || zzc2 == 29) {
            zzd = zzd(zzqb);
            if (zzc(zzqb) == 22) {
                zza2 = zzqb.zza(4);
            }
        }
        int i = zzc[zza2];
        zzpu.zza(i != -1);
        return Pair.create(Integer.valueOf(zzd), Integer.valueOf(i));
    }

    public static byte[] zzb(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[(i2 + 4)];
        System.arraycopy(zza, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i, bArr2, 4, i2);
        return bArr2;
    }

    private static int zzc(zzqb zzqb) {
        int zza2 = zzqb.zza(5);
        return zza2 == 31 ? zzqb.zza(6) + 32 : zza2;
    }

    private static int zzd(zzqb zzqb) {
        int zza2 = zzqb.zza(4);
        if (zza2 == 15) {
            return zzqb.zza(24);
        }
        zzpu.zza(zza2 < 13);
        return zzb[zza2];
    }
}
