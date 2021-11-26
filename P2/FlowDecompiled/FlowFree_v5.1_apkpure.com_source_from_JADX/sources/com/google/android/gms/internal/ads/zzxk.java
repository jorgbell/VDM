package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzxk extends zzeth<zzxk, zzxj> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzxk zzh;
    private int zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzxk zzxk = new zzxk();
        zzh = zzxk;
        zzeth.zzay(zzxk.class, zzxk);
    }

    private zzxk() {
    }

    public static zzxj zza() {
        return (zzxj) zzh.zzas();
    }

    static /* synthetic */ void zzd(zzxk zzxk, int i) {
        zzxk.zzb |= 1;
        zzxk.zze = i;
    }

    static /* synthetic */ void zze(zzxk zzxk, int i) {
        zzxk.zzb |= 2;
        zzxk.zzf = i;
    }

    static /* synthetic */ void zzf(zzxk zzxk, int i) {
        zzxk.zzb |= 4;
        zzxk.zzg = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzxk();
        } else {
            if (i2 == 4) {
                return new zzxj((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
