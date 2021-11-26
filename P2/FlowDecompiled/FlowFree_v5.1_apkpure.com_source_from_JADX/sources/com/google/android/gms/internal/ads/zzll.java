package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzll {
    private final zzqc zza = new zzqc(8);
    private int zzb;

    private final long zzb(zzkt zzkt) throws IOException, InterruptedException {
        int i = 0;
        zzkt.zze(this.zza.zza, 0, 1, false);
        byte b = this.zza.zza[0] & Constants.UNKNOWN;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (i2 ^ -1);
        zzkt.zze(this.zza.zza, 1, i3, false);
        while (i < i3) {
            i++;
            i4 = (this.zza.zza[i] & Constants.UNKNOWN) + (i4 << 8);
        }
        this.zzb += i3 + 1;
        return (long) i4;
    }

    public final boolean zza(zzkt zzkt) throws IOException, InterruptedException {
        long zzi = zzkt.zzi();
        long j = 1024;
        if (zzi != -1 && zzi <= 1024) {
            j = zzi;
        }
        int i = (int) j;
        zzkt.zze(this.zza.zza, 0, 4, false);
        long zzp = this.zza.zzp();
        this.zzb = 4;
        while (zzp != 440786851) {
            int i2 = this.zzb + 1;
            this.zzb = i2;
            if (i2 == i) {
                return false;
            }
            zzkt.zze(this.zza.zza, 0, 1, false);
            zzp = ((zzp << 8) & -256) | ((long) (this.zza.zza[0] & Constants.UNKNOWN));
        }
        long zzb2 = zzb(zzkt);
        long j2 = (long) this.zzb;
        if (zzb2 != Long.MIN_VALUE && (zzi == -1 || j2 + zzb2 < zzi)) {
            while (true) {
                long j3 = (long) this.zzb;
                long j4 = j2 + zzb2;
                if (j3 < j4) {
                    if (zzb(zzkt) == Long.MIN_VALUE) {
                        return false;
                    }
                    long zzb3 = zzb(zzkt);
                    if (zzb3 < 0) {
                        return false;
                    }
                    if (zzb3 != 0) {
                        zzkt.zzf((int) zzb3, false);
                        this.zzb = (int) (((long) this.zzb) + zzb3);
                    }
                } else if (j3 == j4) {
                    return true;
                }
            }
        }
        return false;
    }
}
