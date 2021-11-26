package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeym<T> implements zzeyl, zzeyf {
    private static final zzeym<Object> zza = new zzeym<>((Object) null);
    private final T zzb;

    private zzeym(T t) {
        this.zzb = t;
    }

    public static <T> zzeyl<T> zza(T t) {
        zzeyr.zza(t, "instance cannot be null");
        return new zzeym(t);
    }

    public static <T> zzeyl<T> zzc(T t) {
        return t == null ? zza : new zzeym(t);
    }

    public final T zzb() {
        return this.zzb;
    }
}
