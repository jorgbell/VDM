package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzdb extends zzeth<zzdb, zzda> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzdb zzk;
    private int zzb;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;

    static {
        zzdb zzdb = new zzdb();
        zzk = zzdb;
        zzeth.zzay(zzdb.class, zzdb);
    }

    private zzdb() {
    }

    public static zzda zza() {
        return (zzda) zzk.zzas();
    }

    static /* synthetic */ void zzd(zzdb zzdb, long j) {
        zzdb.zzb |= 4;
        zzdb.zzg = j;
    }

    static /* synthetic */ void zze(zzdb zzdb, long j) {
        zzdb.zzb |= 8;
        zzdb.zzh = j;
    }

    static /* synthetic */ void zzf(zzdb zzdb, long j) {
        zzdb.zzb |= 16;
        zzdb.zzi = j;
    }

    static /* synthetic */ void zzg(zzdb zzdb, long j) {
        zzdb.zzb |= 32;
        zzdb.zzj = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzdb();
        } else {
            if (i2 == 4) {
                return new zzda((zzcm) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }
}
