package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzemr extends zzeth<zzemr, zzemq> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzemr zze;
    private zzeod zzb;

    static {
        zzemr zzemr = new zzemr();
        zze = zzemr;
        zzeth.zzay(zzemr.class, zzemr);
    }

    private zzemr() {
    }

    public static zzemr zzc() {
        return zze;
    }

    public final zzeod zza() {
        zzeod zzeod = this.zzb;
        return zzeod == null ? zzeod.zzd() : zzeod;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zze, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzemr();
        } else {
            if (i2 == 4) {
                return new zzemq((zzemp) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
