package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdv extends zzeth<zzdv, zzdu> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzdv zzi;
    private int zzb;
    private zzetq<zzesf> zze = zzeth.zzaE();
    private zzesf zzf = zzesf.zzb;
    private int zzg = 1;
    private int zzh = 1;

    static {
        zzdv zzdv = new zzdv();
        zzi = zzdv;
        zzeth.zzay(zzdv.class, zzdv);
    }

    private zzdv() {
    }

    public static zzdu zza() {
        return (zzdu) zzi.zzas();
    }

    static /* synthetic */ void zzd(zzdv zzdv, zzesf zzesf) {
        zzetq<zzesf> zzetq = zzdv.zze;
        if (!zzetq.zza()) {
            zzdv.zze = zzeth.zzaF(zzetq);
        }
        zzdv.zze.add(zzesf);
    }

    static /* synthetic */ void zze(zzdv zzdv, zzesf zzesf) {
        zzdv.zzb |= 1;
        zzdv.zzf = zzesf;
    }

    static /* synthetic */ void zzf(zzdv zzdv, zzdj zzdj) {
        zzdv.zzh = zzdj.zza();
        zzdv.zzb |= 4;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003ဌ\u0001\u0004ဌ\u0002", new Object[]{"zzb", "zze", "zzf", "zzg", zzdp.zzb(), "zzh", zzdj.zzc()});
        } else if (i2 == 3) {
            return new zzdv();
        } else {
            if (i2 == 4) {
                return new zzdu((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }
}
