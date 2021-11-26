package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxe extends zzeth<zzxe, zzxd> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxe zzg;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzxe zzxe = new zzxe();
        zzg = zzxe;
        zzeth.zzay(zzxe.class, zzxe);
    }

    private zzxe() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzxe();
        } else {
            if (i2 == 4) {
                return new zzxd((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
