package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbhv {
    public final int zza;
    public final int zzb;
    private final int zzc;

    private zzbhv(int i, int i2, int i3) {
        this.zzc = i;
        this.zzb = i2;
        this.zza = i3;
    }

    public static zzbhv zza(zzyx zzyx) {
        if (zzyx.zzd) {
            return new zzbhv(3, 0, 0);
        }
        if (zzyx.zzi) {
            return new zzbhv(2, 0, 0);
        }
        if (zzyx.zzh) {
            return zzb();
        }
        return zzc(zzyx.zzf, zzyx.zzc);
    }

    public static zzbhv zzb() {
        return new zzbhv(0, 0, 0);
    }

    public static zzbhv zzc(int i, int i2) {
        return new zzbhv(1, i, i2);
    }

    public static zzbhv zzd() {
        return new zzbhv(4, 0, 0);
    }

    public static zzbhv zze() {
        return new zzbhv(5, 0, 0);
    }

    public final boolean zzf() {
        return this.zzc == 2;
    }

    public final boolean zzg() {
        return this.zzc == 3;
    }

    public final boolean zzh() {
        return this.zzc == 0;
    }

    public final boolean zzi() {
        return this.zzc == 4;
    }

    public final boolean zzj() {
        return this.zzc == 5;
    }
}
