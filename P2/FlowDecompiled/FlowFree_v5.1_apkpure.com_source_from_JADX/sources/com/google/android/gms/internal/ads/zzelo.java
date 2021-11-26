package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzelo extends zzeth<zzelo, zzeln> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzelo zze;
    private int zzb;

    static {
        zzelo zzelo = new zzelo();
        zze = zzelo;
        zzeth.zzay(zzelo.class, zzelo);
    }

    private zzelo() {
    }

    public static zzelo zzc() {
        return zze;
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
            return zzeth.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzelo();
        } else {
            if (i2 == 4) {
                return new zzeln((zzelm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
