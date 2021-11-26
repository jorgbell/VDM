package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeoq extends zzeth<zzeoq, zzeon> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeoq zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private zzetq<zzeop> zze = zzeth.zzaE();

    static {
        zzeoq zzeoq = new zzeoq();
        zzf = zzeoq;
        zzeth.zzay(zzeoq.class, zzeoq);
    }

    private zzeoq() {
    }

    public static zzeon zza() {
        return (zzeon) zzf.zzas();
    }

    static /* synthetic */ void zze(zzeoq zzeoq, zzeop zzeop) {
        zzeop.getClass();
        zzetq<zzeop> zzetq = zzeoq.zze;
        if (!zzetq.zza()) {
            zzeoq.zze = zzeth.zzaF(zzetq);
        }
        zzeoq.zze.add(zzeop);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzb", "zze", zzeop.class});
        } else if (i2 == 3) {
            return new zzeoq();
        } else {
            if (i2 == 4) {
                return new zzeon((zzeom) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
