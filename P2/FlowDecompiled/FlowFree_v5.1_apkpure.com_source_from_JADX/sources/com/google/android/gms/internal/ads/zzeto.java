package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
public final class zzeto<F, T> extends AbstractList<T> {
    private final List<F> zza;

    public zzeto(List<F> list, zzetn<F, T> zzetn) {
        this.zza = list;
    }

    public final T get(int i) {
        T zzb = zzvg.zzb(((Integer) this.zza.get(i)).intValue());
        return zzb == null ? zzvg.AD_FORMAT_TYPE_UNSPECIFIED : zzb;
    }

    public final int size() {
        return this.zza.size();
    }
}
