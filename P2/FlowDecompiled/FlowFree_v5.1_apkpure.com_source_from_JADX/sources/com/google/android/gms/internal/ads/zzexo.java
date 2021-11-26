package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzexo extends zzeth<zzexo, zzexn> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzexo zzo;
    private int zzb;
    private int zze;
    private String zzf = "";
    private zzewx zzg;
    private zzexb zzh;
    private int zzi;
    private zzetm zzj = zzeth.zzaB();
    private String zzk = "";
    private int zzl;
    private zzetq<String> zzm = zzeth.zzaE();
    private byte zzn = 2;

    static {
        zzexo zzexo = new zzexo();
        zzo = zzexo;
        zzeth.zzay(zzexo.class, zzexo);
    }

    private zzexo() {
    }

    public static zzexn zzd() {
        return (zzexn) zzo.zzas();
    }

    static /* synthetic */ void zzf(zzexo zzexo, int i) {
        zzexo.zzb |= 1;
        zzexo.zze = i;
    }

    static /* synthetic */ void zzg(zzexo zzexo, String str) {
        str.getClass();
        zzexo.zzb |= 2;
        zzexo.zzf = str;
    }

    static /* synthetic */ void zzh(zzexo zzexo, zzewx zzewx) {
        zzewx.getClass();
        zzexo.zzg = zzewx;
        zzexo.zzb |= 4;
    }

    static /* synthetic */ void zzi(zzexo zzexo, zzexm zzexm) {
        zzexo.zzl = zzexm.zza();
        zzexo.zzb |= 64;
    }

    static /* synthetic */ void zzj(zzexo zzexo, String str) {
        str.getClass();
        zzetq<String> zzetq = zzexo.zzm;
        if (!zzetq.zza()) {
            zzexo.zzm = zzeth.zzaF(zzetq);
        }
        zzexo.zzm.add(str);
    }

    public final String zza() {
        return this.zzf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzeth.zzaz(zzo, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzexm.zzc(), "zzm"});
        } else if (i2 == 3) {
            return new zzexo();
        } else {
            if (i2 == 4) {
                return new zzexn((zzewl) null);
            }
            if (i2 == 5) {
                return zzo;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzn = b;
            return null;
        }
    }

    public final int zzc() {
        return this.zzm.size();
    }
}
