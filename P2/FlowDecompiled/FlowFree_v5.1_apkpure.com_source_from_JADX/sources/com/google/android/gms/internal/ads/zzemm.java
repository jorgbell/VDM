package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzemm extends zzeth<zzemm, zzeml> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzemm zzb;

    static {
        zzemm zzemm = new zzemm();
        zzb = zzemm;
        zzeth.zzay(zzemm.class, zzemm);
    }

    private zzemm() {
    }

    public static zzemm zza(zzesf zzesf, zzest zzest) throws zzett {
        return (zzemm) zzeth.zzaI(zzb, zzesf, zzest);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzb, "\u0000\u0000", (Object[]) null);
        }
        if (i2 == 3) {
            return new zzemm();
        }
        if (i2 == 4) {
            return new zzeml((zzemk) null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
