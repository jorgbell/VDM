package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzend extends zzeth<zzend, zzenc> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzend zzh;
    /* access modifiers changed from: private */
    public int zzb;
    private zzemx zze;
    /* access modifiers changed from: private */
    public zzesf zzf;
    /* access modifiers changed from: private */
    public zzesf zzg;

    static {
        zzend zzend = new zzend();
        zzh = zzend;
        zzeth.zzay(zzend.class, zzend);
    }

    private zzend() {
        zzesf zzesf = zzesf.zzb;
        this.zzf = zzesf;
        this.zzg = zzesf;
    }

    public static zzend zzf(zzesf zzesf, zzest zzest) throws zzett {
        return (zzend) zzeth.zzaI(zzh, zzesf, zzest);
    }

    public static zzenc zzg() {
        return (zzenc) zzh.zzas();
    }

    public static zzend zzh() {
        return zzh;
    }

    static /* synthetic */ void zzk(zzend zzend, zzemx zzemx) {
        zzemx.getClass();
        zzend.zze = zzemx;
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzend();
        } else {
            if (i2 == 4) {
                return new zzenc((zzenb) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final zzemx zzc() {
        zzemx zzemx = this.zze;
        return zzemx == null ? zzemx.zze() : zzemx;
    }

    public final zzesf zzd() {
        return this.zzf;
    }

    public final zzesf zze() {
        return this.zzg;
    }
}
