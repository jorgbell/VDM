package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzemx extends zzeth<zzemx, zzemw> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzemx zzg;
    private zzeng zzb;
    private zzemr zze;
    private int zzf;

    static {
        zzemx zzemx = new zzemx();
        zzg = zzemx;
        zzeth.zzay(zzemx.class, zzemx);
    }

    private zzemx() {
    }

    public static zzemx zze() {
        return zzg;
    }

    public final zzeng zza() {
        zzeng zzeng = this.zzb;
        return zzeng == null ? zzeng.zze() : zzeng;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzemx();
        } else {
            if (i2 == 4) {
                return new zzemw((zzemv) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzemr zzc() {
        zzemr zzemr = this.zze;
        return zzemr == null ? zzemr.zzc() : zzemr;
    }

    public final zzemo zzd() {
        zzemo zza = zzemo.zza(this.zzf);
        return zza == null ? zzemo.UNRECOGNIZED : zza;
    }
}
