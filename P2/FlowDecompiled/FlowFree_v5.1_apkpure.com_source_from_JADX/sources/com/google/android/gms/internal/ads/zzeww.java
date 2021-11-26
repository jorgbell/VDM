package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeww extends zzeth<zzeww, zzewv> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeww zzh;
    private int zzb;
    private zzesf zze;
    private zzesf zzf;
    private zzesf zzg;

    static {
        zzeww zzeww = new zzeww();
        zzh = zzeww;
        zzeth.zzay(zzeww.class, zzeww);
    }

    private zzeww() {
        zzesf zzesf = zzesf.zzb;
        this.zze = zzesf;
        this.zzf = zzesf;
        this.zzg = zzesf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzeww();
        } else {
            if (i2 == 4) {
                return new zzewv((zzewl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
