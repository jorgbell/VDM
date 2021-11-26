package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzwq extends zzeth<zzwq, zzwp> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzwq zzg;
    private int zzb;
    private int zze;
    private zzxi zzf;

    static {
        zzwq zzwq = new zzwq();
        zzg = zzwq;
        zzeth.zzay(zzwq.class, zzwq);
    }

    private zzwq() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", zzvy.zzc(), "zzf"});
        } else if (i2 == 3) {
            return new zzwq();
        } else {
            if (i2 == 4) {
                return new zzwp((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
