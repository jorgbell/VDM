package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxv extends zzeth<zzxv, zzxu> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxv zzi;
    private int zzb;
    private zzxk zze;
    private int zzf = 1000;
    private zzxt zzg;
    private zzxi zzh;

    static {
        zzxv zzxv = new zzxv();
        zzi = zzxv;
        zzeth.zzay(zzxv.class, zzxv);
    }

    private zzxv() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဌ\u0001\u0003ဉ\u0002\u0004ဉ\u0003", new Object[]{"zzb", "zze", "zzf", zzvy.zzc(), "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzxv();
        } else {
            if (i2 == 4) {
                return new zzxu((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
