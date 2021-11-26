package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzde extends zzeth<zzde, zzdd> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzde zzj;
    private int zzb;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzetm zzh = zzeth.zzaB();
    private long zzi;

    static {
        zzde zzde = new zzde();
        zzj = zzde;
        zzeth.zzay(zzde.class, zzde);
    }

    private zzde() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001ဂ\u0000\u0002င\u0001\u0003ဇ\u0002\u0004\u0016\u0005ဃ\u0003", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzde();
        } else {
            if (i2 == 4) {
                return new zzdd((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
