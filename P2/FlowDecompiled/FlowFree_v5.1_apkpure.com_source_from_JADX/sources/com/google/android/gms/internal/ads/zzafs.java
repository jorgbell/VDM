package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@20.1.0 */
public class zzafs<T> {
    private final String zza;
    private final T zzb;
    private final int zzc;

    protected zzafs(String str, T t, int i) {
        this.zza = str;
        this.zzb = t;
        this.zzc = i;
    }

    public static zzafs<Boolean> zza(String str, boolean z) {
        return new zzafs<>(str, Boolean.valueOf(z), 1);
    }

    public static zzafs<Long> zzb(String str, long j) {
        return new zzafs<>(str, Long.valueOf(j), 2);
    }

    public static zzafs<Double> zzc(String str, double d) {
        return new zzafs<>(str, Double.valueOf(d), 3);
    }

    public static zzafs<String> zzd(String str, String str2) {
        return new zzafs<>(str, str2, 4);
    }

    public final T zze() {
        zzagp zza2 = zzagq.zza();
        if (zza2 != null) {
            int i = this.zzc - 1;
            if (i == 0) {
                return zza2.zza(this.zza, ((Boolean) this.zzb).booleanValue());
            }
            if (i == 1) {
                return zza2.zzb(this.zza, ((Long) this.zzb).longValue());
            }
            if (i != 2) {
                return zza2.zzd(this.zza, (String) this.zzb);
            }
            return zza2.zzc(this.zza, ((Double) this.zzb).doubleValue());
        }
        throw new IllegalStateException("Flag is not initialized.");
    }
}
