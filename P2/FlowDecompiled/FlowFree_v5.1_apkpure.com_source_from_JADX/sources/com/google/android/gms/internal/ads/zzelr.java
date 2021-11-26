package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzelr extends zzeth<zzelr, zzelq> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzelr zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzesf zze = zzesf.zzb;

    static {
        zzelr zzelr = new zzelr();
        zzf = zzelr;
        zzeth.zzay(zzelr.class, zzelr);
    }

    private zzelr() {
    }

    public static zzelr zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzelr) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public static zzelq zze() {
        return (zzelq) zzf.zzas();
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
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzelr();
        } else {
            if (i2 == 4) {
                return new zzelq((zzelp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzesf zzc() {
        return this.zze;
    }
}
