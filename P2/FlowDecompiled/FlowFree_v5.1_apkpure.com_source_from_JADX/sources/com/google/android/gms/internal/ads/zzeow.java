package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeow extends zzeth<zzeow, zzeov> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeow zze;
    private String zzb = "";

    static {
        zzeow zzeow = new zzeow();
        zze = zzeow;
        zzeth.zzay(zzeow.class, zzeow);
    }

    private zzeow() {
    }

    public static zzeow zzc(zzesf zzesf, zzest zzest) throws zzett {
        return (zzeow) zzeth.zzaI(zze, zzesf, zzest);
    }

    public static zzeow zzd() {
        return zze;
    }

    public final String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zze, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzb"});
        } else if (i2 == 3) {
            return new zzeow();
        } else {
            if (i2 == 4) {
                return new zzeov((zzeou) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
