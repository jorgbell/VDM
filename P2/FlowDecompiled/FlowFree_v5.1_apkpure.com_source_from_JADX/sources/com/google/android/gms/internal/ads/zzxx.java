package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxx extends zzeth<zzxx, zzxw> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxx zzj;
    private int zzb;
    private int zze = 1000;
    private zzxt zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzxx zzxx = new zzxx();
        zzj = zzxx;
        zzeth.zzay(zzxx.class, zzxx);
    }

    private zzxx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzb", "zze", zzvy.zzc(), "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzxx();
        } else {
            if (i2 == 4) {
                return new zzxw((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
