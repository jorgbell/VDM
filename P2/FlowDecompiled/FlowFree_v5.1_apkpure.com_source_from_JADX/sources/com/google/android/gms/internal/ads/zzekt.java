package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekt extends zzeth<zzekt, zzeks> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzekt zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzekz zze;
    private zzenn zzf;

    static {
        zzekt zzekt = new zzekt();
        zzg = zzekt;
        zzeth.zzay(zzekt.class, zzekt);
    }

    private zzekt() {
    }

    public static zzekt zze(zzesf zzesf, zzest zzest) throws zzett {
        return (zzekt) zzeth.zzaI(zzg, zzesf, zzest);
    }

    public static zzeks zzf() {
        return (zzeks) zzg.zzas();
    }

    static /* synthetic */ void zzi(zzekt zzekt, zzekz zzekz) {
        zzekz.getClass();
        zzekt.zze = zzekz;
    }

    static /* synthetic */ void zzj(zzekt zzekt, zzenn zzenn) {
        zzenn.getClass();
        zzekt.zzf = zzenn;
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzekt();
        } else {
            if (i2 == 4) {
                return new zzeks((zzekr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzekz zzc() {
        zzekz zzekz = this.zze;
        return zzekz == null ? zzekz.zzg() : zzekz;
    }

    public final zzenn zzd() {
        zzenn zzenn = this.zzf;
        return zzenn == null ? zzenn.zzg() : zzenn;
    }
}
