package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvc extends zzeth<zzvc, zzvb> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzvc zzh;
    private int zzb;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        zzvc zzvc = new zzvc();
        zzh = zzvc;
        zzeth.zzay(zzvc.class, zzvc);
    }

    private zzvc() {
    }

    public static zzvb zza() {
        return (zzvb) zzh.zzas();
    }

    static /* synthetic */ void zzd(zzvc zzvc, boolean z) {
        zzvc.zzb |= 1;
        zzvc.zze = z;
    }

    static /* synthetic */ void zze(zzvc zzvc, boolean z) {
        zzvc.zzb |= 2;
        zzvc.zzf = z;
    }

    static /* synthetic */ void zzf(zzvc zzvc, int i) {
        zzvc.zzb |= 4;
        zzvc.zzg = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဋ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzvc();
        } else {
            if (i2 == 4) {
                return new zzvb((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
