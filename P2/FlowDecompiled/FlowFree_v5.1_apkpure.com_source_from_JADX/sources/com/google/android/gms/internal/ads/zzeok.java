package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeok extends zzeth<zzeok, zzeoj> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeok zzh;
    private zzeny zzb;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzeok zzeok = new zzeok();
        zzh = zzeok;
        zzeth.zzay(zzeok.class, zzeok);
    }

    private zzeok() {
    }

    public final boolean zza() {
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzeok();
        } else {
            if (i2 == 4) {
                return new zzeoj((zzeoh) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final zzeny zzc() {
        zzeny zzeny = this.zzb;
        return zzeny == null ? zzeny.zzf() : zzeny;
    }

    public final zzeoa zzd() {
        zzeoa zzb2 = zzeoa.zzb(this.zze);
        return zzb2 == null ? zzeoa.UNRECOGNIZED : zzb2;
    }

    public final int zze() {
        return this.zzf;
    }

    public final zzepe zzf() {
        zzepe zzb2 = zzepe.zzb(this.zzg);
        return zzb2 == null ? zzepe.UNRECOGNIZED : zzb2;
    }
}
