package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.3 */
public final class zzft {
    public static <T> zzfp<T> zza(zzfp<T> zzfp) {
        if ((zzfp instanceof zzfr) || (zzfp instanceof zzfq)) {
            return zzfp;
        }
        if (zzfp instanceof Serializable) {
            return new zzfq(zzfp);
        }
        return new zzfr(zzfp);
    }

    public static <T> zzfp<T> zzb(@NullableDecl T t) {
        return new zzfs(t);
    }
}
