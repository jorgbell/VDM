package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzenn extends zzeth<zzenn, zzenm> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzenn zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzent zze;
    /* access modifiers changed from: private */
    public zzesf zzf = zzesf.zzb;

    static {
        zzenn zzenn = new zzenn();
        zzg = zzenn;
        zzeth.zzay(zzenn.class, zzenn);
    }

    private zzenn() {
    }

    public static zzenn zze(zzesf zzesf, zzest zzest) throws zzett {
        return (zzenn) zzeth.zzaI(zzg, zzesf, zzest);
    }

    public static zzenm zzf() {
        return (zzenm) zzg.zzas();
    }

    public static zzenn zzg() {
        return zzg;
    }

    static /* synthetic */ void zzj(zzenn zzenn, zzent zzent) {
        zzent.getClass();
        zzenn.zze = zzent;
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
            return new zzenn();
        } else {
            if (i2 == 4) {
                return new zzenm((zzenl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzent zzc() {
        zzent zzent = this.zze;
        return zzent == null ? zzent.zzd() : zzent;
    }

    public final zzesf zzd() {
        return this.zzf;
    }
}
