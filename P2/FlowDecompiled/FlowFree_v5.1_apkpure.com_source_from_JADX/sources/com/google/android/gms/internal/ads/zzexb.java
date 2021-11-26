package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzexb extends zzeth<zzexb, zzewy> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzexb zzl;
    private int zzb;
    private zzexa zze;
    private zzetq<zzewt> zzf = zzeth.zzaE();
    private zzesf zzg;
    private zzesf zzh;
    private int zzi;
    private zzesf zzj;
    private byte zzk = 2;

    static {
        zzexb zzexb = new zzexb();
        zzl = zzexb;
        zzeth.zzay(zzexb.class, zzexb);
    }

    private zzexb() {
        zzesf zzesf = zzesf.zzb;
        this.zzg = zzesf;
        this.zzh = zzesf;
        this.zzj = zzesf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzeth.zzaz(zzl, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzb", "zze", "zzf", zzewt.class, "zzg", "zzh", "zzi", "zzj"});
        } else if (i2 == 3) {
            return new zzexb();
        } else {
            if (i2 == 4) {
                return new zzewy((zzewl) null);
            }
            if (i2 == 5) {
                return zzl;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzk = b;
            return null;
        }
    }
}
