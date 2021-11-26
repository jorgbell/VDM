package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzwy extends zzeth<zzwy, zzwu> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzwy zzl;
    private int zzb;
    private zzetq<zzwt> zze = zzeth.zzaE();
    private int zzf;
    private int zzg;
    private long zzh;
    private String zzi = "";
    private String zzj = "";
    private long zzk;

    static {
        zzwy zzwy = new zzwy();
        zzl = zzwy;
        zzeth.zzay(zzwy.class, zzwy);
    }

    private zzwy() {
    }

    public static zzwu zza() {
        return (zzwu) zzl.zzas();
    }

    static /* synthetic */ void zzd(zzwy zzwy, Iterable iterable) {
        zzetq<zzwt> zzetq = zzwy.zze;
        if (!zzetq.zza()) {
            zzwy.zze = zzeth.zzaF(zzetq);
        }
        zzerp.zzar(iterable, zzwy.zze);
    }

    static /* synthetic */ void zze(zzwy zzwy, int i) {
        zzwy.zzb |= 1;
        zzwy.zzf = i;
    }

    static /* synthetic */ void zzf(zzwy zzwy, int i) {
        zzwy.zzb |= 2;
        zzwy.zzg = i;
    }

    static /* synthetic */ void zzg(zzwy zzwy, long j) {
        zzwy.zzb |= 4;
        zzwy.zzh = j;
    }

    static /* synthetic */ void zzh(zzwy zzwy, String str) {
        str.getClass();
        zzwy.zzb |= 8;
        zzwy.zzi = str;
    }

    static /* synthetic */ void zzi(zzwy zzwy, String str) {
        str.getClass();
        zzwy.zzb |= 16;
        zzwy.zzj = str;
    }

    static /* synthetic */ void zzj(zzwy zzwy, long j) {
        zzwy.zzb |= 32;
        zzwy.zzk = j;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzl, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u001b\u0002င\u0000\u0003င\u0001\u0004ဂ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဂ\u0005", new Object[]{"zzb", "zze", zzwt.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        } else if (i2 == 3) {
            return new zzwy();
        } else {
            if (i2 == 4) {
                return new zzwu((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzl;
        }
    }
}
