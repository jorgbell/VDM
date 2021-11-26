package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzent extends zzeth<zzent, zzens> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzent zzf;
    private int zzb;
    private int zze;

    static {
        zzent zzent = new zzent();
        zzf = zzent;
        zzeth.zzay(zzent.class, zzent);
    }

    private zzent() {
    }

    public static zzent zzd() {
        return zzf;
    }

    public final zzenk zza() {
        zzenk zza = zzenk.zza(this.zzb);
        return zza == null ? zzenk.UNRECOGNIZED : zza;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzent();
        } else {
            if (i2 == 4) {
                return new zzens((zzenr) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final int zzc() {
        return this.zze;
    }
}
