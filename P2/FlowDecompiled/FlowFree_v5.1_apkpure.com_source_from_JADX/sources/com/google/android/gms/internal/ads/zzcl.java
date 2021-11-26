package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcl extends zzeth<zzcl, zzck> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzcl zzk;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        zzcl zzcl = new zzcl();
        zzk = zzcl;
        zzeth.zzay(zzcl.class, zzcl);
    }

    private zzcl() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzcl();
        } else {
            if (i2 == 4) {
                return new zzck((zzcc) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
