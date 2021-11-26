package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public abstract class zzeso extends zzerv {
    private static final Logger zzb = Logger.getLogger(zzeso.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zzc = zzewd.zza();
    zzesp zza;

    private zzeso() {
    }

    /* synthetic */ zzeso(zzesl zzesl) {
    }

    public static int zzA(zzesf zzesf) {
        int zzc2 = zzesf.zzc();
        return zzw(zzc2) + zzc2;
    }

    static int zzB(zzeuo zzeuo, zzevf zzevf) {
        zzerp zzerp = (zzerp) zzeuo;
        int zzap = zzerp.zzap();
        if (zzap == -1) {
            zzap = zzevf.zze(zzerp);
            zzerp.zzaq(zzap);
        }
        return zzw(zzap) + zzap;
    }

    @Deprecated
    static int zzE(int i, zzeuo zzeuo, zzevf zzevf) {
        int zzw = zzw(i << 3);
        int i2 = zzw + zzw;
        zzerp zzerp = (zzerp) zzeuo;
        int zzap = zzerp.zzap();
        if (zzap == -1) {
            zzap = zzevf.zze(zzerp);
            zzerp.zzaq(zzap);
        }
        return i2 + zzap;
    }

    public static zzeso zzt(byte[] bArr) {
        return new zzesm(bArr, 0, bArr.length);
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
            i = zzewi.zzd(str);
        } catch (zzewh unused) {
            i = str.getBytes(zzetr.zza).length;
        }
        return zzw(i) + i;
    }

    public static int zzz(zzetw zzetw) {
        int zza2 = zzetw.zza();
        return zzw(zza2) + zza2;
    }

    public final void zzC() {
        if (zzs() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzD(String str, zzewh zzewh) throws IOException {
        zzb.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", zzewh);
        byte[] bytes = str.getBytes(zzetr.zza);
        try {
            int length = bytes.length;
            zzl(length);
            zzq(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new zzesn(e);
        } catch (zzesn e2) {
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

    public abstract void zzi(int i, zzesf zzesf) throws IOException;

    public abstract void zzj(byte b) throws IOException;

    public abstract void zzk(int i) throws IOException;

    public abstract void zzl(int i) throws IOException;

    public abstract void zzm(int i) throws IOException;

    public abstract void zzn(long j) throws IOException;

    public abstract void zzo(long j) throws IOException;

    public abstract void zzq(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzs();
}
