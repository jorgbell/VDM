package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeng extends zzeth<zzeng, zzenf> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeng zzg;
    private int zzb;
    private int zze;
    private zzesf zzf = zzesf.zzb;

    static {
        zzeng zzeng = new zzeng();
        zzg = zzeng;
        zzeth.zzay(zzeng.class, zzeng);
    }

    private zzeng() {
    }

    public static zzeng zze() {
        return zzg;
    }

    public final zzeni zza() {
        zzeni zza = zzeni.zza(this.zzb);
        return zza == null ? zzeni.UNRECOGNIZED : zza;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzeng();
        } else {
            if (i2 == 4) {
                return new zzenf((zzene) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzenk zzc() {
        zzenk zza = zzenk.zza(this.zze);
        return zza == null ? zzenk.UNRECOGNIZED : zza;
    }

    public final zzesf zzd() {
        return this.zzf;
    }
}
