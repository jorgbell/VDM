package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekn extends zzeth<zzekn, zzekm> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzekn zzf;
    private int zzb;
    private zzekq zze;

    static {
        zzekn zzekn = new zzekn();
        zzf = zzekn;
        zzeth.zzay(zzekn.class, zzekn);
    }

    private zzekn() {
    }

    public static zzekn zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzekn) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzekn();
        } else {
            if (i2 == 4) {
                return new zzekm((zzekl) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzekq zzc() {
        zzekq zzekq = this.zze;
        return zzekq == null ? zzekq.zzc() : zzekq;
    }
}
