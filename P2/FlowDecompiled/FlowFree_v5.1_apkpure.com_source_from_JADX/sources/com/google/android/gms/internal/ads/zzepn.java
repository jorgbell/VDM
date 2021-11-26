package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzepn extends zzeth<zzepn, zzepm> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzepn zzb;

    static {
        zzepn zzepn = new zzepn();
        zzb = zzepn;
        zzeth.zzay(zzepn.class, zzepn);
    }

    private zzepn() {
    }

    public static zzepn zza(zzesf zzesf, zzest zzest) throws zzett {
        return (zzepn) zzeth.zzaI(zzb, zzesf, zzest);
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
            return new zzepn();
        }
        if (i2 == 4) {
            return new zzepm((zzepl) null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
