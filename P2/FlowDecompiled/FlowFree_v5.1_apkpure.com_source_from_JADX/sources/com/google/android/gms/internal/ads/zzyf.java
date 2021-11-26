package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzyf extends zzeth<zzyf, zzye> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzyf zzg;
    private int zzb;
    private int zze = 1000;
    private zzxt zzf;

    static {
        zzyf zzyf = new zzyf();
        zzg = zzyf;
        zzeth.zzay(zzyf.class, zzyf);
    }

    private zzyf() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001", new Object[]{"zzb", "zze", zzvy.zzc(), "zzf"});
        } else if (i2 == 3) {
            return new zzyf();
        } else {
            if (i2 == 4) {
                return new zzye((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
