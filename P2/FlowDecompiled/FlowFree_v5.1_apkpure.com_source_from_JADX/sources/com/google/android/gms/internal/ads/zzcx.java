package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcx extends zzeth<zzcx, zzcw> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzcx zzg;
    private int zzb;
    private int zze;
    private long zzf = -1;

    static {
        zzcx zzcx = new zzcx();
        zzg = zzcx;
        zzeth.zzay(zzcx.class, zzcx);
    }

    private zzcx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zze", zzct.zzc(), "zzf"});
        } else if (i2 == 3) {
            return new zzcx();
        } else {
            if (i2 == 4) {
                return new zzcw((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
