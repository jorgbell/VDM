package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.3 */
public final class zzdt extends zzhr<zzdt, zzds> implements zzix {
    /* access modifiers changed from: private */
    public static final zzdt zzg;
    private int zza;
    private int zze;
    private zzhx zzf = zzhr.zzbC();

    static {
        zzdt zzdt = new zzdt();
        zzg = zzdt;
        zzhr.zzby(zzdt.class, zzdt);
    }

    private zzdt() {
    }

    public static zzds zzf() {
        return (zzds) zzg.zzbt();
    }

    static /* synthetic */ void zzh(zzdt zzdt, int i) {
        zzdt.zza |= 1;
        zzdt.zze = i;
    }

    static /* synthetic */ void zzi(zzdt zzdt, Iterable iterable) {
        zzhx zzhx = zzdt.zzf;
        if (!zzhx.zza()) {
            zzdt.zzf = zzhr.zzbD(zzhx);
        }
        zzgc.zzbs(iterable, zzdt.zzf);
    }

    public final boolean zza() {
        return (this.zza & 1) != 0;
    }

    public final int zzb() {
        return this.zze;
    }

    public final List<Long> zzc() {
        return this.zzf;
    }

    public final int zzd() {
        return this.zzf.size();
    }

    public final long zze(int i) {
        return this.zzf.zzc(i);
    }

    /* access modifiers changed from: protected */
    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzhr.zzbz(zzg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zza", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzdt();
        } else {
            if (i2 == 4) {
                return new zzds((zzct) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }
}
