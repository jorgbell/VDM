package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzwg extends zzeth<zzwg, zzwf> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzwg zzi;
    private int zzb;
    private zzwc zze;
    private zzetq<zzxg> zzf = zzeth.zzaE();
    private int zzg;
    private zzxi zzh;

    static {
        zzwg zzwg = new zzwg();
        zzi = zzwg;
        zzeth.zzay(zzwg.class, zzwg);
    }

    private zzwg() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b\u0003ဌ\u0001\u0004ဉ\u0002", new Object[]{"zzb", "zze", "zzf", zzxg.class, "zzg", zzvy.zzc(), "zzh"});
        } else if (i2 == 3) {
            return new zzwg();
        } else {
            if (i2 == 4) {
                return new zzwf((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
