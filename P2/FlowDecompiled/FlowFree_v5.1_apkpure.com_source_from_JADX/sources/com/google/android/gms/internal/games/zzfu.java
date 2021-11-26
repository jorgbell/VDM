package com.google.android.gms.internal.games;

/* compiled from: com.google.android.gms:play-services-games@@21.0.0 */
public abstract class zzfu<E> {
    zzfu() {
    }

    public abstract zzfu<E> zzc(E e);

    public zzfu<E> zza(Iterable<? extends E> iterable) {
        for (Object zzc : iterable) {
            zzc(zzc);
        }
        return this;
    }
}
