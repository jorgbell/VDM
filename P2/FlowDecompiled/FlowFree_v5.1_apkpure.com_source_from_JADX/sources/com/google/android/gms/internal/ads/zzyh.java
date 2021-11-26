package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzyh extends zzeth<zzyh, zzyg> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzyh zzg;
    private int zzb;
    private boolean zze;
    private int zzf;

    static {
        zzyh zzyh = new zzyh();
        zzg = zzyh;
        zzeth.zzay(zzyh.class, zzyh);
    }

    private zzyh() {
    }

    public static zzyg zzc() {
        return (zzyg) zzg.zzas();
    }

    static /* synthetic */ void zze(zzyh zzyh, boolean z) {
        zzyh.zzb |= 1;
        zzyh.zze = z;
    }

    static /* synthetic */ void zzf(zzyh zzyh, int i) {
        zzyh.zzb |= 2;
        zzyh.zzf = i;
    }

    public final boolean zza() {
        return this.zze;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002င\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzyh();
        } else {
            if (i2 == 4) {
                return new zzyg((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
