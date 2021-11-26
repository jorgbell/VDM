package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcs extends zzhr<zzcs, zzcr> implements zzix {
    /* access modifiers changed from: private */
    public static final zzcs zzg;
    private int zza;
    private String zze = "";
    private String zzf = "";

    static {
        zzcs zzcs = new zzcs();
        zzg = zzcs;
        zzhr.zzby(zzcs.class, zzcs);
    }

    private zzcs() {
    }

    public final String zza() {
        return this.zze;
    }

    public final String zzb() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zza", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzcs();
        } else {
            if (i2 == 4) {
                return new zzcr((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
