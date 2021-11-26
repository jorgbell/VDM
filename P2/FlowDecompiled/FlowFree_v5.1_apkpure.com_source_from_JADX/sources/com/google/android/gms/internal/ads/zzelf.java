package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzelf extends zzeth<zzelf, zzele> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzelf zze;
    private int zzb;

    static {
        zzelf zzelf = new zzelf();
        zze = zzelf;
        zzeth.zzay(zzelf.class, zzelf);
    }

    private zzelf() {
    }

    public static zzelf zzc() {
        return zze;
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
            return zzeth.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzelf();
        } else {
            if (i2 == 4) {
                return new zzele((zzeld) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
