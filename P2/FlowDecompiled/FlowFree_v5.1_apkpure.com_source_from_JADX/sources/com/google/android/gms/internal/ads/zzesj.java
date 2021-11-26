package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzesj {
    int zza;
    zzesk zzb;

    /* synthetic */ zzesj(zzesg zzesg) {
    }

    static zzesj zzF(byte[] bArr, int i, int i2, boolean z) {
        zzesh zzesh = new zzesh(bArr, i, i2, z, (zzesg) null);
        try {
            zzesh.zzz(i2);
            return zzesh;
        } catch (zzett e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static int zzG(int i) {
        return (-(i & 1)) ^ (i >>> 1);
    }

    public static long zzH(long j) {
        return (-(j & 1)) ^ (j >>> 1);
    }

    public abstract void zzA(int i);

    public abstract boolean zzB() throws IOException;

    public abstract int zzC();

    public abstract int zza() throws IOException;

    public abstract void zzb(int i) throws zzett;

    public abstract boolean zzc(int i) throws IOException;

    public abstract double zzd() throws IOException;

    public abstract float zze() throws IOException;

    public abstract long zzf() throws IOException;

    public abstract long zzg() throws IOException;

    public abstract int zzh() throws IOException;

    public abstract long zzi() throws IOException;

    public abstract int zzj() throws IOException;

    public abstract boolean zzk() throws IOException;

    public abstract String zzl() throws IOException;

    public abstract String zzm() throws IOException;

    public abstract zzesf zzn() throws IOException;

    public abstract int zzo() throws IOException;

    public abstract int zzp() throws IOException;

    public abstract int zzq() throws IOException;

    public abstract long zzr() throws IOException;

    public abstract int zzs() throws IOException;

    public abstract long zzt() throws IOException;

    public abstract int zzz(int i) throws zzett;
}
