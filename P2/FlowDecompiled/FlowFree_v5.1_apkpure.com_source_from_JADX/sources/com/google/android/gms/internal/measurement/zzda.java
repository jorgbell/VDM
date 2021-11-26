package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzda extends zzhr<zzda, zzcz> implements zzix {
    /* access modifiers changed from: private */
    public static final zzda zzg;
    private int zza;
    private int zze;
    private long zzf;

    static {
        zzda zzda = new zzda();
        zzg = zzda;
        zzhr.zzby(zzda.class, zzda);
    }

    private zzda() {
    }

    public static zzcz zze() {
        return (zzcz) zzg.zzbt();
    }

    static /* synthetic */ void zzg(zzda zzda, int i) {
        zzda.zza |= 1;
        zzda.zze = i;
    }

    static /* synthetic */ void zzh(zzda zzda, long j) {
        zzda.zza |= 2;
        zzda.zzf = j;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final long zzd() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzda();
        } else {
            if (i2 == 4) {
                return new zzcz((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
