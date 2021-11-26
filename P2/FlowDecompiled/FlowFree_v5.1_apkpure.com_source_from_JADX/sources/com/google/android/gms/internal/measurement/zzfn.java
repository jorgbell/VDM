package com.google.android.gms.internal.measurement;

import java.io.Serializable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public abstract class zzfn<T> implements Serializable {
    zzfn() {
    }

    public static <T> zzfn<T> zzc() {
        return zzfl.zza;
    }

    public static <T> zzfn<T> zzd(T t) {
        return new zzfo(t);
    }

    public abstract boolean zza();

    public abstract T zzb();
}
