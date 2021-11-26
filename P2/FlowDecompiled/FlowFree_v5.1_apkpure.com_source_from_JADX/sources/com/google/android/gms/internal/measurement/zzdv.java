package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdv extends zzhr<zzdv, zzdu> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdv zzk;
    private int zza;
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private float zzi;
    private double zzj;

    static {
        zzdv zzdv = new zzdv();
        zzk = zzdv;
        zzhr.zzby(zzdv.class, zzdv);
    }

    private zzdv() {
    }

    public static zzdu zzj() {
        return (zzdu) zzk.zzbt();
    }

    static /* synthetic */ void zzm(zzdv zzdv, long j) {
        zzdv.zza |= 1;
        zzdv.zze = j;
    }

    static /* synthetic */ void zzn(zzdv zzdv, String str) {
        str.getClass();
        zzdv.zza |= 2;
        zzdv.zzf = str;
    }

    static /* synthetic */ void zzo(zzdv zzdv, String str) {
        str.getClass();
        zzdv.zza |= 4;
        zzdv.zzg = str;
    }

    static /* synthetic */ void zzp(zzdv zzdv) {
        zzdv.zza &= -5;
        zzdv.zzg = zzk.zzg;
    }

    static /* synthetic */ void zzq(zzdv zzdv, long j) {
        zzdv.zza |= 8;
        zzdv.zzh = j;
    }

    static /* synthetic */ void zzr(zzdv zzdv) {
        zzdv.zza &= -9;
        zzdv.zzh = 0;
    }

    static /* synthetic */ void zzs(zzdv zzdv, double d) {
        zzdv.zza |= 32;
        zzdv.zzj = d;
    }

    static /* synthetic */ void zzt(zzdv zzdv) {
        zzdv.zza &= -33;
        zzdv.zzj = 0.0d;
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final long zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zza & 4) != 0;
    }

    public final String zze() {
        return this.zzg;
    }

    public final boolean zzf() {
        return (this.zza & 8) != 0;
    }

    public final long zzg() {
        return this.zzh;
    }

    public final boolean zzh() {
        return (this.zza & 32) != 0;
    }

    public final double zzi() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzdv();
        } else {
            if (i2 == 4) {
                return new zzdu((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
