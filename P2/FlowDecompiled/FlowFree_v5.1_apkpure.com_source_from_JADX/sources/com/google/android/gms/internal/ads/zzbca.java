package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzbca<T> extends zzbcb<T> {
    private final T zza;

    private zzbca(T t) {
        this.zza = t;
    }

    public static <T> zzbca<T> zza(T t) {
        return new zzbca<>(t);
    }

    public final void zzb() {
        zzc(this.zza);
    }
}
