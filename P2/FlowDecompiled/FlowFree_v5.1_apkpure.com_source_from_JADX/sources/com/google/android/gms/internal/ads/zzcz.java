package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzcz extends zzeth<zzcz, zzcy> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzcz zzz;
    private int zzb;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private int zzk = 1000;
    private long zzl = -1;
    private long zzm = -1;
    private long zzn = -1;
    private int zzo = 1000;
    private long zzp = -1;
    private long zzq = -1;
    private long zzr = -1;
    private long zzs = -1;
    private long zzt;
    private long zzu;
    private long zzv = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;

    static {
        zzcz zzcz = new zzcz();
        zzz = zzcz;
        zzeth.zzay(zzcz.class, zzcz);
    }

    private zzcz() {
    }

    public static zzcy zza() {
        return (zzcy) zzz.zzas();
    }

    static /* synthetic */ void zzd(zzcz zzcz, long j) {
        zzcz.zzb |= 1;
        zzcz.zze = j;
    }

    static /* synthetic */ void zze(zzcz zzcz, long j) {
        zzcz.zzb |= 2;
        zzcz.zzf = j;
    }

    static /* synthetic */ void zzf(zzcz zzcz, long j) {
        zzcz.zzb |= 4;
        zzcz.zzg = j;
    }

    static /* synthetic */ void zzg(zzcz zzcz, long j) {
        zzcz.zzb |= 8;
        zzcz.zzh = j;
    }

    static /* synthetic */ void zzh(zzcz zzcz) {
        zzcz.zzb &= -9;
        zzcz.zzh = -1;
    }

    static /* synthetic */ void zzi(zzcz zzcz, long j) {
        zzcz.zzb |= 16;
        zzcz.zzi = j;
    }

    static /* synthetic */ void zzj(zzcz zzcz, long j) {
        zzcz.zzb |= 32;
        zzcz.zzj = j;
    }

    static /* synthetic */ void zzk(zzcz zzcz, zzdm zzdm) {
        zzcz.zzk = zzdm.zza();
        zzcz.zzb |= 64;
    }

    static /* synthetic */ void zzl(zzcz zzcz, long j) {
        zzcz.zzb |= 128;
        zzcz.zzl = j;
    }

    static /* synthetic */ void zzm(zzcz zzcz, long j) {
        zzcz.zzb |= 256;
        zzcz.zzm = j;
    }

    static /* synthetic */ void zzn(zzcz zzcz, long j) {
        zzcz.zzb |= 512;
        zzcz.zzn = j;
    }

    static /* synthetic */ void zzo(zzcz zzcz, zzdm zzdm) {
        zzcz.zzo = zzdm.zza();
        zzcz.zzb |= 1024;
    }

    static /* synthetic */ void zzp(zzcz zzcz, long j) {
        zzcz.zzb |= 2048;
        zzcz.zzp = j;
    }

    static /* synthetic */ void zzq(zzcz zzcz, long j) {
        zzcz.zzb |= 4096;
        zzcz.zzq = j;
    }

    static /* synthetic */ void zzr(zzcz zzcz, long j) {
        zzcz.zzb |= 8192;
        zzcz.zzr = j;
    }

    static /* synthetic */ void zzs(zzcz zzcz, long j) {
        zzcz.zzb |= 16384;
        zzcz.zzs = j;
    }

    static /* synthetic */ void zzt(zzcz zzcz, long j) {
        zzcz.zzb |= 32768;
        zzcz.zzt = j;
    }

    static /* synthetic */ void zzu(zzcz zzcz, long j) {
        zzcz.zzb |= 65536;
        zzcz.zzu = j;
    }

    static /* synthetic */ void zzv(zzcz zzcz, long j) {
        zzcz.zzb |= 131072;
        zzcz.zzv = j;
    }

    static /* synthetic */ void zzw(zzcz zzcz, long j) {
        zzcz.zzb |= 262144;
        zzcz.zzw = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzz, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဌ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဌ\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzdm.zzc(), "zzl", "zzm", "zzn", "zzo", zzdm.zzc(), "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy"});
        } else if (i2 == 3) {
            return new zzcz();
        } else {
            if (i2 == 4) {
                return new zzcy((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzz;
        }
    }
}
