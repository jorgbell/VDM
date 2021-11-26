package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzea extends zzhr<zzea, zzdz> implements zzix {
    /* access modifiers changed from: private */
    public static final zzea zzg;
    private int zza;
    private String zze = "";
    private zzhy<zzeh> zzf = zzhr.zzbE();

    static {
        zzea zzea = new zzea();
        zzg = zzea;
        zzhr.zzby(zzea.class, zzea);
    }

    private zzea() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zza", "zze", "zzf", zzeh.class});
        } else if (i2 == 3) {
            return new zzea();
        } else {
            if (i2 == 4) {
                return new zzdz((zzdw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
