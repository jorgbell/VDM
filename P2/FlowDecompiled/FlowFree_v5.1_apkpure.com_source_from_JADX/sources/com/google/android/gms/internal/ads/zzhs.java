package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhs extends zzeth<zzhs, zzhr> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzhs zzh;
    private int zzb;
    private zzhv zze;
    private zzesf zzf;
    private zzesf zzg;

    static {
        zzhs zzhs = new zzhs();
        zzh = zzhs;
        zzeth.zzay(zzhs.class, zzhs);
    }

    private zzhs() {
        zzesf zzesf = zzesf.zzb;
        this.zzf = zzesf;
        this.zzg = zzesf;
    }

    public static zzhs zze(zzesf zzesf, zzest zzest) throws zzett {
        return (zzhs) zzeth.zzaI(zzh, zzesf, zzest);
    }

    public final zzhv zza() {
        zzhv zzhv = this.zze;
        return zzhv == null ? zzhv.zzj() : zzhv;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzhs();
        } else {
            if (i2 == 4) {
                return new zzhr((zzhq) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final zzesf zzc() {
        return this.zzf;
    }

    public final zzesf zzd() {
        return this.zzg;
    }
}
