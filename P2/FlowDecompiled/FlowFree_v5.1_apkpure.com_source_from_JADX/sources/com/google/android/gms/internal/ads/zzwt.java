package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzwt extends zzeth<zzwt, zzws> implements zzeup {
    private static final zzetn<Integer, zzvg> zzj = new zzwr();
    /* access modifiers changed from: private */
    public static final zzwt zzr;
    private int zzb;
    private long zze;
    private int zzf;
    private long zzg;
    private long zzh;
    private zzetm zzi = zzeth.zzaB();
    private zzwo zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private int zzp;
    private int zzq;

    static {
        zzwt zzwt = new zzwt();
        zzr = zzwt;
        zzeth.zzay(zzwt.class, zzwt);
    }

    private zzwt() {
    }

    static /* synthetic */ void zzA(zzwt zzwt, zzvy zzvy) {
        zzwt.zzp = zzvy.zza();
        zzwt.zzb |= 512;
    }

    static /* synthetic */ void zzB(zzwt zzwt, zzwx zzwx) {
        zzwt.zzq = zzwx.zza();
        zzwt.zzb |= 1024;
    }

    public static zzwt zzn(byte[] bArr) throws zzett {
        return (zzwt) zzeth.zzaJ(zzr, bArr);
    }

    public static zzws zzo() {
        return (zzws) zzr.zzas();
    }

    static /* synthetic */ void zzq(zzwt zzwt, long j) {
        zzwt.zzb |= 1;
        zzwt.zze = j;
    }

    static /* synthetic */ void zzr(zzwt zzwt, zzvy zzvy) {
        zzwt.zzf = zzvy.zza();
        zzwt.zzb |= 2;
    }

    static /* synthetic */ void zzs(zzwt zzwt, long j) {
        zzwt.zzb |= 4;
        zzwt.zzg = j;
    }

    static /* synthetic */ void zzt(zzwt zzwt, long j) {
        zzwt.zzb |= 8;
        zzwt.zzh = j;
    }

    static /* synthetic */ void zzu(zzwt zzwt, Iterable iterable) {
        zzetm zzetm = zzwt.zzi;
        if (!zzetm.zza()) {
            zzwt.zzi = zzeth.zzaC(zzetm);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzwt.zzi.zzh(((zzvg) it.next()).zza());
        }
    }

    static /* synthetic */ void zzv(zzwt zzwt, zzwo zzwo) {
        zzwo.getClass();
        zzwt.zzk = zzwo;
        zzwt.zzb |= 16;
    }

    static /* synthetic */ void zzw(zzwt zzwt, zzvy zzvy) {
        zzwt.zzl = zzvy.zza();
        zzwt.zzb |= 32;
    }

    static /* synthetic */ void zzx(zzwt zzwt, zzvy zzvy) {
        zzwt.zzm = zzvy.zza();
        zzwt.zzb |= 64;
    }

    static /* synthetic */ void zzy(zzwt zzwt, zzvy zzvy) {
        zzwt.zzn = zzvy.zza();
        zzwt.zzb |= 128;
    }

    static /* synthetic */ void zzz(zzwt zzwt, int i) {
        zzwt.zzb |= 256;
        zzwt.zzo = i;
    }

    public final long zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzr, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005\u001e\u0006ဉ\u0004\u0007ဌ\u0005\bဌ\u0006\tဌ\u0007\nင\b\u000bဌ\t\fဌ\n", new Object[]{"zzb", "zze", "zzf", zzvy.zzc(), "zzg", "zzh", "zzi", zzvg.zzc(), "zzk", "zzl", zzvy.zzc(), "zzm", zzvy.zzc(), "zzn", zzvy.zzc(), "zzo", "zzp", zzvy.zzc(), "zzq", zzwx.zzc()});
        } else if (i2 == 3) {
            return new zzwt();
        } else {
            if (i2 == 4) {
                return new zzws((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzr;
        }
    }

    public final zzvy zzc() {
        zzvy zzb2 = zzvy.zzb(this.zzf);
        return zzb2 == null ? zzvy.ENUM_FALSE : zzb2;
    }

    public final long zzd() {
        return this.zzg;
    }

    public final long zze() {
        return this.zzh;
    }

    public final List<zzvg> zzf() {
        return new zzeto(this.zzi, zzj);
    }

    public final zzwo zzg() {
        zzwo zzwo = this.zzk;
        return zzwo == null ? zzwo.zzg() : zzwo;
    }

    public final zzvy zzh() {
        zzvy zzb2 = zzvy.zzb(this.zzl);
        return zzb2 == null ? zzvy.ENUM_FALSE : zzb2;
    }

    public final zzvy zzi() {
        zzvy zzb2 = zzvy.zzb(this.zzm);
        return zzb2 == null ? zzvy.ENUM_FALSE : zzb2;
    }

    public final zzvy zzj() {
        zzvy zzb2 = zzvy.zzb(this.zzn);
        return zzb2 == null ? zzvy.ENUM_FALSE : zzb2;
    }

    public final int zzk() {
        return this.zzo;
    }

    public final zzvy zzl() {
        zzvy zzb2 = zzvy.zzb(this.zzp);
        return zzb2 == null ? zzvy.ENUM_FALSE : zzb2;
    }

    public final zzwx zzm() {
        zzwx zzb2 = zzwx.zzb(this.zzq);
        return zzb2 == null ? zzwx.UNSPECIFIED : zzb2;
    }
}
