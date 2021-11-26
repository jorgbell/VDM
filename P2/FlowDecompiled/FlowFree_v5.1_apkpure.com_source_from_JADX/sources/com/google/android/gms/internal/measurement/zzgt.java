package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
final class zzgt extends zzgu {
    private int zzb = 0;
    private int zzc;
    private int zzd = Integer.MAX_VALUE;

    /* synthetic */ zzgt(byte[] bArr, int i, int i2, boolean z, zzgs zzgs) {
        super((zzgs) null);
    }

    public final int zza(int i) throws zzib {
        int i2 = this.zzd;
        this.zzd = 0;
        int i3 = this.zzb + this.zzc;
        this.zzb = i3;
        if (i3 > 0) {
            this.zzc = i3;
            this.zzb = 0;
        } else {
            this.zzc = 0;
        }
        return i2;
    }
}
