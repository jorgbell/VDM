package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeli extends zzeth<zzeli, zzelh> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeli zzg;
    /* access modifiers changed from: private */
    public int zzb;
    private zzelo zze;
    /* access modifiers changed from: private */
    public zzesf zzf = zzesf.zzb;

    static {
        zzeli zzeli = new zzeli();
        zzg = zzeli;
        zzeth.zzay(zzeli.class, zzeli);
    }

    private zzeli() {
    }

    public static zzeli zze(zzesf zzesf, zzest zzest) throws zzett {
        return (zzeli) zzeth.zzaI(zzg, zzesf, zzest);
    }

    public static zzelh zzf() {
        return (zzelh) zzg.zzas();
    }

    static /* synthetic */ void zzi(zzeli zzeli, zzelo zzelo) {
        zzelo.getClass();
        zzeli.zze = zzelo;
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
            return new zzeli();
        } else {
            if (i2 == 4) {
                return new zzelh((zzelg) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzg;
        }
    }

    public final zzelo zzc() {
        zzelo zzelo = this.zze;
        return zzelo == null ? zzelo.zzc() : zzelo;
    }

    public final zzesf zzd() {
        return this.zzf;
    }
}
