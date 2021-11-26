package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzexg extends zzeth<zzexg, zzexc> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzexg zzh;
    private int zzb;
    private int zze;
    private String zzf = "";
    private zzesf zzg = zzesf.zzb;

    static {
        zzexg zzexg = new zzexg();
        zzh = zzexg;
        zzeth.zzay(zzexg.class, zzexg);
    }

    private zzexg() {
    }

    public static zzexc zza() {
        return (zzexc) zzh.zzas();
    }

    static /* synthetic */ void zzd(zzexg zzexg, zzexf zzexf) {
        zzexg.zze = zzexf.zza();
        zzexg.zzb |= 1;
    }

    static /* synthetic */ void zze(zzexg zzexg, String str) {
        zzexg.zzb |= 2;
        zzexg.zzf = "image/png";
    }

    static /* synthetic */ void zzf(zzexg zzexg, zzesf zzesf) {
        zzesf.getClass();
        zzexg.zzb |= 4;
        zzexg.zzg = zzesf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzb", "zze", zzexf.zzc(), "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzexg();
        } else {
            if (i2 == 4) {
                return new zzexc((zzewl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
