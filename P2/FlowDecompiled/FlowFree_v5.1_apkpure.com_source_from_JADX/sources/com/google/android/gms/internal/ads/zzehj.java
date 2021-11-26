package com.google.android.gms.internal.ads;

import com.flurry.android.Constants;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzehj implements Comparable<zzehj> {
    private final byte[] zza;

    /* synthetic */ zzehj(byte[] bArr, zzehh zzehh) {
        this.zza = Arrays.copyOf(bArr, bArr.length);
    }

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        zzehj zzehj = (zzehj) obj;
        int length = this.zza.length;
        int length2 = zzehj.zza.length;
        if (length != length2) {
            return length - length2;
        }
        int i = 0;
        while (true) {
            byte[] bArr = this.zza;
            if (i >= bArr.length) {
                return 0;
            }
            byte b = bArr[i];
            byte b2 = zzehj.zza[i];
            if (b != b2) {
                return b - b2;
            }
            i++;
        }
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzehj)) {
            return false;
        }
        return Arrays.equals(this.zza, ((zzehj) obj).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r2 + r2);
        for (byte b : this.zza) {
            byte b2 = b & Constants.UNKNOWN;
            sb.append("0123456789abcdef".charAt(b2 >> 4));
            sb.append("0123456789abcdef".charAt(b2 & 15));
        }
        return sb.toString();
    }
}
