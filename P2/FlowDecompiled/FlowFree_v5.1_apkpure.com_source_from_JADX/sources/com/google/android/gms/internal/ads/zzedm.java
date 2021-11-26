package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzedm {
    public static <E> ArrayList<E> zza(int i) {
        zzecw.zzb(i, "initialArraySize");
        return new ArrayList<>(i);
    }

    public static <F, T> List<T> zzb(List<F> list, zzecb<? super F, ? extends T> zzecb) {
        return new zzedl(list, zzecb);
    }
}
