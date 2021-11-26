package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzema extends zzeth<zzema, zzelz> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzema zzf;
    private int zzb;
    private int zze;

    static {
        zzema zzema = new zzema();
        zzf = zzema;
        zzeth.zzay(zzema.class, zzema);
    }

    private zzema() {
    }

    public static zzema zzc(zzesf zzesf, zzest zzest) throws zzett {
        return (zzema) zzeth.zzaI(zzf, zzesf, zzest);
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
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zze", "zzb"});
        } else if (i2 == 3) {
            return new zzema();
        } else {
            if (i2 == 4) {
                return new zzelz((zzely) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }
}
