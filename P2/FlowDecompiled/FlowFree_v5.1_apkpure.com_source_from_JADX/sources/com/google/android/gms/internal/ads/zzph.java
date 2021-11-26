package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzph {
    private final zzpb[] zza = new zzpb[1];
    private int zzb;
    private int zzc;
    private int zzd = 0;
    private zzpb[] zze = new zzpb[100];

    public zzph(boolean z, int i) {
    }

    public final synchronized void zza() {
        zzb(0);
    }

    public final synchronized void zzb(int i) {
        int i2 = this.zzb;
        this.zzb = i;
        if (i < i2) {
            zzf();
        }
    }

    public final synchronized zzpb zzc() {
        zzpb zzpb;
        this.zzc++;
        int i = this.zzd;
        if (i > 0) {
            zzpb[] zzpbArr = this.zze;
            int i2 = i - 1;
            this.zzd = i2;
            zzpb = zzpbArr[i2];
            zzpbArr[i2] = null;
        } else {
            zzpb = new zzpb(new byte[65536], 0);
        }
        return zzpb;
    }

    public final synchronized void zzd(zzpb zzpb) {
        zzpb[] zzpbArr = this.zza;
        zzpbArr[0] = zzpb;
        zze(zzpbArr);
    }

    public final synchronized void zze(zzpb[] zzpbArr) {
        int i = this.zzd + r0;
        zzpb[] zzpbArr2 = this.zze;
        int length = zzpbArr2.length;
        if (i >= length) {
            this.zze = (zzpb[]) Arrays.copyOf(zzpbArr2, Math.max(length + length, i));
        }
        for (zzpb zzpb : zzpbArr) {
            zzpu.zza(zzpb.zza.length == 65536);
            zzpb[] zzpbArr3 = this.zze;
            int i2 = this.zzd;
            this.zzd = i2 + 1;
            zzpbArr3[i2] = zzpb;
        }
        this.zzc -= zzpbArr.length;
        notifyAll();
    }

    public final synchronized void zzf() {
        int max = Math.max(0, zzqj.zze(this.zzb, 65536) - this.zzc);
        int i = this.zzd;
        if (max < i) {
            Arrays.fill(this.zze, max, i, (Object) null);
            this.zzd = max;
        }
    }

    public final synchronized int zzg() {
        return this.zzc * 65536;
    }
}
