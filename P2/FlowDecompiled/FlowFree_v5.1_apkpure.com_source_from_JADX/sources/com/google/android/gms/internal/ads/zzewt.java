package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzewt extends zzeth<zzewt, zzews> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzewt zzh;
    private int zzb;
    private zzesf zze;
    private zzesf zzf;
    private byte zzg = 2;

    static {
        zzewt zzewt = new zzewt();
        zzh = zzewt;
        zzeth.zzay(zzewt.class, zzewt);
    }

    private zzewt() {
        zzesf zzesf = zzesf.zzb;
        this.zze = zzesf;
        this.zzf = zzesf;
    }

    public static zzews zza() {
        return (zzews) zzh.zzas();
    }

    static /* synthetic */ void zzd(zzewt zzewt, zzesf zzesf) {
        zzewt.zzb |= 1;
        zzewt.zze = zzesf;
    }

    static /* synthetic */ void zze(zzewt zzewt, zzesf zzesf) {
        zzewt.zzb |= 2;
        zzewt.zzf = zzesf;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        byte b = 1;
        if (i2 == 2) {
            return zzeth.zzaz(zzh, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzewt();
        } else {
            if (i2 == 4) {
                return new zzews((zzewl) null);
            }
            if (i2 == 5) {
                return zzh;
            }
            if (obj == null) {
                b = 0;
            }
            this.zzg = b;
            return null;
        }
    }
}
