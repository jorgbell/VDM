package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzde extends zzhr<zzde, zzdd> implements zzix {
    /* access modifiers changed from: private */
    public static final zzde zzg;
    private int zza;
    private String zze = "";
    private long zzf;

    static {
        zzde zzde = new zzde();
        zzg = zzde;
        zzhr.zzby(zzde.class, zzde);
    }

    private zzde() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zza", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzde();
        } else {
            if (i2 == 4) {
                return new zzdd((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
