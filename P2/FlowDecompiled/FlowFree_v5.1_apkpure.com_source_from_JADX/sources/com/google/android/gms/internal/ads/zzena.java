package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzena extends zzeth<zzena, zzemz> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzena zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzend zze;
    /* access modifiers changed from: private */
    public zzesf zzf = zzesf.zzb;

    static {
        zzena zzena = new zzena();
        zzg = zzena;
        zzeth.zzay(zzena.class, zzena);
    }

    private zzena() {
    }

    public static zzena zze(zzesf zzesf, zzest zzest) throws zzett {
        return (zzena) zzeth.zzaI(zzg, zzesf, zzest);
    }

    public static zzemz zzf() {
        return (zzemz) zzg.zzas();
    }

    static /* synthetic */ void zzi(zzena zzena, zzend zzend) {
        zzend.getClass();
        zzena.zze = zzend;
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
            return zzeth.zzaz(zzg, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zzb", "zze", "zzf"});
        } else if (i2 == 3) {
            return new zzena();
        } else {
            if (i2 == 4) {
                return new zzemz((zzemy) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzend zzc() {
        zzend zzend = this.zze;
        return zzend == null ? zzend.zzh() : zzend;
    }

    public final zzesf zzd() {
        return this.zzf;
    }
}
