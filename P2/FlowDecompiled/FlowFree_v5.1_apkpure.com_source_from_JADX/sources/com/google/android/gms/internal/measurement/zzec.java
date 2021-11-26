package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzec extends zzhr<zzec, zzeb> implements zzix {
    /* access modifiers changed from: private */
    public static final zzec zzg;
    private int zza;
    private zzhy<zzeh> zze = zzhr.zzbE();
    private zzdy zzf;

    static {
        zzec zzec = new zzec();
        zzg = zzec;
        zzhr.zzby(zzec.class, zzec);
    }

    private zzec() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zze", zzeh.class, "zzf"});
        } else if (i2 == 3) {
            return new zzec();
        } else {
            if (i2 == 4) {
                return new zzeb((zzdw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
