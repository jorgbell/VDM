package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeog extends zzeth<zzeog, zzeof> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeog zzi;
    private String zzb = "";
    private String zze = "";
    private int zzf;
    private boolean zzg;
    private String zzh = "";

    static {
        zzeog zzeog = new zzeog();
        zzi = zzeog;
        zzeth.zzay(zzeog.class, zzeog);
    }

    private zzeog() {
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
            return zzeth.zzaz(zzi, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzeog();
        } else {
            if (i2 == 4) {
                return new zzeof((zzeoe) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }

    public final String zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final String zzf() {
        return this.zzh;
    }
}
