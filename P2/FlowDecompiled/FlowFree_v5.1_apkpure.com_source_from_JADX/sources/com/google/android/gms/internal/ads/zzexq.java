package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzexq extends zzeth<zzexq, zzexp> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzexq zzh;
    private int zzb;
    private String zze = "";
    private long zzf;
    private boolean zzg;

    static {
        zzexq zzexq = new zzexq();
        zzh = zzexq;
        zzeth.zzay(zzexq.class, zzexq);
    }

    private zzexq() {
    }

    public static zzexp zza() {
        return (zzexp) zzh.zzas();
    }

    static /* synthetic */ void zzd(zzexq zzexq, String str) {
        zzexq.zzb |= 1;
        zzexq.zze = str;
    }

    static /* synthetic */ void zze(zzexq zzexq, long j) {
        zzexq.zzb |= 2;
        zzexq.zzf = j;
    }

    static /* synthetic */ void zzf(zzexq zzexq, boolean z) {
        zzexq.zzb |= 4;
        zzexq.zzg = z;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzexq();
        } else {
            if (i2 == 4) {
                return new zzexp((zzewl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
