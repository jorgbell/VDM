package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzell extends zzeth<zzell, zzelk> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzell zzf;
    private zzelo zzb;
    private int zze;

    static {
        zzell zzell = new zzell();
        zzf = zzell;
        zzeth.zzay(zzell.class, zzell);
    }

    private zzell() {
    }

    public static zzell zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzell) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public final zzelo zza() {
        zzelo zzelo = this.zzb;
        return zzelo == null ? zzelo.zzc() : zzelo;
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
            return new zzell();
        } else {
            if (i2 == 4) {
                return new zzelk((zzelj) null);
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
