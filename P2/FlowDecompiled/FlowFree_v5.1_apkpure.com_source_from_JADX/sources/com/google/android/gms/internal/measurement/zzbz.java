package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzbz extends zzhr<zzbz, zzby> implements zzix {
    /* access modifiers changed from: private */
    public static final zzbz zzi;
    private int zza;
    private zzcl zze;
    private zzce zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzbz zzbz = new zzbz();
        zzi = zzbz;
        zzhr.zzby(zzbz.class, zzbz);
    }

    private zzbz() {
    }

    public static zzbz zzi() {
        return zzi;
    }

    static /* synthetic */ void zzk(zzbz zzbz, String str) {
        zzbz.zza |= 8;
        zzbz.zzh = str;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final zzcl zzb() {
        zzcl zzcl = this.zze;
        return zzcl == null ? zzcl.zzi() : zzcl;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final zzce zzd() {
        zzce zzce = this.zzf;
        return zzce == null ? zzce.zzk() : zzce;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final boolean zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final String zzh() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzbz();
        } else {
            if (i2 == 4) {
                return new zzby((zzbt) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
