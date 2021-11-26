package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyj<T> implements zzeyl<T> {
    private zzeyw<T> zza;

    public static <T> void zza(zzeyw<T> zzeyw, zzeyw<T> zzeyw2) {
        zzeyj zzeyj = (zzeyj) zzeyw;
        if (zzeyj.zza == null) {
            zzeyj.zza = zzeyw2;
            return;
        }
        throw new IllegalStateException();
    }

    public final T zzb() {
        zzeyw<T> zzeyw = this.zza;
        if (zzeyw != null) {
            return zzeyw.zzb();
        }
        throw new IllegalStateException();
    }
}
