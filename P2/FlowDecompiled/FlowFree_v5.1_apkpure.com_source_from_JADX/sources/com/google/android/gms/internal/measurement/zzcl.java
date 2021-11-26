package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcl extends zzhr<zzcl, zzch> implements zzix {
    /* access modifiers changed from: private */
    public static final zzcl zzi;
    private int zza;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private zzhy<String> zzh = zzhr.zzbE();

    static {
        zzcl zzcl = new zzcl();
        zzi = zzcl;
        zzhr.zzby(zzcl.class, zzcl);
    }

    private zzcl() {
    }

    public static zzcl zzi() {
        return zzi;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzck zzb() {
        zzck zza2 = zzck.zza(this.zze);
        return zza2 == null ? zzck.UNKNOWN_MATCH_TYPE : zza2;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final List<String> zzg() {
        return this.zzh;
    }

    public final int zzh() {
        return this.zzh.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zza", "zze", zzck.zzb(), "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzcl();
        } else {
            if (i2 == 4) {
                return new zzch((zzbt) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
