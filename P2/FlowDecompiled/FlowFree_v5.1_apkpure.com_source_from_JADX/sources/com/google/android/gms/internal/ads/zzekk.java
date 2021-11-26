package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzekk extends zzeth<zzekk, zzekj> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzekk zzg;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzesf zze = zzesf.zzb;
    private zzekq zzf;

    static {
        zzekk zzekk = new zzekk();
        zzg = zzekk;
        zzeth.zzay(zzekk.class, zzekk);
    }

    private zzekk() {
    }

    public static zzekk zze(zzesf zzesf, zzest zzest) throws zzett {
        return (zzekk) zzeth.zzaI(zzg, zzesf, zzest);
    }

    public static zzekj zzf() {
        return (zzekj) zzg.zzas();
    }

    static /* synthetic */ void zzj(zzekk zzekk, zzekq zzekq) {
        zzekq.getClass();
        zzekk.zzf = zzekq;
    }

    public final int zza() {
        return this.zzb;
    }

    /* access modifiers changed from: protected */
    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003\t", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzekk();
        } else {
            if (i2 == 4) {
                return new zzekj((zzeki) null);
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

    public final zzekq zzd() {
        zzekq zzekq = this.zzf;
        return zzekq == null ? zzekq.zzc() : zzekq;
    }
}
