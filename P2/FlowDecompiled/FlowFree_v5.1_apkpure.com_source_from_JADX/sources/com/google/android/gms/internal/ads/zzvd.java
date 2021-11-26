package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvd extends zzeth<zzvd, zzuv> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzvd zze;
    private zzetq<zzuu> zzb = zzeth.zzaE();

    static {
        zzvd zzvd = new zzvd();
        zze = zzvd;
        zzeth.zzay(zzvd.class, zzvd);
    }

    private zzvd() {
    }

    public static zzuv zza() {
        return (zzuv) zze.zzas();
    }

    static /* synthetic */ void zzd(zzvd zzvd, zzuu zzuu) {
        zzuu.getClass();
        zzetq<zzuu> zzetq = zzvd.zzb;
        if (!zzetq.zza()) {
            zzvd.zzb = zzeth.zzaF(zzetq);
        }
        zzvd.zzb.add(zzuu);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zze, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", zzuu.class});
        } else if (i2 == 3) {
            return new zzvd();
        } else {
            if (i2 == 4) {
                return new zzuv((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zze;
        }
    }
}
