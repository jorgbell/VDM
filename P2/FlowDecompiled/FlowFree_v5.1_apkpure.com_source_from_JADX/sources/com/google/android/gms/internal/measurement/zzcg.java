package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcg extends zzhr<zzcg, zzcf> implements zzix {
    /* access modifiers changed from: private */
    public static final zzcg zzk;
    private int zza;
    private int zze;
    private String zzf = "";
    private zzbz zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        zzcg zzcg = new zzcg();
        zzk = zzcg;
        zzhr.zzby(zzcg.class, zzcg);
    }

    private zzcg() {
    }

    public static zzcf zzi() {
        return (zzcf) zzk.zzbt();
    }

    static /* synthetic */ void zzk(zzcg zzcg, String str) {
        zzcg.zza |= 2;
        zzcg.zzf = str;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final zzbz zzd() {
        zzbz zzbz = this.zzg;
        return zzbz == null ? zzbz.zzi() : zzbz;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        return (this.zza & 32) != 0;
    }

    public final boolean zzh() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzcg();
        } else {
            if (i2 == 4) {
                return new zzcf((zzbt) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
