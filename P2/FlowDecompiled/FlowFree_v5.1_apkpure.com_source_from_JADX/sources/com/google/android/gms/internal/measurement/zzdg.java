package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdg extends zzhr<zzdg, zzdf> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdg zzk;
    private int zza;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;
    /* access modifiers changed from: private */
    public zzhy<zzdg> zzj = zzhr.zzbE();

    static {
        zzdg zzdg = new zzdg();
        zzk = zzdg;
        zzhr.zzby(zzdg.class, zzdg);
    }

    private zzdg() {
    }

    public static zzdf zzn() {
        return (zzdf) zzk.zzbt();
    }

    static /* synthetic */ void zzp(zzdg zzdg, String str) {
        str.getClass();
        zzdg.zza |= 1;
        zzdg.zze = str;
    }

    static /* synthetic */ void zzq(zzdg zzdg, String str) {
        str.getClass();
        zzdg.zza |= 2;
        zzdg.zzf = str;
    }

    static /* synthetic */ void zzr(zzdg zzdg) {
        zzdg.zza &= -3;
        zzdg.zzf = zzk.zzf;
    }

    static /* synthetic */ void zzs(zzdg zzdg, long j) {
        zzdg.zza |= 4;
        zzdg.zzg = j;
    }

    static /* synthetic */ void zzt(zzdg zzdg) {
        zzdg.zza &= -5;
        zzdg.zzg = 0;
    }

    static /* synthetic */ void zzu(zzdg zzdg, double d) {
        zzdg.zza |= 16;
        zzdg.zzi = d;
    }

    static /* synthetic */ void zzv(zzdg zzdg) {
        zzdg.zza &= -17;
        zzdg.zzi = 0.0d;
    }

    static /* synthetic */ void zzw(zzdg zzdg, zzdg zzdg2) {
        zzdg2.getClass();
        zzdg.zzz();
        zzdg.zzj.add(zzdg2);
    }

    static /* synthetic */ void zzx(zzdg zzdg, Iterable iterable) {
        zzdg.zzz();
        zzgc.zzbs(iterable, zzdg.zzj);
    }

    private final void zzz() {
        zzhy<zzdg> zzhy = this.zzj;
        if (!zzhy.zza()) {
            this.zzj = zzhr.zzbF(zzhy);
        }
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final String zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return (this.zza & 2) != 0;
    }

    public final String zzd() {
        return this.zzf;
    }

    public final boolean zze() {
        return (this.zza & 4) != 0;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final boolean zzg() {
        return (this.zza & 8) != 0;
    }

    public final float zzh() {
        return this.zzh;
    }

    public final boolean zzi() {
        return (this.zza & 16) != 0;
    }

    public final double zzj() {
        return this.zzi;
    }

    public final List<zzdg> zzk() {
        return this.zzj;
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzk, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zza", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzdg.class});
        } else if (i2 == 3) {
            return new zzdg();
        } else {
            if (i2 == 4) {
                return new zzdf((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzk;
        }
    }

    public final int zzm() {
        return this.zzj.size();
    }
}
