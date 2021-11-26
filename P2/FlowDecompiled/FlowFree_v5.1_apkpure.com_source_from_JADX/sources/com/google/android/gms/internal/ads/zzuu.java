package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzuu extends zzeth<zzuu, zzut> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzuu zzh;
    private int zzb;
    private int zze;
    private zzva zzf;
    private zzvc zzg;

    static {
        zzuu zzuu = new zzuu();
        zzh = zzuu;
        zzeth.zzay(zzuu.class, zzuu);
    }

    private zzuu() {
    }

    public static zzut zza() {
        return (zzut) zzh.zzas();
    }

    static /* synthetic */ void zzd(zzuu zzuu, zzuy zzuy) {
        zzuu.zze = zzuy.zza();
        zzuu.zzb |= 1;
    }

    static /* synthetic */ void zze(zzuu zzuu, zzva zzva) {
        zzva.getClass();
        zzuu.zzf = zzva;
        zzuu.zzb |= 2;
    }

    static /* synthetic */ void zzf(zzuu zzuu, zzvc zzvc) {
        zzvc.getClass();
        zzuu.zzg = zzvc;
        zzuu.zzb |= 4;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzb", "zze", zzuy.zzc(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzuu();
        } else {
            if (i2 == 4) {
                return new zzut((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
