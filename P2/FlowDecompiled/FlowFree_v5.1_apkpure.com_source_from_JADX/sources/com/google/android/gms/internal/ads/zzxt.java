package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxt extends zzeth<zzxt, zzxp> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxt zzf;
    private int zzb;
    private int zze;

    static {
        zzxt zzxt = new zzxt();
        zzf = zzxt;
        zzeth.zzay(zzxt.class, zzxt);
    }

    private zzxt() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzb", "zze", zzxs.zzb()});
        } else if (i2 == 3) {
            return new zzxt();
        } else {
            if (i2 == 4) {
                return new zzxp((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
