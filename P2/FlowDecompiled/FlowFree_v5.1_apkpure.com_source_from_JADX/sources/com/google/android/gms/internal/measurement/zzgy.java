package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-measurement-base@@18.0.3 */
public abstract class zzgy extends zzgi {
    private static final Logger zzb = Logger.getLogger(zzgy.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzkf.zza();
    zzgz zza;

    private zzgy() {
    }

    /* synthetic */ zzgy(zzgv zzgv) {
    }

    public static int zzA(zzgr zzgr) {
        int zzc2 = zzgr.zzc();
        return zzw(zzc2) + zzc2;
    }

    static int zzB(zziw zziw, zzjh zzjh) {
        zzgc zzgc = (zzgc) zziw;
        int zzbq = zzgc.zzbq();
        if (zzbq == -1) {
            zzbq = zzjh.zze(zzgc);
            zzgc.zzbr(zzbq);
        }
        return zzw(zzbq) + zzbq;
    }

    @Deprecated
    static int zzE(int i, zziw zziw, zzjh zzjh) {
        int zzw = zzw(i << 3);
        int i2 = zzw + zzw;
        zzgc zzgc = (zzgc) zziw;
        int zzbq = zzgc.zzbq();
        if (zzbq == -1) {
            zzbq = zzjh.zze(zzgc);
            zzgc.zzbr(zzbq);
        }
        return i2 + zzbq;
    }

    public static zzgy zzt(byte[] bArr) {
        return new zzgw(bArr, 0, bArr.length);
    }

    public static int zzu(int i) {
        return zzw(i << 3);
    }

    public static int zzv(int i) {
        if (i >= 0) {
            return zzw(i);
        }
        return 10;
    }

    public static int zzw(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzx(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            j >>>= 28;
            i = 6;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzy(String str) {
        int i;
        try {
            i = zzkk.zzc(str);
        } catch (zzkj unused) {
            i = str.getBytes(zzhz.zza).length;
        }
        return zzw(i) + i;
    }

    public static int zzz(zzie zzie) {
        int zza2 = zzie.zza();
        return zzw(zza2) + zza2;
    }

    public final void zzC() {
        if (zzs() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(String str, zzkj zzkj) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzkj);
        byte[] bytes = str.getBytes(zzhz.zza);
        try {
            int length = bytes.length;
            zzl(length);
            zzq(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzgx(e);
        } catch (zzgx e2) {
            throw e2;
        }
    }

    public abstract void zza(int i, int i2) throws IOException;

    public abstract void zzb(int i, int i2) throws IOException;

    public abstract void zzc(int i, int i2) throws IOException;

    public abstract void zzd(int i, int i2) throws IOException;

    public abstract void zze(int i, long j) throws IOException;

    public abstract void zzf(int i, long j) throws IOException;

    public abstract void zzg(int i, boolean z) throws IOException;

    public abstract void zzh(int i, String str) throws IOException;

    public abstract void zzi(int i, zzgr zzgr) throws IOException;

    public abstract void zzj(byte b) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(int i) throws IOException;

    public abstract void zzm(int i) throws IOException;

    public abstract void zzn(long j) throws IOException;

    public abstract void zzo(long j) throws IOException;

    public abstract void zzq(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzs();
}
