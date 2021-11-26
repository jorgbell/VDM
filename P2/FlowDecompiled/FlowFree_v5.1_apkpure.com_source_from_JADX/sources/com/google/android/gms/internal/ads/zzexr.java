package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzexr extends zzeth<zzexr, zzewp> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzexr zzx;
    private int zzb;
    private int zze;
    private int zzf;
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private zzewr zzj;
    private zzetq<zzexo> zzk = zzeth.zzaE();
    private String zzl = "";
    private zzexg zzm;
    private boolean zzn;
    private zzetq<String> zzo = zzeth.zzaE();
    private String zzp = "";
    private boolean zzq;
    private boolean zzr;
    private zzesf zzs = zzesf.zzb;
    private zzexq zzt;
    private zzetq<String> zzu = zzeth.zzaE();
    private zzetq<String> zzv = zzeth.zzaE();
    private byte zzw = 2;

    static {
        zzexr zzexr = new zzexr();
        zzx = zzexr;
        zzeth.zzay(zzexr.class, zzexr);
    }

    private zzexr() {
    }

    public static zzewp zze() {
        return (zzewp) zzx.zzas();
    }

    static /* synthetic */ void zzg(zzexr zzexr, zzexj zzexj) {
        zzexr.zze = zzexj.zza();
        zzexr.zzb |= 1;
    }

    static /* synthetic */ void zzh(zzexr zzexr, String str) {
        str.getClass();
        zzexr.zzb |= 4;
        zzexr.zzg = str;
    }

    static /* synthetic */ void zzi(zzexr zzexr, String str) {
        str.getClass();
        zzexr.zzb |= 8;
        zzexr.zzh = str;
    }

    static /* synthetic */ void zzj(zzexr zzexr, zzewr zzewr) {
        zzewr.getClass();
        zzexr.zzj = zzewr;
        zzexr.zzb |= 32;
    }

    static /* synthetic */ void zzk(zzexr zzexr, zzexo zzexo) {
        zzexo.getClass();
        zzetq<zzexo> zzetq = zzexr.zzk;
        if (!zzetq.zza()) {
            zzexr.zzk = zzeth.zzaF(zzetq);
        }
        zzexr.zzk.add(zzexo);
    }

    static /* synthetic */ void zzl(zzexr zzexr, String str) {
        zzexr.zzb |= 64;
        zzexr.zzl = str;
    }

    static /* synthetic */ void zzm(zzexr zzexr) {
        zzexr.zzb &= -65;
        zzexr.zzl = zzx.zzl;
    }

    static /* synthetic */ void zzn(zzexr zzexr, zzexg zzexg) {
        zzexg.getClass();
        zzexr.zzm = zzexg;
        zzexr.zzb |= 128;
    }

    static /* synthetic */ void zzo(zzexr zzexr, zzexq zzexq) {
        zzexq.getClass();
        zzexr.zzt = zzexq;
        zzexr.zzb |= 8192;
    }

    static /* synthetic */ void zzp(zzexr zzexr, Iterable iterable) {
        zzetq<String> zzetq = zzexr.zzu;
        if (!zzetq.zza()) {
            zzexr.zzu = zzeth.zzaF(zzetq);
        }
        zzerp.zzar(iterable, zzexr.zzu);
    }

    static /* synthetic */ void zzq(zzexr zzexr, Iterable iterable) {
        zzetq<String> zzetq = zzexr.zzv;
        if (!zzetq.zza()) {
            zzexr.zzv = zzeth.zzaF(zzetq);
        }
        zzerp.zzar(iterable, zzexr.zzv);
    }

    public final String zza() {
        return this.zzg;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzw);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzeth.zzaz(zzx, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzb", "zzg", "zzh", "zzi", "zzk", zzexo.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zze", zzexj.zzc(), "zzf", zzewo.zzb(), "zzj", "zzl", "zzm", "zzs", "zzt", "zzu", "zzv"});
        } else if (i2 == 3) {
            return new zzexr();
        } else {
            if (i2 == 4) {
                return new zzewp((zzewl) null);
            }
            if (i2 == 5) {
                return zzx;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzw = b;
            return null;
        }
    }

    public final List<zzexo> zzc() {
        return this.zzk;
    }

    public final String zzd() {
        return this.zzl;
    }
}
