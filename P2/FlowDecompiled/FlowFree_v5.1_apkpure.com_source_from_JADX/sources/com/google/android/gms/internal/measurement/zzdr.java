package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdr extends zzhr<zzdr, zzdq> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdr zzh;
    /* access modifiers changed from: private */
    public zzhx zza = zzhr.zzbC();
    /* access modifiers changed from: private */
    public zzhx zze = zzhr.zzbC();
    private zzhy<zzda> zzf = zzhr.zzbE();
    private zzhy<zzdt> zzg = zzhr.zzbE();

    static {
        zzdr zzdr = new zzdr();
        zzh = zzdr;
        zzhr.zzby(zzdr.class, zzdr);
    }

    private zzdr() {
    }

    public static zzdq zzk() {
        return (zzdq) zzh.zzbt();
    }

    public static zzdr zzm() {
        return zzh;
    }

    static /* synthetic */ void zzo(zzdr zzdr, Iterable iterable) {
        zzhx zzhx = zzdr.zza;
        if (!zzhx.zza()) {
            zzdr.zza = zzhr.zzbD(zzhx);
        }
        zzgc.zzbs(iterable, zzdr.zza);
    }

    static /* synthetic */ void zzq(zzdr zzdr, Iterable iterable) {
        zzhx zzhx = zzdr.zze;
        if (!zzhx.zza()) {
            zzdr.zze = zzhr.zzbD(zzhx);
        }
        zzgc.zzbs(iterable, zzdr.zze);
    }

    static /* synthetic */ void zzs(zzdr zzdr, Iterable iterable) {
        zzdr.zzw();
        zzgc.zzbs(iterable, zzdr.zzf);
    }

    static /* synthetic */ void zzt(zzdr zzdr, int i) {
        zzdr.zzw();
        zzdr.zzf.remove(i);
    }

    static /* synthetic */ void zzu(zzdr zzdr, Iterable iterable) {
        zzdr.zzx();
        zzgc.zzbs(iterable, zzdr.zzg);
    }

    static /* synthetic */ void zzv(zzdr zzdr, int i) {
        zzdr.zzx();
        zzdr.zzg.remove(i);
    }

    private final void zzw() {
        zzhy<zzda> zzhy = this.zzf;
        if (!zzhy.zza()) {
            this.zzf = zzhr.zzbF(zzhy);
        }
    }

    private final void zzx() {
        zzhy<zzdt> zzhy = this.zzg;
        if (!zzhy.zza()) {
            this.zzg = zzhr.zzbF(zzhy);
        }
    }

    public final List<Long> zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final List<Long> zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final List<zzda> zze() {
        return this.zzf;
    }

    public final int zzf() {
        return this.zzf.size();
    }

    public final zzda zzg(int i) {
        return this.zzf.get(i);
    }

    public final List<zzdt> zzh() {
        return this.zzg;
    }

    public final int zzi() {
        return this.zzg.size();
    }

    public final zzdt zzj(int i) {
        return this.zzg.get(i);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzh, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zza", "zze", "zzf", zzda.class, "zzg", zzdt.class});
        } else if (i2 == 3) {
            return new zzdr();
        } else {
            if (i2 == 4) {
                return new zzdq((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
