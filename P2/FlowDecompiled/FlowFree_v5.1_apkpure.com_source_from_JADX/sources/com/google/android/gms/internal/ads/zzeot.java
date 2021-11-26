package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeot extends zzeth<zzeot, zzeos> implements zzeup {
    /* access modifiers changed from: private */
    public static final zzeot zzf;
    /* access modifiers changed from: private */
    public int zzb;
    private zzeow zze;

    static {
        zzeot zzeot = new zzeot();
        zzf = zzeot;
        zzeth.zzay(zzeot.class, zzeot);
    }

    private zzeot() {
    }

    public static zzeot zzd(zzesf zzesf, zzest zzest) throws zzett {
        return (zzeot) zzeth.zzaI(zzf, zzesf, zzest);
    }

    public static zzeos zze() {
        return (zzeos) zzf.zzas();
    }

    static /* synthetic */ void zzh(zzeot zzeot, zzeow zzeow) {
        zzeow.getClass();
        zzeot.zze = zzeow;
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
            return zzeth.zzaz(zzf, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzb", "zze"});
        } else if (i2 == 3) {
            return new zzeot();
        } else {
            if (i2 == 4) {
                return new zzeos((zzeor) null);
            }
            if (i2 != 5) {
                return null;
            }
            return zzf;
        }
    }

    public final zzeow zzc() {
        zzeow zzeow = this.zze;
        return zzeow == null ? zzeow.zzd() : zzeow;
    }
}
