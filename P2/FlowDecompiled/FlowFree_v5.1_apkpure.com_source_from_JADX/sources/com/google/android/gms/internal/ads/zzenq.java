package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzenq extends zzeth<zzenq, zzenp> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzenq zzg;
    private zzent zzb;
    private int zze;
    private int zzf;

    static {
        zzenq zzenq = new zzenq();
        zzg = zzenq;
        zzeth.zzay(zzenq.class, zzenq);
    }

    private zzenq() {
    }

    public static zzenq zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzenq) zzeth.zzaI(zzg, zzesf, zzest);
    }

    public static zzenq zze() {
        return zzg;
    }

    public final zzent zza() {
        zzent zzent = this.zzb;
        return zzent == null ? zzent.zzd() : zzent;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\u000b\u0003\u000b", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzenq();
        } else {
            if (i2 == 4) {
                return new zzenp((zzeno) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final int zzc() {
        return this.zze;
    }
}
