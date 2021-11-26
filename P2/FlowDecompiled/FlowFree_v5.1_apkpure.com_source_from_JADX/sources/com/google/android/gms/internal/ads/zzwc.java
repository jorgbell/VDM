package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzwc extends zzeth<zzwc, zzwb> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzwc zzi;
    private int zzb;
    private String zze = "";
    private int zzf;
    private zzetm zzg = zzeth.zzaB();
    private zzxi zzh;

    static {
        zzwc zzwc = new zzwc();
        zzi = zzwc;
        zzeth.zzay(zzwc.class, zzwc);
    }

    private zzwc() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003\u0016\u0004ဉ\u0002", new Object[]{"zzb", "zze", "zzf", zzvy.zzc(), "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzwc();
        } else {
            if (i2 == 4) {
                return new zzwb((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
