package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzemu extends zzeth<zzemu, zzemt> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzemu zze;
    private zzemx zzb;

    static {
        zzemu zzemu = new zzemu();
        zze = zzemu;
        zzeth.zzay(zzemu.class, zzemu);
    }

    private zzemu() {
    }

    public static zzemu zzc(zzesf zzesf, zzest zzest) throws zzett {
        return (zzemu) zzeth.zzaI(zze, zzesf, zzest);
    }

    public final zzemx zza() {
        zzemx zzemx = this.zzb;
        return zzemx == null ? zzemx.zze() : zzemx;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzemu();
        } else {
            if (i2 == 4) {
                return new zzemt((zzems) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
