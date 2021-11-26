package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzyb extends zzeth<zzyb, zzya> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzyb zzk;
    private int zzb;
    private int zze = 1000;
    private zzxt zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private long zzj;

    static {
        zzyb zzyb = new zzyb();
        zzk = zzyb;
        zzeth.zzay(zzyb.class, zzyb);
    }

    private zzyb() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004\u0006ဃ\u0005", new Object[]{"zzb", "zze", zzvy.zzc(), "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzyb();
        } else {
            if (i2 == 4) {
                return new zzya((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
