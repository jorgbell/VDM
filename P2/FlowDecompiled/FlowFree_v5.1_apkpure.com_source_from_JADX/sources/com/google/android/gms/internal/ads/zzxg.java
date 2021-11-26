package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxg extends zzeth<zzxg, zzxf> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxg zzh;
    private int zzb;
    private String zze = "";
    private int zzf;
    private zzxi zzg;

    static {
        zzxg zzxg = new zzxg();
        zzh = zzxg;
        zzeth.zzay(zzxg.class, zzxg);
    }

    private zzxg() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zze", "zzf", zzvy.zzc(), "zzg"});
        } else if (i2 == 3) {
            return new zzxg();
        } else {
            if (i2 == 4) {
                return new zzxf((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
