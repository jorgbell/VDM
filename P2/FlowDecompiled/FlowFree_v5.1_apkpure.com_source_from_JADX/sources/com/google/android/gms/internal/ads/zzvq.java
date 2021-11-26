package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvq extends zzeth<zzvq, zzvp> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzvq zzm;
    private int zzb;
    private String zze = "";
    private zzxi zzf;
    private int zzg;
    private zzxk zzh;
    private int zzi;
    private int zzj = 1000;
    private int zzk = 1000;
    private int zzl = 1000;

    static {
        zzvq zzvq = new zzvq();
        zzm = zzvq;
        zzeth.zzay(zzvq.class, zzvq);
    }

    private zzvq() {
    }

    public static zzvq zza() {
        return zzm;
    }

    static /* synthetic */ void zzd(zzvq zzvq, String str) {
        zzvq.zzb |= 1;
        zzvq.zze = str;
    }

    static /* synthetic */ void zze(zzvq zzvq, zzxk zzxk) {
        zzxk.getClass();
        zzvq.zzh = zzxk;
        zzvq.zzb |= 8;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzm, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001\u0003င\u0002\u0004ဉ\u0003\u0005င\u0004\u0006ဌ\u0005\u0007ဌ\u0006\bဌ\u0007", new Object[]{"zzb", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzvy.zzc(), "zzk", zzvy.zzc(), "zzl", zzvy.zzc()});
        } else if (i2 == 3) {
            return new zzvq();
        } else {
            if (i2 == 4) {
                return new zzvp((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzm;
        }
    }
}
