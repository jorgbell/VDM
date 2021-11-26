package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzepk extends zzeth<zzepk, zzepj> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzepk zzf;
    /* access modifiers changed from: private */
    public int zzb;
    /* access modifiers changed from: private */
    public zzesf zze = zzesf.zzb;

    static {
        zzepk zzepk = new zzepk();
        zzf = zzepk;
        zzeth.zzay(zzepk.class, zzepk);
    }

    private zzepk() {
    }

    public static zzepk zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzepk) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public static zzepj zze() {
        return (zzepj) zzf.zzas();
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
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzepk();
        } else {
            if (i2 == 4) {
                return new zzepj((zzepi) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzesf zzc() {
        return this.zze;
    }
}
