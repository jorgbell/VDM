package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekz extends zzeth<zzekz, zzeky> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzekz zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzelf zze;
    /* access modifiers changed from: private */
    public zzesf zzf = zzesf.zzb;

    static {
        zzekz zzekz = new zzekz();
        zzg = zzekz;
        zzeth.zzay(zzekz.class, zzekz);
    }

    private zzekz() {
    }

    public static zzekz zze(zzesf zzesf, zzest zzest) throws zzett {
        return (zzekz) zzeth.zzaI(zzg, zzesf, zzest);
    }

    public static zzeky zzf() {
        return (zzeky) zzg.zzas();
    }

    public static zzekz zzg() {
        return zzg;
    }

    static /* synthetic */ void zzj(zzekz zzekz, zzelf zzelf) {
        zzelf.getClass();
        zzekz.zze = zzelf;
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
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzekz();
        } else {
            if (i2 == 4) {
                return new zzeky((zzekx) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzelf zzc() {
        zzelf zzelf = this.zze;
        return zzelf == null ? zzelf.zzc() : zzelf;
    }

    public final zzesf zzd() {
        return this.zzf;
    }
}
