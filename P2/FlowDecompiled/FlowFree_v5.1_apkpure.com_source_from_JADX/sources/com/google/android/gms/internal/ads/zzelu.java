package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzelu extends zzeth<zzelu, zzelt> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzelu zzf;
    private int zzb;
    private int zze;

    static {
        zzelu zzelu = new zzelu();
        zzf = zzelu;
        zzeth.zzay(zzelu.class, zzelu);
    }

    private zzelu() {
    }

    public static zzelu zzc(zzesf zzesf, zzest zzest) throws zzett {
        return (zzelu) zzeth.zzaI(zzf, zzesf, zzest);
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
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzelu();
        } else {
            if (i2 == 4) {
                return new zzelt((zzels) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
