package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeny extends zzeth<zzeny, zzenv> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeny zzg;
    /* access modifiers changed from: private */
    public String zzb = "";
    /* access modifiers changed from: private */
    public zzesf zze = zzesf.zzb;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzeny zzeny = new zzeny();
        zzg = zzeny;
        zzeth.zzay(zzeny.class, zzeny);
    }

    private zzeny() {
    }

    public static zzenv zze() {
        return (zzenv) zzg.zzas();
    }

    public static zzeny zzf() {
        return zzg;
    }

    public final String zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzeny();
        } else {
            if (i2 == 4) {
                return new zzenv((zzenu) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzesf zzc() {
        return this.zze;
    }

    public final zzenx zzd() {
        zzenx zzb2 = zzenx.zzb(this.zzf);
        return zzb2 == null ? zzenx.UNRECOGNIZED : zzb2;
    }
}
