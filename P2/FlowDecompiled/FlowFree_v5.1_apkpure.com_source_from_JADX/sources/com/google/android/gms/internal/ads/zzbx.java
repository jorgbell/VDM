package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbx extends zzeth<zzbx, zzbw> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzbx zzg;
    private int zzb;
    private String zze = "";
    private String zzf = "";

    static {
        zzbx zzbx = new zzbx();
        zzg = zzbx;
        zzeth.zzay(zzbx.class, zzbx);
    }

    private zzbx() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzbx();
        } else {
            if (i2 == 4) {
                return new zzbw((zzbu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
