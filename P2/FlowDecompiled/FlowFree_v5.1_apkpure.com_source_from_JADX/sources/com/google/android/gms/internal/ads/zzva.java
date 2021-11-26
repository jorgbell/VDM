package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzva extends zzeth<zzva, zzuz> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzva zzg;
    private int zzb;
    private boolean zze;
    private int zzf;

    static {
        zzva zzva = new zzva();
        zzg = zzva;
        zzeth.zzay(zzva.class, zzva);
    }

    private zzva() {
    }

    public static zzuz zza() {
        return (zzuz) zzg.zzas();
    }

    static /* synthetic */ void zzd(zzva zzva, boolean z) {
        zzva.zzb |= 1;
        zzva.zze = z;
    }

    static /* synthetic */ void zze(zzva zzva, int i) {
        zzva.zzb |= 2;
        zzva.zzf = i;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဋ\u0001", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzva();
        } else {
            if (i2 == 4) {
                return new zzuz((zzun) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
