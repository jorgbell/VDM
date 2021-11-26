package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzeh extends zzhr<zzeh, zzed> implements zzix {
    /* access modifiers changed from: private */
    public static final zzeh zzk;
    private int zza;
    private int zze;
    private zzhy<zzeh> zzf = zzhr.zzbE();
    private String zzg = "";
    private String zzh = "";
    private boolean zzi;
    private double zzj;

    static {
        zzeh zzeh = new zzeh();
        zzk = zzeh;
        zzhr.zzby(zzeh.class, zzeh);
    }

    private zzeh() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zza", "zze", zzeg.zzb(), "zzf", zzeh.class, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzeh();
        } else {
            if (i2 == 4) {
                return new zzed((zzdw) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
