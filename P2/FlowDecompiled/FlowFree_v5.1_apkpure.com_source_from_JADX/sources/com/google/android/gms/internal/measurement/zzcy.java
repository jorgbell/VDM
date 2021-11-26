package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzcy extends zzhr<zzcy, zzcx> implements zzix {
    /* access modifiers changed from: private */
    public static final zzcy zzi;
    private int zza;
    private int zze;
    private zzdr zzf;
    private zzdr zzg;
    private boolean zzh;

    static {
        zzcy zzcy = new zzcy();
        zzi = zzcy;
        zzhr.zzby(zzcy.class, zzcy);
    }

    private zzcy() {
    }

    public static zzcx zzh() {
        return (zzcx) zzi.zzbt();
    }

    static /* synthetic */ void zzj(zzcy zzcy, int i) {
        zzcy.zza |= 1;
        zzcy.zze = i;
    }

    static /* synthetic */ void zzk(zzcy zzcy, zzdr zzdr) {
        zzdr.getClass();
        zzcy.zzf = zzdr;
        zzcy.zza |= 2;
    }

    static /* synthetic */ void zzm(zzcy zzcy, zzdr zzdr) {
        zzcy.zzg = zzdr;
        zzcy.zza |= 4;
    }

    static /* synthetic */ void zzn(zzcy zzcy, boolean z) {
        zzcy.zza |= 8;
        zzcy.zzh = z;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final zzdr zzc() {
        zzdr zzdr = this.zzf;
        return zzdr == null ? zzdr.zzm() : zzdr;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final zzdr zze() {
        zzdr zzdr = this.zzg;
        return zzdr == null ? zzdr.zzm() : zzdr;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final boolean zzg() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zza", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzcy();
        } else {
            if (i2 == 4) {
                return new zzcx((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
