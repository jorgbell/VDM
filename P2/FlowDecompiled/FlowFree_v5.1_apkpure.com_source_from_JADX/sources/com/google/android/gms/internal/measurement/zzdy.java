package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdy extends zzhr<zzdy, zzdx> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdy zze;
    private zzhy<zzea> zza = zzhr.zzbE();

    static {
        zzdy zzdy = new zzdy();
        zze = zzdy;
        zzhr.zzby(zzdy.class, zzdy);
    }

    private zzdy() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzea.class});
        } else if (i2 == 3) {
            return new zzdy();
        } else {
            if (i2 == 4) {
                return new zzdx((zzdw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
