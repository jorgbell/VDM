package com.google.android.gms.internal.drive;

public abstract class zzjo {
    static zzjo zza(byte[] bArr, int i, int i2, boolean z) {
        zzjq zzjq = new zzjq(bArr, 0, i2, false);
        try {
            zzjq.zzv(i2);
            return zzjq;
        } catch (zzkq e) {
            throw new IllegalArgumentException(e);
        }
    }

    public abstract int zzbz();

    public abstract int zzv(int i) throws zzkq;

    private zzjo() {
    }
}
