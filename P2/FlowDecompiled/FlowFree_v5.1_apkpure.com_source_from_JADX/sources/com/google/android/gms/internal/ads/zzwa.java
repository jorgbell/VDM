package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzwa extends zzeth<zzwa, zzvz> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzwa zzr;
    private int zzb;
    private int zze;
    private String zzf = "";
    private int zzg;
    private int zzh = 1000;
    private zzxk zzi;
    /* access modifiers changed from: private */
    public zzetp zzj = zzeth.zzaD();
    private zzvq zzk;
    private zzvv zzl;
    private zzwo zzm;
    private zzus zzn;
    private zzwy zzo;
    private zzyh zzp;
    private zzvd zzq;

    static {
        zzwa zzwa = new zzwa();
        zzr = zzwa;
        zzeth.zzay(zzwa.class, zzwa);
    }

    private zzwa() {
    }

    public static zzvz zze() {
        return (zzvz) zzr.zzas();
    }

    static /* synthetic */ void zzg(zzwa zzwa, String str) {
        str.getClass();
        zzwa.zzb |= 2;
        zzwa.zzf = str;
    }

    static /* synthetic */ void zzh(zzwa zzwa, Iterable iterable) {
        zzetp zzetp = zzwa.zzj;
        if (!zzetp.zza()) {
            int size = zzetp.size();
            zzwa.zzj = zzetp.zzc(size == 0 ? 10 : size + size);
        }
        zzerp.zzar(iterable, zzwa.zzj);
    }

    static /* synthetic */ void zzj(zzwa zzwa, zzvq zzvq) {
        zzvq.getClass();
        zzwa.zzk = zzvq;
        zzwa.zzb |= 32;
    }

    static /* synthetic */ void zzk(zzwa zzwa, zzus zzus) {
        zzus.getClass();
        zzwa.zzn = zzus;
        zzwa.zzb |= 256;
    }

    static /* synthetic */ void zzl(zzwa zzwa, zzwy zzwy) {
        zzwy.getClass();
        zzwa.zzo = zzwy;
        zzwa.zzb |= 512;
    }

    static /* synthetic */ void zzm(zzwa zzwa, zzyh zzyh) {
        zzyh.getClass();
        zzwa.zzp = zzyh;
        zzwa.zzb |= 1024;
    }

    static /* synthetic */ void zzn(zzwa zzwa, zzvd zzvd) {
        zzvd.getClass();
        zzwa.zzq = zzvd;
        zzwa.zzb |= 2048;
    }

    public final String zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzr, "\u0001\r\u0000\u0001\t\u0015\r\u0000\u0001\u0000\tင\u0000\nဈ\u0001\u000bဋ\u0002\fဌ\u0003\rဉ\u0004\u000e\u0015\u000fဉ\u0005\u0010ဉ\u0006\u0011ဉ\u0007\u0012ဉ\b\u0013ဉ\t\u0014ဉ\n\u0015ဉ\u000b", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", zzvy.zzc(), "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq"});
        } else if (i2 == 3) {
            return new zzwa();
        } else {
            if (i2 == 4) {
                return new zzvz((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzr;
        }
    }

    public final zzvq zzc() {
        zzvq zzvq = this.zzk;
        return zzvq == null ? zzvq.zza() : zzvq;
    }

    public final zzus zzd() {
        zzus zzus = this.zzn;
        return zzus == null ? zzus.zzc() : zzus;
    }
}
