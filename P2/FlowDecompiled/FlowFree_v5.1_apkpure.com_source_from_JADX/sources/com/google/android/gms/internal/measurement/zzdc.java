package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdc extends zzhr<zzdc, zzdb> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdc zzj;
    private int zza;
    /* access modifiers changed from: private */
    public zzhy<zzdg> zze = zzhr.zzbE();
    private String zzf = "";
    private long zzg;
    private long zzh;
    private int zzi;

    static {
        zzdc zzdc = new zzdc();
        zzj = zzdc;
        zzhr.zzby(zzdc.class, zzdc);
    }

    private zzdc() {
    }

    public static zzdb zzk() {
        return (zzdb) zzj.zzbt();
    }

    static /* synthetic */ void zzn(zzdc zzdc, int i, zzdg zzdg) {
        zzdg.getClass();
        zzdc.zzv();
        zzdc.zze.set(i, zzdg);
    }

    static /* synthetic */ void zzo(zzdc zzdc, zzdg zzdg) {
        zzdg.getClass();
        zzdc.zzv();
        zzdc.zze.add(zzdg);
    }

    static /* synthetic */ void zzp(zzdc zzdc, Iterable iterable) {
        zzdc.zzv();
        zzgc.zzbs(iterable, zzdc.zze);
    }

    static /* synthetic */ void zzr(zzdc zzdc, int i) {
        zzdc.zzv();
        zzdc.zze.remove(i);
    }

    static /* synthetic */ void zzs(zzdc zzdc, String str) {
        str.getClass();
        zzdc.zza |= 1;
        zzdc.zzf = str;
    }

    static /* synthetic */ void zzt(zzdc zzdc, long j) {
        zzdc.zza |= 2;
        zzdc.zzg = j;
    }

    static /* synthetic */ void zzu(zzdc zzdc, long j) {
        zzdc.zza |= 4;
        zzdc.zzh = j;
    }

    private final void zzv() {
        zzhy<zzdg> zzhy = this.zze;
        if (!zzhy.zza()) {
            this.zze = zzhr.zzbF(zzhy);
        }
    }

    public final List<zzdg> zza() {
        return this.zze;
    }

    public final int zzb() {
        return this.zze.size();
    }

    public final zzdg zzc(int i) {
        return this.zze.get(i);
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 2) != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 4) != 0;
    }

    public final long zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 8) != 0;
    }

    public final int zzj() {
        return this.zzi;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzj, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zza", "zze", zzdg.class, "zzf", "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzdc();
        } else {
            if (i2 == 4) {
                return new zzdb((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzj;
        }
    }
}
