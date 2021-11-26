package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeop extends zzeth<zzeop, zzeoo> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeop zzh;
    private String zzb = "";
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzeop zzeop = new zzeop();
        zzh = zzeop;
        zzeth.zzay(zzeop.class, zzeop);
    }

    private zzeop() {
    }

    public static zzeoo zza() {
        return (zzeoo) zzh.zzas();
    }

    static /* synthetic */ void zzd(zzeop zzeop, String str) {
        str.getClass();
        zzeop.zzb = str;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzb", "zze", "zzf", "zzg"});
        } else if (i2 == 3) {
            return new zzeop();
        } else {
            if (i2 == 4) {
                return new zzeoo((zzeom) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzh;
        }
    }
}
