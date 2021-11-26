package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekw extends zzeth<zzekw, zzekv> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzekw zzf;
    private zzelc zzb;
    private zzenq zze;

    static {
        zzekw zzekw = new zzekw();
        zzf = zzekw;
        zzeth.zzay(zzekw.class, zzekw);
    }

    private zzekw() {
    }

    public static zzekw zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzekw) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public final zzelc zza() {
        zzelc zzelc = this.zzb;
        return zzelc == null ? zzelc.zze() : zzelc;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzekw();
        } else {
            if (i2 == 4) {
                return new zzekv((zzeku) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzenq zzc() {
        zzenq zzenq = this.zze;
        return zzenq == null ? zzenq.zze() : zzenq;
    }
}
