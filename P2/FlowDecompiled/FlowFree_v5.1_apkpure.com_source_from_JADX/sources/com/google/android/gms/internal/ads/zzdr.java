package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdr extends zzeth<zzdr, zzdq> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzdr zzh;
    private int zzb;
    private long zze;
    private String zzf = "";
    private zzesf zzg = zzesf.zzb;

    static {
        zzdr zzdr = new zzdr();
        zzh = zzdr;
        zzeth.zzay(zzdr.class, zzdr);
    }

    private zzdr() {
    }

    public static zzdr zzd() {
        return zzh;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzdr();
        } else {
            if (i2 == 4) {
                return new zzdq((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }

    public final long zzc() {
        return this.zze;
    }
}
