package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzwo extends zzeth<zzwo, zzwh> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzwo zzg;
    private int zzb;
    private int zze;
    private int zzf;

    static {
        zzwo zzwo = new zzwo();
        zzg = zzwo;
        zzeth.zzay(zzwo.class, zzwo);
    }

    private zzwo() {
    }

    public static zzwh zzf() {
        return (zzwh) zzg.zzas();
    }

    public static zzwo zzg() {
        return zzg;
    }

    static /* synthetic */ void zzi(zzwo zzwo, zzwn zzwn) {
        zzwo.zze = zzwn.zza();
        zzwo.zzb |= 1;
    }

    static /* synthetic */ void zzj(zzwo zzwo, zzwk zzwk) {
        zzwo.zzf = zzwk.zza();
        zzwo.zzb |= 2;
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzb", "zze", zzwn.zzc(), "zzf", zzwk.zzc()});
        } else if (i2 == 3) {
            return new zzwo();
        } else {
            if (i2 == 4) {
                return new zzwh((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzwn zzc() {
        zzwn zzb2 = zzwn.zzb(this.zze);
        return zzb2 == null ? zzwn.NETWORKTYPE_UNSPECIFIED : zzb2;
    }

    public final boolean zzd() {
        return (this.zzb & 2) != 0;
    }

    public final zzwk zze() {
        zzwk zzb2 = zzwk.zzb(this.zzf);
        return zzb2 == null ? zzwk.CELLULAR_NETWORK_TYPE_UNSPECIFIED : zzb2;
    }
}
