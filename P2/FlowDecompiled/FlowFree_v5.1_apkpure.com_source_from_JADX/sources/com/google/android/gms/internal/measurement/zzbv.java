package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzbv extends zzhr<zzbv, zzbu> implements zzix {
    /* access modifiers changed from: private */
    public static final zzbv zzj;
    private int zza;
    private int zze;
    private zzhy<zzcg> zzf = zzhr.zzbE();
    private zzhy<zzbx> zzg = zzhr.zzbE();
    private boolean zzh;
    private boolean zzi;

    static {
        zzbv zzbv = new zzbv();
        zzj = zzbv;
        zzhr.zzby(zzbv.class, zzbv);
    }

    private zzbv() {
    }

    static /* synthetic */ void zzj(zzbv zzbv, int i, zzcg zzcg) {
        zzcg.getClass();
        zzhy<zzcg> zzhy = zzbv.zzf;
        if (!zzhy.zza()) {
            zzbv.zzf = zzhr.zzbF(zzhy);
        }
        zzbv.zzf.set(i, zzcg);
    }

    static /* synthetic */ void zzk(zzbv zzbv, int i, zzbx zzbx) {
        zzbx.getClass();
        zzhy<zzbx> zzhy = zzbv.zzg;
        if (!zzhy.zza()) {
            zzbv.zzg = zzhr.zzbF(zzhy);
        }
        zzbv.zzg.set(i, zzbx);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final List<zzcg> zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final zzcg zze(int i) {
        return this.zzf.get(i);
    }

    public final List<zzbx> zzf() {
        return this.zzg;
    }

    public final int zzg() {
        return this.zzg.size();
    }

    public final zzbx zzh(int i) {
        return this.zzg.get(i);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zza", "zze", "zzf", zzcg.class, "zzg", zzbx.class, "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzbv();
        } else {
            if (i2 == 4) {
                return new zzbu((zzbt) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
