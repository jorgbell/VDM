package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzewx extends zzeth<zzewx, zzewu> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzewx zzk;
    private int zzb;
    private zzeww zze;
    private zzetq<zzewt> zzf = zzeth.zzaE();
    private zzesf zzg;
    private zzesf zzh;
    private int zzi;
    private byte zzj = 2;

    static {
        zzewx zzewx = new zzewx();
        zzk = zzewx;
        zzeth.zzay(zzewx.class, zzewx);
    }

    private zzewx() {
        zzesf zzesf = zzesf.zzb;
        this.zzg = zzesf;
        this.zzh = zzesf;
    }

    public static zzewu zza() {
        return (zzewu) zzk.zzas();
    }

    static /* synthetic */ void zzd(zzewx zzewx, zzewt zzewt) {
        zzewt.getClass();
        zzetq<zzewt> zzetq = zzewx.zzf;
        if (!zzetq.zza()) {
            zzewx.zzf = zzeth.zzaF(zzetq);
        }
        zzewx.zzf.add(zzewt);
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzeth.zzaz(zzk, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzb", "zze", "zzf", zzewt.class, "zzg", "zzh", "zzi"});
        } else if (i2 == 3) {
            return new zzewx();
        } else {
            if (i2 == 4) {
                return new zzewu((zzewl) null);
            }
            if (i2 == 5) {
                return zzk;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzj = b;
            return null;
        }
    }
}
