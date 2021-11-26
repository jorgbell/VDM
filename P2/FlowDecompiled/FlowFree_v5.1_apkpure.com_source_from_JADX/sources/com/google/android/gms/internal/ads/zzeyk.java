package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeyk<T> implements zzeyw, zzeyf {
    private static final Object zza = new Object();
    private volatile zzeyw<T> zzb;
    private volatile Object zzc = zza;

    private zzeyk(zzeyw<T> zzeyw) {
        this.zzb = zzeyw;
    }

    public static <P extends zzeyw<T>, T> zzeyf<T> zzc(P p) {
        if (p instanceof zzeyf) {
            return (zzeyf) p;
        }
        Objects.requireNonNull(p);
        return new zzeyk(p);
    }

    public final T zzb() {
        T t = this.zzc;
        T t2 = zza;
        if (t == t2) {
            synchronized (this) {
                t = this.zzc;
                if (t == t2) {
                    t = this.zzb.zzb();
                    T t3 = this.zzc;
                    if (t3 != t2) {
                        if (t3 != t) {
                            String valueOf = String.valueOf(t3);
                            String valueOf2 = String.valueOf(t);
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 118 + String.valueOf(valueOf2).length());
                            sb.append("Scoped provider was invoked recursively returning different results: ");
                            sb.append(valueOf);
                            sb.append(" & ");
                            sb.append(valueOf2);
                            sb.append(". This is likely due to a circular dependency.");
                            throw new IllegalStateException(sb.toString());
                        }
                    }
                    this.zzc = t;
                    this.zzb = null;
                }
            }
        }
        return t;
    }

    public static <P extends zzeyw<T>, T> zzeyw<T> zza(P p) {
        Objects.requireNonNull(p);
        if (p instanceof zzeyk) {
            return p;
        }
        return new zzeyk(p);
    }
}
