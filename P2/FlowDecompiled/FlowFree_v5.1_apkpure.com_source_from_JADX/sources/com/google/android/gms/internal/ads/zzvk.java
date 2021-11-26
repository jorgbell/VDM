package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzvk extends zzeth<zzvk, zzvj> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzvk zzh;
    private int zzb;
    private String zze = "";
    private zzetq<zzvi> zzf = zzeth.zzaE();
    private int zzg;

    static {
        zzvk zzvk = new zzvk();
        zzh = zzvk;
        zzeth.zzay(zzvk.class, zzvk);
    }

    private zzvk() {
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဌ\u0001", new Object[]{"zzb", "zze", "zzf", zzvi.class, "zzg", zzvy.zzc()});
        } else if (i2 == 3) {
            return new zzvk();
        } else {
            if (i2 == 4) {
                return new zzvj((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
