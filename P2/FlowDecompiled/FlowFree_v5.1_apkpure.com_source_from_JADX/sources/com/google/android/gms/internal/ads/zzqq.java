package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzqq {
    public final List<byte[]> zza;
    public final int zzb;

    private zzqq(List<byte[]> list, int i) {
        this.zza = list;
        this.zzb = i;
    }

    public static zzqq zza(zzqc zzqc) throws zziw {
        List list;
        try {
            zzqc.zzj(21);
            int zzl = zzqc.zzl() & 3;
            int zzl2 = zzqc.zzl();
            int zzg = zzqc.zzg();
            int i = 0;
            for (int i2 = 0; i2 < zzl2; i2++) {
                zzqc.zzj(1);
                int zzm = zzqc.zzm();
                for (int i3 = 0; i3 < zzm; i3++) {
                    int zzm2 = zzqc.zzm();
                    i += zzm2 + 4;
                    zzqc.zzj(zzm2);
                }
            }
            zzqc.zzi(zzg);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < zzl2; i5++) {
                zzqc.zzj(1);
                int zzm3 = zzqc.zzm();
                for (int i6 = 0; i6 < zzm3; i6++) {
                    int zzm4 = zzqc.zzm();
                    System.arraycopy(zzqa.zza, 0, bArr, i4, 4);
                    int i7 = i4 + 4;
                    System.arraycopy(zzqc.zza, zzqc.zzg(), bArr, i7, zzm4);
                    i4 = i7 + zzm4;
                    zzqc.zzj(zzm4);
                }
            }
            if (i == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzqq(list, zzl + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zziw("Error parsing HEVC config", e);
        }
    }
}
