package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdt extends zzeth<zzdt, zzds> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzdt zzf;
    private int zzb;
    private String zze = "";

    static {
        zzdt zzdt = new zzdt();
        zzf = zzdt;
        zzeth.zzay(zzdt.class, zzdt);
    }

    private zzdt() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzdt();
        } else {
            if (i2 == 4) {
                return new zzds((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
