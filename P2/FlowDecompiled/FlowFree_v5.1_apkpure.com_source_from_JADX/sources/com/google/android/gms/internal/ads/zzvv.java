package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvv extends zzeth<zzvv, zzvr> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzvv zzi;
    private int zzb;
    private int zze;
    private zzxk zzf;
    private String zzg = "";
    private String zzh = "";

    static {
        zzvv zzvv = new zzvv();
        zzi = zzvv;
        zzeth.zzay(zzvv.class, zzvv);
    }

    private zzvv() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0005\b\u0004\u0000\u0000\u0000\u0005ဌ\u0000\u0006ဉ\u0001\u0007ဈ\u0002\bဈ\u0003", new Object[]{"zzb", "zze", zzvu.zzb(), "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzvv();
        } else {
            if (i2 == 4) {
                return new zzvr((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
