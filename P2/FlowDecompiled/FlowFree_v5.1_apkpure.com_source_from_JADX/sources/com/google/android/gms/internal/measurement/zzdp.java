package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdp extends zzhr<zzdp, zzdl> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdp zzg;
    private int zza;
    private int zze = 1;
    private zzhy<zzde> zzf = zzhr.zzbE();

    static {
        zzdp zzdp = new zzdp();
        zzg = zzdp;
        zzhr.zzby(zzdp.class, zzdp);
    }

    private zzdp() {
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zza", "zze", zzdo.zzb(), "zzf", zzde.class});
        } else if (i2 == 3) {
            return new zzdp();
        } else {
            if (i2 == 4) {
                return new zzdl((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
