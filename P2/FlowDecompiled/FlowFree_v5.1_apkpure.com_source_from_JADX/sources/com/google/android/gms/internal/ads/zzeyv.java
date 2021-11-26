package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyv<T> implements zzeyw<T> {
    private static final Object zza = new Object();
    private volatile zzeyw<T> zzb;
    private volatile Object zzc = zza;

    private zzeyv(zzeyw<T> zzeyw) {
        this.zzb = zzeyw;
    }

    public static <P extends zzeyw<T>, T> zzeyw<T> zza(P p) {
        if ((p instanceof zzeyv) || (p instanceof zzeyk)) {
            return p;
        }
        Objects.requireNonNull(p);
        return new zzeyv(p);
    }

    public final T zzb() {
        T t = this.zzc;
        if (t != zza) {
            return t;
        }
        zzeyw<T> zzeyw = this.zzb;
        if (zzeyw == null) {
            return this.zzc;
        }
        T zzb2 = zzeyw.zzb();
        this.zzc = zzb2;
        this.zzb = null;
        return zzb2;
    }
}
