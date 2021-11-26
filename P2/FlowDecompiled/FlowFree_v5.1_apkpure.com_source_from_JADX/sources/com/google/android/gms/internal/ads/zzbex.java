package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzbex implements zzpe {
    private final zzpe zza;
    private final long zzb;
    private final zzpe zzc;
    private long zzd;
    private Uri zze;

    zzbex(zzpe zzpe, int i, zzpe zzpe2) {
        this.zza = zzpe;
        this.zzb = (long) i;
        this.zzc = zzpe2;
    }

    public final int zzb(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        long j = this.zzd;
        long j2 = this.zzb;
        if (j < j2) {
            int zzb2 = this.zza.zzb(bArr, i, (int) Math.min((long) i2, j2 - j));
            long j3 = this.zzd + ((long) zzb2);
            this.zzd = j3;
            i3 = zzb2;
            j = j3;
        } else {
            i3 = 0;
        }
        if (j < this.zzb) {
            return i3;
        }
        int zzb3 = this.zzc.zzb(bArr, i + i3, i2 - i3);
        this.zzd += (long) zzb3;
        return i3 + zzb3;
    }

    public final Uri zzc() {
        return this.zze;
    }

    public final void zzd() throws IOException {
        this.zza.zzd();
        this.zzc.zzd();
    }

    public final long zza(zzpg zzpg) throws IOException {
        zzpg zzpg2;
        zzpg zzpg3 = zzpg;
        this.zze = zzpg3.zza;
        long j = zzpg3.zzc;
        long j2 = this.zzb;
        zzpg zzpg4 = null;
        if (j >= j2) {
            zzpg2 = null;
        } else {
            long j3 = zzpg3.zzd;
            zzpg2 = new zzpg(zzpg3.zza, (byte[]) null, j, j, j3 != -1 ? Math.min(j3, j2 - j) : j2 - j, (String) null, 0);
        }
        long j4 = zzpg3.zzd;
        if (j4 == -1 || zzpg3.zzc + j4 > this.zzb) {
            long max = Math.max(this.zzb, zzpg3.zzc);
            long j5 = zzpg3.zzd;
            zzpg4 = new zzpg(zzpg3.zza, (byte[]) null, max, max, j5 != -1 ? Math.min(j5, (zzpg3.zzc + j5) - this.zzb) : -1, (String) null, 0);
        }
        long j6 = 0;
        long zza2 = zzpg2 != null ? this.zza.zza(zzpg2) : 0;
        if (zzpg4 != null) {
            j6 = this.zzc.zza(zzpg4);
        }
        this.zzd = zzpg3.zzc;
        if (j6 == -1) {
            return -1;
        }
        return zza2 + j6;
    }
}
