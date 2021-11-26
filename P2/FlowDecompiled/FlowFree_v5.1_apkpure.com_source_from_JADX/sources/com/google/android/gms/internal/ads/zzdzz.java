package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdzz extends zzeth<zzdzz, zzdzv> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzdzz zzi;
    private int zzb;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzdzt zzh;

    static {
        zzdzz zzdzz = new zzdzz();
        zzi = zzdzz;
        zzeth.zzay(zzdzz.class, zzdzz);
    }

    private zzdzz() {
    }

    public static zzdzv zza() {
        return (zzdzv) zzi.zzas();
    }

    static /* synthetic */ void zzd(zzdzz zzdzz, zzdzy zzdzy) {
        zzdzz.zze = zzdzy.zza();
        zzdzz.zzb |= 1;
    }

    static /* synthetic */ void zze(zzdzz zzdzz, String str) {
        str.getClass();
        zzdzz.zzb |= 2;
        zzdzz.zzf = str;
    }

    static /* synthetic */ void zzf(zzdzz zzdzz, zzdzt zzdzt) {
        zzdzt.getClass();
        zzdzz.zzh = zzdzt;
        zzdzz.zzb |= 8;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzb", "zze", zzdzy.zzc(), "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzdzz();
        } else {
            if (i2 == 4) {
                return new zzdzv((zzdzu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
