package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzbx extends zzhr<zzbx, zzbw> implements zzix {
    /* access modifiers changed from: private */
    public static final zzbx zzm;
    private int zza;
    private int zze;
    private String zzf = "";
    private zzhy<zzbz> zzg = zzhr.zzbE();
    private boolean zzh;
    private zzce zzi;
    private boolean zzj;
    private boolean zzk;
    private boolean zzl;

    static {
        zzbx zzbx = new zzbx();
        zzm = zzbx;
        zzhr.zzby(zzbx.class, zzbx);
    }

    private zzbx() {
    }

    public static zzbw zzn() {
        return (zzbw) zzm.zzbt();
    }

    static /* synthetic */ void zzp(zzbx zzbx, String str) {
        zzbx.zza |= 2;
        zzbx.zzf = str;
    }

    static /* synthetic */ void zzq(zzbx zzbx, int i, zzbz zzbz) {
        zzbz.getClass();
        zzhy<zzbz> zzhy = zzbx.zzg;
        if (!zzhy.zza()) {
            zzbx.zzg = zzhr.zzbF(zzhy);
        }
        zzbx.zzg.set(i, zzbz);
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

    public final List<zzbz> zzd() {
        return this.zzg;
    }

    public final int zze() {
        return this.zzg.size();
    }

    public final zzbz zzf(int i) {
        return this.zzg.get(i);
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final zzce zzh() {
        zzce zzce = this.zzi;
        return zzce == null ? zzce.zzk() : zzce;
    }

    public final boolean zzi() {
        return this.zzj;
    }

    public final boolean zzj() {
        return this.zzk;
    }

    public final boolean zzk() {
        return (this.zza & 64) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zza", "zze", "zzf", "zzg", zzbz.class, "zzh", "zzi", "zzj", "zzk", "zzl"});
        } else if (i2 == 3) {
            return new zzbx();
        } else {
            if (i2 == 4) {
                return new zzbw((zzbt) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzm;
        }
    }

    public final boolean zzm() {
        return this.zzl;
    }
}
