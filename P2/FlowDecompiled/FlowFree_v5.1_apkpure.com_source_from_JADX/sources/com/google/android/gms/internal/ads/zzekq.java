package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekq extends zzeth<zzekq, zzekp> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzekq zze;
    private int zzb;

    static {
        zzekq zzekq = new zzekq();
        zze = zzekq;
        zzeth.zzay(zzekq.class, zzekq);
    }

    private zzekq() {
    }

    public static zzekq zzc() {
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
            return new zzekq();
        } else {
            if (i2 == 4) {
                return new zzekp((zzeko) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
