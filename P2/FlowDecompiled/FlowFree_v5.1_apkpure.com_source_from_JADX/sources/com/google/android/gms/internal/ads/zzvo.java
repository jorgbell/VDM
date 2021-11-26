package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvo extends zzeth<zzvo, zzvn> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzvo zzk;
    private int zzb;
    private int zze;
    private zzxi zzf;
    private zzxi zzg;
    private zzxi zzh;
    private zzetq<zzxi> zzi = zzeth.zzaE();
    private int zzj;

    static {
        zzvo zzvo = new zzvo();
        zzk = zzvo;
        zzeth.zzay(zzvo.class, zzvo);
    }

    private zzvo() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005\u001b\u0006င\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", zzxi.class, "zzj"});
        } else if (i2 == 3) {
            return new zzvo();
        } else {
            if (i2 == 4) {
                return new zzvn((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
