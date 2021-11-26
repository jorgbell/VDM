package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* compiled from: com.google.android.gms:play-services-ads@@20.1.0 */
final class zzedl<F, T> extends AbstractSequentialList<T> implements Serializable {
    final List<F> zza;
    final zzecb<? super F, ? extends T> zzb;

    zzedl(List<F> list, zzecb<? super F, ? extends T> zzecb) {
        this.zza = list;
        this.zzb = zzecb;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final ListIterator<T> listIterator(int i) {
        return new zzedk(this, this.zza.listIterator(i));
    }

    public final int size() {
        return this.zza.size();
    }
}
