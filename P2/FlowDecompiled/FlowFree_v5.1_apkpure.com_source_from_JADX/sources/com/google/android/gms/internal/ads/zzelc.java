package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzelc extends zzeth<zzelc, zzelb> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzelc zzf;
    private zzelf zzb;
    private int zze;

    static {
        zzelc zzelc = new zzelc();
        zzf = zzelc;
        zzeth.zzay(zzelc.class, zzelc);
    }

    private zzelc() {
    }

    public static zzelc zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzelc) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public static zzelc zze() {
        return zzf;
    }

    public final zzelf zza() {
        zzelf zzelf = this.zzb;
        return zzelf == null ? zzelf.zzc() : zzelf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzelc();
        } else {
            if (i2 == 4) {
                return new zzelb((zzela) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final int zzc() {
        return this.zze;
    }
}
