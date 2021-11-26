package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzhv extends zzeth<zzhv, zzhu> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzhv zzj;
    private int zzb;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private long zzh;
    private long zzi;

    static {
        zzhv zzhv = new zzhv();
        zzj = zzhv;
        zzeth.zzay(zzhv.class, zzhv);
    }

    private zzhv() {
    }

    public static zzhv zzg(zzesf zzesf) throws zzett {
        return (zzhv) zzeth.zzaH(zzj, zzesf);
    }

    public static zzhv zzh(zzesf zzesf, zzest zzest) throws zzett {
        return (zzhv) zzeth.zzaI(zzj, zzesf, zzest);
    }

    public static zzhu zzi() {
        return (zzhu) zzj.zzas();
    }

    public static zzhv zzj() {
        return zzj;
    }

    static /* synthetic */ void zzl(zzhv zzhv, String str) {
        str.getClass();
        zzhv.zzb |= 1;
        zzhv.zze = str;
    }

    static /* synthetic */ void zzm(zzhv zzhv, String str) {
        str.getClass();
        zzhv.zzb |= 2;
        zzhv.zzf = str;
    }

    static /* synthetic */ void zzn(zzhv zzhv, long j) {
        zzhv.zzb |= 4;
        zzhv.zzg = j;
    }

    static /* synthetic */ void zzo(zzhv zzhv, long j) {
        zzhv.zzb |= 8;
        zzhv.zzh = j;
    }

    static /* synthetic */ void zzp(zzhv zzhv, long j) {
        zzhv.zzb |= 16;
        zzhv.zzi = j;
    }

    public final String zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzhv();
        } else {
            if (i2 == 4) {
                return new zzhu((zzht) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }

    public final String zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zzh;
    }

    public final long zzf() {
        return this.zzi;
    }
}
