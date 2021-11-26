package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdg extends zzeth<zzdg, zzdf> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzdg zzi;
    private int zzb;
    private zzesf zze;
    private zzesf zzf;
    private zzesf zzg;
    private zzesf zzh;

    static {
        zzdg zzdg = new zzdg();
        zzi = zzdg;
        zzeth.zzay(zzdg.class, zzdg);
    }

    private zzdg() {
        zzesf zzesf = zzesf.zzb;
        this.zze = zzesf;
        this.zzf = zzesf;
        this.zzg = zzesf;
        this.zzh = zzesf;
    }

    public static zzdg zzf(byte[] bArr, zzest zzest) throws zzett {
        return (zzdg) zzeth.zzaK(zzi, bArr, zzest);
    }

    public static zzdf zzg() {
        return (zzdf) zzi.zzas();
    }

    static /* synthetic */ void zzi(zzdg zzdg, zzesf zzesf) {
        zzdg.zzb |= 1;
        zzdg.zze = zzesf;
    }

    static /* synthetic */ void zzj(zzdg zzdg, zzesf zzesf) {
        zzdg.zzb |= 2;
        zzdg.zzf = zzesf;
    }

    static /* synthetic */ void zzk(zzdg zzdg, zzesf zzesf) {
        zzdg.zzb |= 4;
        zzdg.zzg = zzesf;
    }

    static /* synthetic */ void zzl(zzdg zzdg, zzesf zzesf) {
        zzdg.zzb |= 8;
        zzdg.zzh = zzesf;
    }

    public final zzesf zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzi, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh"});
        } else if (i2 == 3) {
            return new zzdg();
        } else {
            if (i2 == 4) {
                return new zzdf((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzi;
        }
    }

    public final zzesf zzc() {
        return this.zzf;
    }

    public final zzesf zzd() {
        return this.zzg;
    }

    public final zzesf zze() {
        return this.zzh;
    }
}
