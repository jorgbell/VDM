package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzce extends zzeth<zzce, zzcd> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzce zzg;
    private int zzb;
    private zzcg zze;
    private zzcl zzf;

    static {
        zzce zzce = new zzce();
        zzg = zzce;
        zzeth.zzay(zzce.class, zzce);
    }

    private zzce() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzce();
        } else {
            if (i2 == 4) {
                return new zzcd((zzcc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
