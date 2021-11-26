package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxo extends zzeth<zzxo, zzxn> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxo zzh;
    private int zzb;
    private int zze = 1000;
    private zzxt zzf;
    private zzxi zzg;

    static {
        zzxo zzxo = new zzxo();
        zzh = zzxo;
        zzeth.zzay(zzxo.class, zzxo);
    }

    private zzxo() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zze", zzvy.zzc(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzxo();
        } else {
            if (i2 == 4) {
                return new zzxn((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
