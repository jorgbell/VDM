package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzexa extends zzeth<zzexa, zzewz> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzexa zzh;
    private int zzb;
    private int zze;
    private zzesf zzf;
    private zzesf zzg;

    static {
        zzexa zzexa = new zzexa();
        zzh = zzexa;
        zzeth.zzay(zzexa.class, zzexa);
    }

    private zzexa() {
        zzesf zzesf = zzesf.zzb;
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
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzexa();
        } else {
            if (i2 == 4) {
                return new zzewz((zzewl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
