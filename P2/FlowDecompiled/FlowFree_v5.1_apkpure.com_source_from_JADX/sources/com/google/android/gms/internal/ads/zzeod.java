package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeod extends zzeth<zzeod, zzeoc> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeod zzg;
    private String zzb = "";
    private zzesf zze = zzesf.zzb;
    private int zzf;

    static {
        zzeod zzeod = new zzeod();
        zzg = zzeod;
        zzeth.zzay(zzeod.class, zzeod);
    }

    private zzeod() {
    }

    public static zzeod zzd() {
        return zzg;
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
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzeod();
        } else {
            if (i2 == 4) {
                return new zzeoc((zzeob) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzesf zzc() {
        return this.zze;
    }
}
